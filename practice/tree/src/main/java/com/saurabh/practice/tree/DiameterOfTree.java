package com.saurabh.practice.tree;

import com.saurabh.source.algorithms.traversal.Traversals;
import com.saurabh.source.common.MathUtils;
import com.saurabh.source.common.Node;

import java.util.ArrayList;
import java.util.List;

public class DiameterOfTree {
  public static void main(String[] args) {
    DiameterOfTree obj = new DiameterOfTree();
    Node<Integer> twelve = new Node<>(12, null, null);
    Node<Integer> eight = new Node<>(8, twelve, null);
    Node<Integer> nine = new Node<>(9, null, null);
    Node<Integer> eleven = new Node<>(11, null, null);
    Node<Integer> ten = new Node<>(10, null, eleven);
    Node<Integer> leftestLeaf = new Node<>(4, eight, nine);
    Node<Integer> rightLeftLeaf = new Node<>(6, null, null);
    Node<Integer> rightRightLeaf = new Node<>(7, null, null);
    Node<Integer> five = new Node<>(5, null, ten);
    Node<Integer> left = new Node<>(2, leftestLeaf, five);
    Node<Integer> right = new Node<>(3, rightLeftLeaf, rightRightLeaf);
    Node<Integer> root = new Node<>(1, left, right);

    // Do normal inorder traversal
    List<Integer> inorderList = new ArrayList<>();
    Traversals.inorder(root, inorderList);
    System.out.println("Inorder traversal: " + inorderList);

    System.out.println("Diameter of tree: " + obj.getDiameter(root));
  }

  private int getDiameter(Node<Integer> root) {
    return MathUtils.max(diameterOfSubtree(root.getLeftChild()), diameterOfSubtree(root.getRightChild()), diameterOfSubtree(root));
  }

  private int diameterOfSubtree(Node<Integer> root) {
    if (root == null) return 0;
    return height(root.getLeftChild()) + height(root.getRightChild()) + 1;

  }

  private int height(Node<Integer> root) {
    if (root == null) return 0;
    return Math.max(height(root.getLeftChild()), height(root.getRightChild())) + 1;
  }
}
