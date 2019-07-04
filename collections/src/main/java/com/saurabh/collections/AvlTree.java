package com.saurabh.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static java.lang.Math.max;

public class AvlTree<T extends Comparable> {
  private Node root;

  public boolean insert(T data) {
    if (search(data)) {
      return false;
    }

    root = insertInternal(root, data);
    return root != null;
  }

  private Node insertInternal(Node current, T data) {
    if (current == null) {
      return new Node(data, null, null);
    }

    if (data.compareTo(current.data) > 0) {
      current.rightChild = insertInternal(current.rightChild, data);
    } else if (data.compareTo(current.data) < 0) {
      current.leftChild = insertInternal(current.leftChild, data);
    }

    current.height = maxHeight(current);
    return balance(current, data);
  }

  private Node balance(Node root, T data) {
    int balance = getBalance(root);
    if (balance > 1) {
      if (data.compareTo(root.leftChild.data) < 0) {
        //Left-left case
        return rightRotate(root);
      } else if (data.compareTo(root.leftChild.data) > 0) {
        //Left-right case
        root.leftChild = leftRotate(root.leftChild);
        return rightRotate(root);
      }
    } else if (balance < -1) {
      if (data.compareTo(root.rightChild.data) > 0) {
        //Right-right case
        return leftRotate(root);
      } else if (data.compareTo(root.rightChild.data) > 0) {
        //Right-left case
        root.rightChild = rightRotate(root.rightChild);
        return leftRotate(root);
      }
    }
    return root; // No balancing was done
  }

  public void clear() {
    root = null;
  }

  public boolean remove(T data) {
    if (!search(data)) {
      return false;
    }
    root = removeInternal(root, data);
    return true;
  }

  private Node removeInternal(Node node, T data) {
    if (node == null) {
      return node;
    }

    if (data.compareTo(node.data) < 0) {
      node.leftChild = removeInternal(node.leftChild, data);
    } else if (data.compareTo(node.data) > 0) {
      node.rightChild = removeInternal(node.rightChild, data);
    } else {
      if (node.leftChild == null || node.rightChild == null) {
        node = node.leftChild == null ? node.rightChild : node.leftChild; // simply advance the pointer and return the node later
      } else {
        Node temp = getInorderSuccessor(node.rightChild);
        node.data = temp.data;
        node.rightChild = removeInternal(node.rightChild, temp.data);
      }
    }

    // If the tree now has only one node, return
    if (node == null) {
      return node;
    }

    node.height = maxHeight(node);
    return balance(node, data);
  }

  private Node getInorderSuccessor(Node node) {
    while(node != null && node.leftChild != null) {
      node = node.leftChild;
    }

    return node;
  }

  public boolean search(T data) {
    Node current = root;
    while (current != null) {
      if (data.compareTo(current.data) < 0) {
        current = current.leftChild;
      } else if (data.compareTo(current.data) > 0) {
        current = current.rightChild;
      } else {
        return true;
      }
    }
    return false;
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
    return height(root);
  }

  private int maxHeight(Node root) {
    if (root != null) {
      return max(height(root.leftChild), height(root.rightChild)) + 1;
    }
    return 0;
  }

  private int height(Node node) {
    if (node == null) {
      return 0;
    }
    return node.height;
  }

  private Node rightRotate(Node pivot) {
    final Node temp = pivot.leftChild;
    pivot.leftChild = pivot.leftChild.rightChild;
    temp.rightChild = pivot;

    pivot.height = maxHeight(pivot);
    temp.height = maxHeight(temp);
    return temp;
  }

  private Node leftRotate(Node pivot) {
    final Node temp = pivot.rightChild;
    pivot.rightChild = temp.leftChild;
    temp.leftChild = pivot;

    pivot.height = maxHeight(pivot);
    temp.height = maxHeight(temp);
    return temp;
  }

  private int getBalance(Node node) {
    if (node == null)
      return 0;
    return height(node.leftChild) - height(node.rightChild);
  }

  private void offerNonNull(Deque<Node> deque, Node node) {
    if (node != null) {
      deque.offer(node);
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

  private class Node {
    private T data;
    private int height;
    private Node leftChild;
    private Node rightChild;

    Node(T data, Node leftChild, Node rightChild) {
      this.data = data;
      this.height = 1;
      this.leftChild = leftChild;
      this.rightChild = rightChild;
    }
  }
}
