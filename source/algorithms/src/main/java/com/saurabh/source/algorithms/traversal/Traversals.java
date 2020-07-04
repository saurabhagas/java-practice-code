package com.saurabh.source.algorithms.traversal;

import com.saurabh.source.common.Node;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * Utility class providing traversals
 */
public class Traversals {
  /**
   * Provides level-order, or breadth-first traversal using queues
   *
   * @param root root of the binary tree
   */
  public static <T> void breadthFirst(Node<T> root) {
    Deque<Node<T>> queue = new ArrayDeque<>();
    offerNonNull(queue, root);

    while (!queue.isEmpty()) {
      Node<T> current = queue.poll();
      System.out.println(current.getData());
      offerNonNull(queue, current.getLeftChild());
      offerNonNull(queue, current.getRightChild());
    }
  }

  /**
   * Provides level-order, or breadth-first travsersal in a spiral fashion using two stacks
   *
   * @param root root of the binary tree
   */
  public static <T> void spiralBreadthFirst(Node<T> root) {
    Deque<Node<T>> stack1 = new ArrayDeque<>();
    Deque<Node<T>> stack2 = new ArrayDeque<>();

    pushNonNull(stack1, root);
    while (!stack1.isEmpty()) {
      while (!stack1.isEmpty()) {
        Node<T> popped = stack1.pop();
        System.out.println(popped.getData());
        pushNonNull(stack2, popped.getRightChild());
        pushNonNull(stack2, popped.getLeftChild());
      }

      while (!stack2.isEmpty()) {
        Node<T> popped = stack2.pop();
        System.out.println(popped.getData());
        pushNonNull(stack1, popped.getLeftChild());
        pushNonNull(stack1, popped.getRightChild());
      }
    }
  }

  /**
   * Provides pre-order travel using stacks
   *
   * @param root root of the binary tree
   */
  public static <T> void depthFirst(Node<T> root) {
    Deque<Node<T>> stack = new ArrayDeque<>();
    pushNonNull(stack, root);

    while (!stack.isEmpty()) {
      Node<T> current = stack.pop();
      System.out.println(current.getData());
      pushNonNull(stack, current.getRightChild());
      pushNonNull(stack, current.getLeftChild());
    }
  }

  public static <T> void preorder(Node<T> root, List<T> items) {
    if (root != null) {
      items.add(root.getData());
      preorder(root.getLeftChild(), items);
      preorder(root.getRightChild(), items);
    }
  }

  public static <T> void inorder(Node<T> root, List<T> items) {
    if (root != null) {
      inorder(root.getLeftChild(), items);
      items.add(root.getData());
      inorder(root.getRightChild(), items);
    }
  }

  public static <T> void postorder(Node<T> root, List<T> items) {
    if (root != null) {
      postorder(root.getLeftChild(), items);
      postorder(root.getRightChild(), items);
      items.add(root.getData());
    }
  }

  private static <T> void offerNonNull(Deque<Node<T>> deque, Node<T> node) {
    if (node != null) {
      deque.offer(node);
    }
  }

  private static <T> void pushNonNull(Deque<Node<T>> deque, Node<T> node) {
    if (node != null) {
      deque.push(node);
    }
  }
}
