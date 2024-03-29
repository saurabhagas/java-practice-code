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
    if (root.lChild() == null && root.rChild() == null) {
      return root.data();
    }
    return leafSum(root.lChild()) + leafSum(root.rChild());
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
        levelSum += polled.data();
        if (polled.lChild() != null) queue.offer(polled.lChild());
        if (polled.rChild() != null) queue.offer(polled.rChild());
      }

      if (queue.isEmpty()) return levelSum;
    }
    return 0;
  }
}
