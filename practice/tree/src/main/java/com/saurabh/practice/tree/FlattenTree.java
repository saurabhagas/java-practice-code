package com.saurabh.practice.tree;

import com.saurabh.source.algorithms.traversal.Traversals;
import com.saurabh.source.common.Node;

import java.util.ArrayList;
import java.util.List;

public class FlattenTree {
  public static void main(String[] args) {
    FlattenTree obj = new FlattenTree();
    Node<Integer> five = new Node<>(5, null, null);
    Node<Integer> two = new Node<>(2, null, five);
    Node<Integer> left = new Node<>(3, null, null);
    Node<Integer> right = new Node<>(4, two, null);
    Node<Integer> root = new Node<>(1, left, right);

    List<Integer> listBefore = new ArrayList<>();
    Traversals.preorder(root, listBefore);
    System.out.println("Tree preorder before: " + listBefore);

    obj.flatten(root);
    List<Integer> listAfter = new ArrayList<>();
    Traversals.preorder(root, listAfter);
    System.out.println("Tree preorder after: " + listAfter);
  }

  // Returns the last non-null preorder-processed node
  private Node<Integer> flatten(Node<Integer> node) {
    if (node == null) return null;

    if (node.getLeftChild() == null && node.getRightChild() == null) return node;

    Node<Integer> left = flatten(node.getLeftChild());
    Node<Integer> right = flatten(node.getRightChild());

    if (left != null) {
      left.setRightChild(node.getRightChild());
      node.setRightChild(node.getLeftChild());
      node.setLeftChild(null);
    }
    return right != null ? right : left;
  }
}
