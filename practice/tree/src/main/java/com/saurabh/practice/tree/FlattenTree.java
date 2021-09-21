package com.saurabh.practice.tree;

import com.saurabh.source.algorithms.traversal.Traversals;
import com.saurabh.source.common.Node;

import java.util.ArrayList;
import java.util.List;

public class FlattenTree {
  public static void main(String[] args) {
    FlattenTree obj = new FlattenTree();
    Node<Integer> three = new Node<>(3, null, null);
    Node<Integer> four = new Node<>(4, null, null);
    Node<Integer> six = new Node<>(6, null, null);
    Node<Integer> left = new Node<>(2, three, four);
    Node<Integer> right = new Node<>(5, null, six);
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

    if (node.lChild() == null && node.rChild() == null) return node;

    Node<Integer> left = flatten(node.lChild());
    Node<Integer> right = flatten(node.rChild());

    if (left != null) {
      left.rChild(node.rChild());
      node.rChild(node.lChild());
      node.lChild(null);
    }
    return right != null ? right : left;
  }
}
