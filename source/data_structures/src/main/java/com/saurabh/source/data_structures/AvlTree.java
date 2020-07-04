package com.saurabh.source.data_structures;

import com.saurabh.source.common.Node;

import java.util.ArrayList;
import java.util.List;

import static com.saurabh.source.algorithms.traversal.Traversals.inorder;
import static com.saurabh.source.algorithms.traversal.Traversals.breadthFirst;
import static com.saurabh.source.algorithms.traversal.Traversals.postorder;
import static com.saurabh.source.algorithms.traversal.Traversals.preorder;
import static java.lang.Math.max;

public class AvlTree<T extends Comparable<T>> {
  private HeightedNode<T> root;

  public boolean insert(T data) {
    if (search(data)) {
      return false;
    }

    root = insertInternal(root, data);
    return root != null;
  }

  private HeightedNode<T> insertInternal(HeightedNode<T> current, T data) {
    if (current == null) {
      return new HeightedNode<>(data, null, null);
    }

    if (data.compareTo(current.getData()) > 0) {
      current.rightChild = insertInternal(current.rightChild, data);
    } else if (data.compareTo(current.getData()) < 0) {
      current.leftChild = insertInternal(current.leftChild, data);
    }

    current.height = maxHeight(current);
    return balance(current, data);
  }

  private HeightedNode<T> balance(HeightedNode<T> root, T data) {
    int balance = getBalance(root);
    if (balance > 1) {
      if (data.compareTo(root.leftChild.getData()) < 0) {
        //Left-left case
        return rightRotate(root);
      } else if (data.compareTo(root.leftChild.getData()) > 0) {
        //Left-right case
        root.leftChild = leftRotate(root.leftChild);
        return rightRotate(root);
      }
    } else if (balance < -1) {
      if (data.compareTo(root.rightChild.getData()) > 0) {
        //Right-right case
        return leftRotate(root);
      } else if (data.compareTo(root.rightChild.getData()) < 0) {
        //Right-left case
        root.rightChild = rightRotate(root.rightChild);
        return leftRotate(root);
      }
    }
    return root; // No balancing was done
  }

  private HeightedNode<T> balance(HeightedNode<T> root) {
    int balance = getBalance(root);
    if (balance > 1) {
      if (getBalance(root.leftChild) >= 0) {
        //Left-left case
        return rightRotate(root);
      } else if (getBalance(root.leftChild) < 0) {
        //Left-right case
        root.leftChild = leftRotate(root.leftChild);
        return rightRotate(root);
      }
    } else if (balance < -1) {
      if (getBalance(root.rightChild) <= 0) {
        //Right-right case
        return leftRotate(root);
      } else if (getBalance(root.rightChild) > 0) {
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

  private HeightedNode<T> removeInternal(HeightedNode<T> node, T data) {
    if (node == null) {
      return null;
    }

    if (data.compareTo(node.getData()) < 0) {
      node.leftChild = removeInternal(node.leftChild, data);
    } else if (data.compareTo(node.getData()) > 0) {
      node.rightChild = removeInternal(node.rightChild, data);
    } else {
      if (node.leftChild == null || node.rightChild == null) {
        node = node.getLeftChild() == null ? node.rightChild : node.leftChild; // simply advance the pointer and return the node later
      } else {
        HeightedNode<T> temp = getInorderSuccessor(node.rightChild);
        node.setData(temp.getData());
        node.rightChild = removeInternal(node.rightChild, temp.getData());
      }
    }

    // If the tree now has only one node, return
    if (node == null) {
      return null;
    }

    node.height = maxHeight(node);
    return balance(node);
  }

  private HeightedNode<T> getInorderSuccessor(HeightedNode<T> node) {
    while (node != null && node.leftChild != null) {
      node = node.leftChild;
    }

    return node;
  }

  public boolean search(T data) {
    HeightedNode<T> current = root;
    while (current != null) {
      if (data.compareTo(current.getData()) < 0) {
        current = current.leftChild;
      } else if (data.compareTo(current.getData()) > 0) {
        current = current.rightChild;
      } else {
        return true;
      }
    }
    return false;
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
    return height(root);
  }

  @Override
  public String toString() {
    return inOrder().toString();
  }

  private int maxHeight(HeightedNode<T> root) {
    if (root != null) {
      return max(height(root.leftChild), height(root.rightChild)) + 1;
    }
    return 0;
  }

  private int height(HeightedNode<T> node) {
    if (node == null) {
      return 0;
    }
    return node.height;
  }

  private HeightedNode<T> rightRotate(HeightedNode<T> pivot) {
    HeightedNode<T> temp = pivot.leftChild;
    pivot.leftChild = temp.rightChild;
    temp.rightChild = pivot;

    pivot.height = maxHeight(pivot);
    temp.height = maxHeight(temp);
    return temp;
  }

  private HeightedNode<T> leftRotate(HeightedNode<T> pivot) {
    HeightedNode<T> temp = pivot.rightChild;
    pivot.rightChild = temp.leftChild;
    temp.leftChild = pivot;

    pivot.height = maxHeight(pivot);
    temp.height = maxHeight(temp);
    return temp;
  }

  private int getBalance(HeightedNode<T> node) {
    if (node == null)
      return 0;
    return height(node.leftChild) - height(node.rightChild);
  }

  private static class HeightedNode<U> extends Node<U> {
    private int height;
    private HeightedNode<U> leftChild;
    private HeightedNode<U> rightChild;

    HeightedNode(U data, HeightedNode<U> leftChild, HeightedNode<U> rightChild) {
      super(data, leftChild, rightChild);
      this.height = 1;
    }

    @Override
    public HeightedNode<U> getLeftChild() {
      return leftChild;
    }

    @Override
    public HeightedNode<U> getRightChild() {
      return rightChild;
    }

    @Override
    public String toString() {
      return super.getData().toString();
    }
  }
}
