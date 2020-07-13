package com.saurabh.practice.tree;

import com.saurabh.source.algorithms.traversal.Traversals;
import com.saurabh.source.common.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeftView {
  public static void main(String[] args) {
    LeftView obj = new LeftView();
    Node<Integer> leftestLeaf = new Node<>(4, null, null);
    Node<Integer> eleven = new Node<>(11, null, null);
    Node<Integer> rightLeftLeaf = new Node<>(12, eleven, null);
    Node<Integer> rightRightLeaf = new Node<>(16, null, null);
    Node<Integer> five = new Node<>(5, null, null);
    Node<Integer> left = new Node<>(5, leftestLeaf, five);
    Node<Integer> right = new Node<>(15, rightLeftLeaf, rightRightLeaf);
    Node<Integer> root = new Node<>(10, left, right);

    // Do normal inorder traversal
    List<Integer> inorderList = new ArrayList<>();
    Traversals.inorder(root, inorderList);
    System.out.println("Inorder traversal: " + inorderList);
    obj.leftView(root);
  }

  public void leftView(Node<Integer> root) {
    Deque<Node<Integer>> queue = new ArrayDeque<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node<Integer> polled = queue.poll();
        if (i == 0) System.out.println(polled.getData());
        if (polled.getLeftChild() != null) queue.offer(polled.getLeftChild());
        if (polled.getRightChild() != null) queue.offer(polled.getRightChild());
      }
    }
  }
}
