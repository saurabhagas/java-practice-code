package com.saurabh.practice.tree;

import com.saurabh.source.algorithms.traversal.Traversals;
import com.saurabh.source.common.Node;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class BstChecker {
  public static void main(String[] args) {
    BstChecker obj = new BstChecker();
    Node<Integer> leftestLeaf = new Node<>(4, null, null);
    Node<Integer> rightLeftLeaf = new Node<>(12, null, null);
    Node<Integer> rightRightLeaf = new Node<>(16, null, null);
    Node<Integer> five = new Node<>(5, null, null);
    Node<Integer> left = new Node<>(5, leftestLeaf, five);
    Node<Integer> right = new Node<>(15, rightLeftLeaf, rightRightLeaf);
    Node<Integer> root = new Node<>(10, left, right);

    // Do normal inorder traversal
    List<Integer> inorderList = new ArrayList<>();
    Traversals.inorder(root, inorderList);
    System.out.println("Inorder traversal: " + inorderList);
    System.out.println("obj.isBst(root) = " + obj.isBst(root, MIN_VALUE, MAX_VALUE));
  }

  public boolean isBst(Node<Integer> root, int leftMax, int rightMax) {
    if (root == null) return true;
    if (root.data() < leftMax || root.data() > rightMax) return false;

    return isBst(root.lChild(), leftMax, root.data()) && isBst(root.rChild(), root.data(), rightMax);
  }
}
