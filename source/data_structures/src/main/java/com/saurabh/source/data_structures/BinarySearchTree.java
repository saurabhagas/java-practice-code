package com.saurabh.source.data_structures;

import com.saurabh.source.common.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

import static com.saurabh.source.algorithms.traversal.Traversals.inorder;
import static com.saurabh.source.algorithms.traversal.Traversals.breadthFirst;
import static com.saurabh.source.algorithms.traversal.Traversals.postorder;
import static com.saurabh.source.algorithms.traversal.Traversals.preorder;
import static java.lang.Math.max;

public class BinarySearchTree<T extends Comparable<T>> {
  private Node<T> root;

  public boolean insert(T data) {
    Node<T> temp = new Node<>(data, null, null);
    Node<T> current = root;
    while (current != null) {
      if (data.compareTo(current.getData()) < 0) {
        if (current.getLeftChild() == null) {
          current.setLeftChild(temp);
          break;
        }
        current = current.getLeftChild();
      } else if (data.compareTo(current.getData()) > 0) {
        if (current.getRightChild() == null) {
          current.setRightChild(temp);
          break;
        }
        current = current.getRightChild();
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
    Node<T> current = root;
    Node<T> foundLocationParent = null;
    Node<T> foundLocation = null;
    while (current != null) {
      if ((current.getLeftChild() != null && current.getLeftChild().getData() == data) || (current.getRightChild() != null && current.getRightChild().getData() == data)) {
        foundLocationParent = current;
      }
      if (data.compareTo(current.getData()) < 0) {
        current = current.getLeftChild();
      } else if (data.compareTo(current.getData()) > 0) {
        current = current.getRightChild();
      } else {
        foundLocation = current;
        break;
      }
    }

    if (foundLocation == null) {
      return false; // Node<T> to be deleted not present
    } else if (foundLocation == root) {
      if (foundLocation.getLeftChild() == null && foundLocation.getRightChild() == null) {
        root = null;
      } else if (foundLocation.getLeftChild() == null && foundLocation.getRightChild() != null) {
        root = root.getRightChild();
      } else if (foundLocation.getLeftChild() != null && foundLocation.getRightChild() == null) {
        root = root.getLeftChild();
      } else {
        // Both children present, swap node with inorder successor
        current = foundLocation.getRightChild(); // start from the right subtree
        Node<T> inorderSuccessorParent = null;
        Node<T> inorderSuccessor;
        while (current != null && current.getLeftChild() != null) {
          if (current.getLeftChild().getLeftChild() == null) {
            inorderSuccessorParent = current;
          }
          current = current.getLeftChild();
        }
        inorderSuccessor = current;

        if (inorderSuccessor.getRightChild() == null) {
          foundLocation.setData(inorderSuccessor.getData());
          if (inorderSuccessorParent == null) {
            foundLocation.setRightChild(null);
          } else {
            inorderSuccessorParent.setLeftChild(null);
          }
        } else {
          foundLocation.setData(inorderSuccessor.getData());
          inorderSuccessor.setData(inorderSuccessor.getRightChild().getData());
          inorderSuccessor.setRightChild(null);
        }
      }
      return true;
    } else {
      if (foundLocation.getLeftChild() == null && foundLocation.getRightChild() == null) {
        if (foundLocationParent.getLeftChild() == foundLocation) {
          foundLocationParent.setLeftChild(null);
        } else {
          foundLocationParent.setRightChild(null);
        }
      } else if (foundLocation.getLeftChild() == null && foundLocation.getRightChild() != null) {
        if (foundLocationParent.getLeftChild() == foundLocation) {
          foundLocationParent.setLeftChild(foundLocation.getRightChild());
        } else {
          foundLocationParent.setRightChild(foundLocation.getRightChild());
        }
      } else if (foundLocation.getLeftChild() != null && foundLocation.getRightChild() == null) {
        if (foundLocationParent.getLeftChild() == foundLocation) {
          foundLocationParent.setLeftChild(foundLocation.getLeftChild());
        } else {
          foundLocationParent.setRightChild(foundLocation.getLeftChild());
        }
      } else {
        // Both children present, swap node with inorder successor
        current = foundLocation.getRightChild(); // start from the right subtree
        Node<T> inorderSuccessorParent = null;
        Node<T> inorderSuccessor;
        while (current != null && current.getLeftChild() != null) {
          if (current.getLeftChild().getLeftChild() == null) {
            inorderSuccessorParent = current;
          }
          current = current.getLeftChild();
        }
        inorderSuccessor = current;

        if (inorderSuccessor.getRightChild() == null) {
          foundLocation.setData(inorderSuccessor.getData());
          if (inorderSuccessorParent == null) {
            foundLocation.setRightChild(null);
          } else {
            inorderSuccessorParent.setLeftChild(null);
          }
        } else {
          foundLocation.setData(inorderSuccessor.getData());
          inorderSuccessor.setData(inorderSuccessor.getRightChild().getData());
          inorderSuccessor.setRightChild(null);
        }
      }
      return true;
    }
  }

  public Node<T> search(T data) {
    Node<T> current = root;
    while (current != null) {
      if (data.compareTo(current.getData()) < 0) {
        current = current.getLeftChild();
      } else if (data.compareTo(current.getData()) > 0) {
        current = current.getRightChild();
      } else {
        return current;
      }
    }
    return null;
  }

  public List<T> getAncestors(T data) {
    Node<T> current = root;
    boolean found = false;
    ArrayList<T> items = new ArrayList<>();
    while (current != null) {
      items.add(current.getData());
      if (data.compareTo(current.getData()) < 0) {
        current = current.getLeftChild();
      } else if (data.compareTo(current.getData()) > 0) {
        current = current.getRightChild();
      } else {
        found = true;
        break;
      }
    }

    if (found) {
      items.remove(items.size() - 1);
      return items;
    } else {
      throw new RuntimeException("Node<T> not present in tree");
    }
  }

  public void levelOrder() {
    breadthFirst(root);
  }

  public List<T> preOrder() {
    ArrayList<T> items = new ArrayList<>();
    preorder(root, items);
    return items;
  }

  public List<T> inOrder() {
    ArrayList<T> items = new ArrayList<>();
    inorder(root, items);
    return items;
  }

  public List<T> postOrder() {
    ArrayList<T> items = new ArrayList<>();
    postorder(root, items);
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
   * and constructs a new tree recursively from this sorted list. Works on O(n) time and O(n) space.
   */
  public void balance() {
    final ArrayList<T> list = new ArrayList<>();
    inorder(root, list);
    root = null; // Nullify root, making the entire tree eligible for GC
    insertRecurse(list, 0, list.size());
    System.out.println("Tree balancing done");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    BinarySearchTree other = (BinarySearchTree) o;

    Deque<Node<T>> thisDeque = new ArrayDeque<>();
    Deque<Node<T>> otherDeque = new ArrayDeque<>();
    offerNonNull(thisDeque, this.root);
    offerNonNull(otherDeque, other.root);

    while (!thisDeque.isEmpty() && !otherDeque.isEmpty()) {
      Node<T> thisCurrent = thisDeque.poll();
      Node<T> otherCurrent = otherDeque.poll();
      if (thisCurrent.getData() != otherCurrent.getData()) {
        return false;
      }

      offerNonNull(thisDeque, thisCurrent.getLeftChild());
      offerNonNull(thisDeque, thisCurrent.getRightChild());
      offerNonNull(otherDeque, otherCurrent.getLeftChild());
      offerNonNull(otherDeque, otherCurrent.getRightChild());
    }

    return thisDeque.isEmpty() && otherDeque.isEmpty();
  }

  @Override
  public int hashCode() {
    List<Node<T>> allElements = new ArrayList<>();
    Deque<Node<T>> deque = new ArrayDeque<>();
    offerNonNull(deque, root);

    while (!deque.isEmpty()) {
      Node<T> current = deque.poll();
      allElements.add(current);
      System.out.println(current.getData());
      offerNonNull(deque, current.getLeftChild());
      offerNonNull(deque, current.getRightChild());
    }

    return Objects.hash(allElements.toArray());
  }

  /**
   * Prints preorder traversal using stacks
   *
   * @return nodes as a String
   */
  @Override
  public String toString() {
    StringBuilder nodesAsString = new StringBuilder();
    Deque<Node<T>> deque = new ArrayDeque<>();
    pushNonNull(deque, root);

    while (!deque.isEmpty()) {
      final Node<T> current = deque.pop();
      nodesAsString.append(current.getData()).append(" ");
      pushNonNull(deque, current.getRightChild());
      pushNonNull(deque, current.getLeftChild());
    }

    return nodesAsString.toString().trim();
  }

  private int heightInternal(Node<T> root) {
    if (root != null) {
      return max(heightInternal(root.getLeftChild()), heightInternal(root.getRightChild())) + 1;
    }
    return 0;
  }

  private void offerNonNull(Deque<Node<T>> deque, Node<T> node) {
    if (node != null) {
      deque.offer(node);
    }
  }

  private void pushNonNull(Deque<Node<T>> deque, Node<T> node) {
    if (node != null) {
      deque.push(node);
    }
  }

  private void insertRecurse(List<T> list, int low, int high) {
    if (low < high) {
      int mid = (low + high) / 2;
      insert(list.get(mid));
      insertRecurse(list, low, mid);
      insertRecurse(list, mid + 1, high);
    }
  }
}
