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
    deleteLeavesWithValue(node.lChild(), value, node);
    deleteLeavesWithValue(node.rChild(), value, node);
    if (node.lChild() == null && node.rChild() == null && node.data() == value) {
      if (parent == null) return null;
      if (parent.lChild() == node) parent.lChild(null);
      if (parent.rChild() == node) parent.rChild(null);
    }

    return node;
  }
}
