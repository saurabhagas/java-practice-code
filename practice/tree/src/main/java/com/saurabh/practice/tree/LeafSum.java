package com.saurabh.practice.tree;

import com.saurabh.source.common.Node;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeafSum {
  public static void main(String[] args) {
    LeafSum obj = new LeafSum();
    Node<Integer> leftestLeaf = new Node<>(3, null, null);
    Node<Integer> rightLeftLeaf = new Node<>(1, null, null);
    Node<Integer> rightRightLeaf = new Node<>(5, null, null);
    Node<Integer> left = new Node<>(1, leftestLeaf, null);
    Node<Integer> right = new Node<>(4, rightLeftLeaf, rightRightLeaf);
    Node<Integer> root = new Node<>(3, left, right);

    System.out.println("Leaf sum: " + obj.leafSum(root));
    System.out.println("Deepest leaves' sum: " + obj.deepestLeavesSum(root));
  }

  private int leafSum(Node<Integer> root) {
    if (root == null) return 0;
    if (root.getLeftChild() == null && root.getRightChild() == null) {
      return root.getData();
    }
    return leafSum(root.getLeftChild()) + leafSum(root.getRightChild());
  }

  private int deepestLeavesSum(Node<Integer> root) {
    if (root == null) return 0;
    Deque<Node<Integer>> queue = new ArrayDeque<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      int levelSum = 0;
      for (int i = 0; i < size; i++) {
        Node<Integer> polled = queue.poll();
        levelSum += polled.getData();
        if (polled.getLeftChild() != null) queue.offer(polled.getLeftChild());
        if (polled.getRightChild() != null) queue.offer(polled.getRightChild());
      }

      if (queue.isEmpty()) return levelSum;
    }
    return 0;
  }
}
