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
      System.out.println(current.data());
      offerNonNull(queue, current.lChild());
      offerNonNull(queue, current.rChild());
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
        System.out.println(popped.data());
        pushNonNull(stack2, popped.rChild());
        pushNonNull(stack2, popped.lChild());
      }

      while (!stack2.isEmpty()) {
        Node<T> popped = stack2.pop();
        System.out.println(popped.data());
        pushNonNull(stack1, popped.lChild());
        pushNonNull(stack1, popped.rChild());
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
      System.out.println(current.data());
      pushNonNull(stack, current.rChild());
      pushNonNull(stack, current.lChild());
    }
  }

  public static <T> void preorder(Node<T> root, List<T> items) {
    if (root != null) {
      items.add(root.data());
      preorder(root.lChild(), items);
      preorder(root.rChild(), items);
    }
  }

  public static <T> void inorder(Node<T> root, List<T> items) {
    if (root != null) {
      inorder(root.lChild(), items);
      items.add(root.data());
      inorder(root.rChild(), items);
    }
  }

  public static <T> void postorder(Node<T> root, List<T> items) {
    if (root != null) {
      postorder(root.lChild(), items);
      postorder(root.rChild(), items);
      items.add(root.data());
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
