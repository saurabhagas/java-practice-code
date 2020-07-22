package com.saurabh.source.data_structures;

import com.saurabh.source.common.Node;
import com.saurabh.source.common.Tuple;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

import static com.saurabh.source.algorithms.traversal.Traversals.inorder;
import static java.lang.Math.max;

public class BinarySearchTree<T extends Comparable<T>> implements Cloneable {
  private Node<T> root;

  public boolean insert(T data) {
    Node<T> temp = new Node<>(data, null, null);
    Node<T> current = root;
    while (current != null) {
      if (data.compareTo(current.data()) < 0) {
        if (current.lChild() == null) {
          current.lChild(temp);
          break;
        }
        current = current.lChild();
      } else if (data.compareTo(current.data()) > 0) {
        if (current.rChild() == null) {
          current.rChild(temp);
          break;
        }
        current = current.rChild();
      } else {
        return false;
      }
    }

    if (root == null) {
      root = temp;
    }
    return true;
  }

  public void clear() {
    root = null;
  }

  public boolean remove(T data) {
    Tuple<Node<T>, Node<T>> searchResult = searchInternal(data);
    Node<T> foundLocation = searchResult.getT1();
    Node<T> foundLocationParent = searchResult.getT2();

    // Node to be deleted not found
    if (foundLocation == null) return false;

    // Node to be deleted is a leaf
    if (foundLocation.lChild() == null && foundLocation.rChild() == null) {
      if (foundLocationParent == null) {
        root = null;
      } else if (foundLocation == foundLocationParent.lChild()) {
        foundLocationParent.lChild(null);
      } else {
        foundLocationParent.rChild(null);
      }
      return true;
    }

    // Node to be deleted has only the left child
    if (foundLocation.lChild() != null && foundLocation.rChild() == null) {
      if (foundLocationParent == null) {
        root = foundLocation.lChild();
      } else if (foundLocation == foundLocationParent.lChild()) {
        foundLocationParent.lChild(foundLocation.lChild());
      } else {
        foundLocationParent.rChild(foundLocation.lChild());
      }
      return true;
    }

    // Node to be deleted has only the right child
    if (foundLocation.lChild() == null && foundLocation.rChild() != null) {
      if (foundLocationParent == null) {
        root = foundLocation.rChild();
      } else if (foundLocation == foundLocationParent.lChild()) {
        foundLocationParent.lChild(foundLocation.rChild());
      } else {
        foundLocationParent.rChild(foundLocation.rChild());
      }
      return true;
    }

    // Node to be deleted has both children - replace node with its inorder successor
    Tuple<Node<T>, Node<T>> successorResult = getInorderSuccessor(foundLocation.rChild(), foundLocation);
    Node<T> inOrderSuccessor = successorResult.getT1();
    Node<T> inOrderSuccessorParent = successorResult.getT2();
    // Put inorder successor's data in the current node, and correct the inorder successor pointers
    foundLocation.data(inOrderSuccessor.data());
    if (inOrderSuccessor.lChild() == null && inOrderSuccessor.rChild() == null) {
      if (inOrderSuccessor == inOrderSuccessorParent.lChild()) {
        inOrderSuccessorParent.lChild(null);
      } else {
        inOrderSuccessorParent.rChild(null);
      }
    } else if (inOrderSuccessor.lChild() == null) {
      if (inOrderSuccessor == inOrderSuccessorParent.lChild()) {
        inOrderSuccessorParent.lChild(inOrderSuccessor.lChild());
      } else {
        inOrderSuccessorParent.rChild(inOrderSuccessor.rChild());
      }
    }
    return true;
  }

  private Tuple<Node<T>, Node<T>> getInorderSuccessor(Node<T> root, Node<T> parent) {
    Node<T> current = root;
    Node<T> currentParent = parent;
    while (true) {
      if (current.lChild() == null) {
        return Tuple.of(current, currentParent);
      }
      currentParent = current;
      current = current.lChild();
    }
  }

  public Node<T> search(T data) {
    return searchInternal(data).getT1();
  }

  // Returns the <node, node-parent> tuple if a node is found, <root, null> for root node and <null, null> otherwise
  private Tuple<Node<T>, Node<T>> searchInternal(T data) {
    Node<T> current = root;
    Node<T> foundLocationParent = null;
    Node<T> foundLocation = null;
    while (current != null) {
      if ((current.lChild() != null && current.lChild().data() == data) ||
          (current.rChild() != null && current.rChild().data() == data)) {
        foundLocationParent = current;
      }
      if (data.compareTo(current.data()) < 0) {
        current = current.lChild();
      } else if (data.compareTo(current.data()) > 0) {
        current = current.rChild();
      } else {
        foundLocation = current;
        break;
      }
    }
    return Tuple.of(foundLocation, foundLocationParent);
  }

  public List<T> getAncestors(T data) {
    Node<T> current = root;
    boolean found = false;
    ArrayList<T> items = new ArrayList<>();
    while (current != null) {
      items.add(current.data());
      if (data.compareTo(current.data()) < 0) {
        current = current.lChild();
      } else if (data.compareTo(current.data()) > 0) {
        current = current.rChild();
      } else {
        found = true;
        break;
      }
    }

    if (found) {
      items.remove(items.size() - 1);
      return items;
    } else {
      return null;
    }
  }

  public List<T> inOrder() {
    ArrayList<T> items = new ArrayList<>();
    inorder(root, items);
    return items;
  }

  public int size() {
    return inOrder().size();
  }

  public int height() {
    return heightInternal(root);
  }

  public Node<T> getRoot() {
    return root;
  }

  /**
   * One time balancing of the BST. Saves the inorder (i.e. sorted data) traversal of the original tree, nullifies the tree,
   * and constructs a new tree recursively from this sorted list. Works in O(n) time and O(n) space.
   */
  public void balance() {
    List<T> list = inOrder();
    root = null; // Nullify root, making the entire tree eligible for GC
    insertRecurse(list, 0, list.size());
  }

  private void insertRecurse(List<T> list, int low, int high) {
    if (low >= high) return;

    int mid = (low + high) / 2;
    insert(list.get(mid));
    insertRecurse(list, low, mid);
    insertRecurse(list, mid + 1, high);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    BinarySearchTree<T> other = (BinarySearchTree<T>) o;
    return areEqual(this.root, other.root);
  }

  private boolean areEqual(Node<T> rootOne, Node<T> rootTwo) {
    if (rootOne == null && rootTwo != null) return false;
    if (rootOne != null && rootTwo == null) return false;
    if (rootOne == null && rootTwo == null) return true;

    return rootOne.data().equals(rootTwo.data()) &&
        areEqual(rootOne.lChild(), rootTwo.lChild()) &&
        areEqual(rootOne.rChild(), rootTwo.rChild());
  }

  @Override
  public int hashCode() {
    List<Node<T>> allElements = new ArrayList<>();
    Deque<Node<T>> deque = new ArrayDeque<>();
    offerNonNull(deque, root);

    while (!deque.isEmpty()) {
      Node<T> current = deque.poll();
      allElements.add(current);
      System.out.println(current.data());
      offerNonNull(deque, current.lChild());
      offerNonNull(deque, current.rChild());
    }

    return Objects.hash(allElements.toArray());
  }

  @Override
  public BinarySearchTree<T> clone() throws CloneNotSupportedException {
    super.clone();
    BinarySearchTree<T> cloneTree = new BinarySearchTree<>();
    clone(cloneTree, root);
    return cloneTree;
  }

  private void clone(BinarySearchTree<T> cloneTree, Node<T> thisRoot) {
    if (thisRoot == null) return;
    cloneTree.insert(thisRoot.data());
    clone(cloneTree, thisRoot.lChild());
    clone(cloneTree, thisRoot.rChild());
  }

  @Override
  public String toString() {
    return inOrder().toString();
  }

  private int heightInternal(Node<T> root) {
    if (root == null) return 0;
    return max(heightInternal(root.lChild()), heightInternal(root.rChild())) + 1;
  }

  private void offerNonNull(Deque<Node<T>> deque, Node<T> node) {
    if (node != null) deque.offer(node);
  }
}
