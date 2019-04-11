package code.collections.custom.impl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.max;

public class BST<T extends Comparable> {
  private Node root;

  public boolean insert(T data) {
    Node temp = new Node(data, null, null);
    Node current = root;
    while (current != null) {
      if (data.compareTo(current.data) < 0) {
        if (current.leftChild == null) {
          current.leftChild = temp;
          break;
        }
        current = current.leftChild;
      } else if (data.compareTo(current.data) > 0) {
        if (current.rightChild == null) {
          current.rightChild = temp;
          break;
        }
        current = current.rightChild;
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
    Node current = root;
    Node foundLocationParent = null;
    Node foundLocation = null;
    while (current != null) {
      if ((current.leftChild != null && current.leftChild.data == data) || (current.rightChild != null && current.rightChild.data == data)) {
        foundLocationParent = current;
      }
      if (data.compareTo(current.data) < 0) {
        current = current.leftChild;
      } else if (data.compareTo(current.data) > 0) {
        current = current.rightChild;
      } else {
        foundLocation = current;
        break;
      }
    }

    if (foundLocation == null) {
      return false; // Node to be deleted not present
    } else if (foundLocation == root) {
      if (foundLocation.leftChild == null && foundLocation.rightChild == null) {
        root = null;
      } else if (foundLocation.leftChild == null && foundLocation.rightChild != null) {
        root = root.rightChild;
      } else if (foundLocation.leftChild != null && foundLocation.rightChild == null) {
        root = root.leftChild;
      } else {
        // Both children present, swap node with inorder successor
        current = foundLocation.rightChild; // start from the right subtree
        Node inorderSuccessorParent = null;
        Node inorderSuccessor;
        while (current != null && current.leftChild != null) {
          if (current.leftChild.leftChild == null) {
            inorderSuccessorParent = current;
          }
          current = current.leftChild;
        }
        inorderSuccessor = current;

        if (inorderSuccessor.rightChild == null) {
          foundLocation.data = inorderSuccessor.data;
          if (inorderSuccessorParent == null) {
            foundLocation.rightChild = null;
          } else {
            inorderSuccessorParent.leftChild = null;
          }
        } else {
          foundLocation.data = inorderSuccessor.data;
          inorderSuccessor.data = inorderSuccessor.rightChild.data;
          inorderSuccessor.rightChild = null;
        }
      }
      return true;
    } else {
      if (foundLocation.leftChild == null && foundLocation.rightChild == null) {
        if (foundLocationParent.leftChild == foundLocation) {
          foundLocationParent.leftChild = null;
        } else {
          foundLocationParent.rightChild = null;
        }
      } else if (foundLocation.leftChild == null && foundLocation.rightChild != null) {
        if (foundLocationParent.leftChild == foundLocation) {
          foundLocationParent.leftChild = foundLocation.rightChild;
        } else {
          foundLocationParent.rightChild = foundLocation.rightChild;
        }
      } else if (foundLocation.leftChild != null && foundLocation.rightChild == null) {
        if (foundLocationParent.leftChild == foundLocation) {
          foundLocationParent.leftChild = foundLocation.leftChild;
        } else {
          foundLocationParent.rightChild = foundLocation.leftChild;
        }
      } else {
        // Both children present, swap node with inorder successor
        current = foundLocation.rightChild; // start from the right subtree
        Node inorderSuccessorParent = null;
        Node inorderSuccessor;
        while (current != null && current.leftChild != null) {
          if (current.leftChild.leftChild == null) {
            inorderSuccessorParent = current;
          }
          current = current.leftChild;
        }
        inorderSuccessor = current;

        if (inorderSuccessor.rightChild == null) {
          foundLocation.data = inorderSuccessor.data;
          if (inorderSuccessorParent == null) {
            foundLocation.rightChild = null;
          } else {
            inorderSuccessorParent.leftChild = null;
          }
        } else {
          foundLocation.data = inorderSuccessor.data;
          inorderSuccessor.data = inorderSuccessor.rightChild.data;
          inorderSuccessor.rightChild = null;
        }
      }
      return true;
    }
  }

  public Node search(T data) {
    Node current = root;
    while (current != null) {
      if (data.compareTo(current.data) < 0) {
        current = current.leftChild;
      } else if (data.compareTo(current.data) > 0) {
        current = current.rightChild;
      } else {
        return current;
      }
    }
    return null;
  }

  public void levelOrder() {
    Deque<Node> deque = new ArrayDeque<>();
    offerNonNull(deque, root);

    while (!deque.isEmpty()) {
      final Node current = deque.poll();
      System.out.println(current.data);
      offerNonNull(deque, current.leftChild);
      offerNonNull(deque, current.rightChild);
    }
  }

  public List<T> preOrder() {
    ArrayList<T> items = new ArrayList<>();
    preOrderInternal(root, items);
    return items;
  }

  public List<T> inOrder() {
    ArrayList<T> items = new ArrayList<>();
    inOrderInternal(root, items);
    return items;
  }

  public List<T> postOrder() {
    ArrayList<T> items = new ArrayList<>();
    postOrderInternal(root, items);
    return items;
  }

  public int size() {
    return inOrder().size();
  }

  public int height() {
    return heightInternal(root);
  }

  /**
   * One time balancing of the BST. Saves the inorder (i.e. sorted data) traversal of the original tree, nullifies the tree,
   * and constructs a new tree recursively from this sorted list. Works on O(n) time and O(n) space.
   */
  public void balance() {
    final ArrayList<T> list = new ArrayList<>();
    inOrderInternal(root, list);
    root = null; // Nullify root, making the entire tree eligible for GC
    insertRecurse(list, 0, list.size());
    System.out.println("Tree balancing done");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    BST other = (BST) o;

    Deque<Node> thisDeque = new ArrayDeque<>();
    Deque<Node> otherDeque = new ArrayDeque<>();
    offerNonNull(thisDeque, this.root);
    offerNonNull(otherDeque, other.root);

    while (!thisDeque.isEmpty() && !otherDeque.isEmpty()) {
      final Node thisCurrent = thisDeque.poll();
      final Node otherCurrent = otherDeque.poll();
      if (thisCurrent.data != otherCurrent.data) {
        return false;
      }

      offerNonNull(thisDeque, thisCurrent.leftChild);
      offerNonNull(thisDeque, thisCurrent.rightChild);
      offerNonNull(otherDeque, otherCurrent.leftChild);
      offerNonNull(otherDeque, otherCurrent.rightChild);
    }

    if ((!thisDeque.isEmpty() && otherDeque.isEmpty()) || (thisDeque.isEmpty() && !otherDeque.isEmpty())) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    List<Node> allElements = new ArrayList<>();
    Deque<Node> deque = new ArrayDeque<>();
    offerNonNull(deque, root);

    while (!deque.isEmpty()) {
      final Node current = deque.poll();
      allElements.add(current);
      System.out.println(current.data);
      offerNonNull(deque, current.leftChild);
      offerNonNull(deque, current.rightChild);
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
    final StringBuilder nodesAsString = new StringBuilder();
    Deque<Node> deque = new ArrayDeque<>();
    pushNonNull(deque, root);

    while (!deque.isEmpty()) {
      final Node current = deque.pop();
      nodesAsString.append(current.data).append(" ");
      pushNonNull(deque, current.rightChild);
      pushNonNull(deque, current.leftChild);
    }

    return nodesAsString.toString().trim();
  }

  private void offerNonNull(Deque<Node> deque, Node node) {
    if (node != null) {
      deque.offer(node);
    }
  }

  private void pushNonNull(Deque<Node> deque, Node node) {
    if (node != null) {
      deque.push(node);
    }
  }

  private void preOrderInternal(Node root, List<T> items) {
    if (root != null) {
      items.add(root.data);
      preOrderInternal(root.leftChild, items);
      preOrderInternal(root.rightChild, items);
    }
  }

  private void inOrderInternal(Node root, List<T> items) {
    if (root != null) {
      inOrderInternal(root.leftChild, items);
      items.add(root.data);
      inOrderInternal(root.rightChild, items);
    }
  }

  private void postOrderInternal(Node root, List<T> items) {
    if (root != null) {
      postOrderInternal(root.leftChild, items);
      postOrderInternal(root.rightChild, items);
      items.add(root.data);
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

  private int heightInternal(Node root) {
    if (root != null) {
      return max(heightInternal(root.leftChild), heightInternal(root.rightChild)) + 1;
    }
    return 0;
  }

  private class Node {
    private T data;
    private Node leftChild;
    private Node rightChild;

    Node(T data, Node leftChild, Node rightChild) {
      this.data = data;
      this.leftChild = leftChild;
      this.rightChild = rightChild;
    }
  }
}
