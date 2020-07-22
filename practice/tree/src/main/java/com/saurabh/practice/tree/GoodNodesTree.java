package com.saurabh.practice.tree;

import com.saurabh.source.common.Node;

public class GoodNodesTree {
  public static void main(String[] args) {
    GoodNodesTree obj = new GoodNodesTree();
    Node<Integer> leftestLeaf = new Node<>(3, null, null);
    Node<Integer> rightLeftLeaf = new Node<>(1, null, null);
    Node<Integer> rightRightLeaf = new Node<>(5, null, null);
    Node<Integer> left = new Node<>(1, leftestLeaf, null);
    Node<Integer> right = new Node<>(4, rightLeftLeaf, rightRightLeaf);
    Node<Integer> root = new Node<>(3, left, right);

    System.out.println("Good nodes: " + obj.printGoodNodes(root, Integer.MIN_VALUE, 0));
    System.out.println("Total nodes: " + obj.countNodes(root));
    System.out.println("Height: " + obj.height(root));
  }

  private int printGoodNodes(Node<Integer> root, int maxInPath, int total) {
    if (root == null) return 0;

    int x = 0;
    if (root.data() >= maxInPath) {
      maxInPath = root.data();
      System.out.println(root.data());
      x++;
    }
    return x + printGoodNodes(root.lChild(), maxInPath, total) + printGoodNodes(root.rChild(), maxInPath, total);
  }

  private int countNodes(Node<Integer> root) {
    if (root == null) {
      return 0;
    }
    return countNodes(root.lChild()) + countNodes(root.rChild()) + 1;
  }

  private int height(Node<Integer> root) {
    if (root == null) {
      return 0;
    }
    return Math.max(height(root.lChild()), height(root.rChild())) + 1;
  }
}
