package com.saurabh.practice.tree;

import com.saurabh.source.algorithms.traversal.Traversals;
import com.saurabh.source.common.Node;

import java.util.ArrayList;
import java.util.List;

public class DeleteLeafNodes {
  public static void main(String[] args) {
    DeleteLeafNodes obj = new DeleteLeafNodes();
    Node<Integer> leftestLeaf = new Node<>(2, null, null);
    Node<Integer> rightLeftLeaf = new Node<>(2, null, null);
    Node<Integer> rightRightLeaf = new Node<>(2, null, null);
    Node<Integer> left = new Node<>(2, leftestLeaf, null);
    Node<Integer> right = new Node<>(2, rightLeftLeaf, rightRightLeaf);
    Node<Integer> root = new Node<>(2, left, right);

    Node<Integer> newRoot = obj.deleteLeavesWithValue(root, 2, null);
    List<Integer> list = new ArrayList<>();
    Traversals.inorder(newRoot, list);
    System.out.println(list);
  }

  public Node<Integer> deleteLeavesWithValue(Node<Integer> node, int value, Node<Integer> parent) {
    if (node == null) return null;
    deleteLeavesWithValue(node.getLeftChild(), value, node);
    deleteLeavesWithValue(node.getRightChild(), value, node);
    if (node.getLeftChild() == null && node.getRightChild() == null && node.getData() == value) {
      if (parent == null) return null;
      if (parent.getLeftChild() == node) parent.setLeftChild(null);
      if (parent.getRightChild() == node) parent.setRightChild(null);
    }

    return node;
  }
}
