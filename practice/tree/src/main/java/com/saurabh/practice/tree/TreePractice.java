package com.saurabh.practice.tree;

import com.saurabh.source.common.Node;
import com.saurabh.source.data_structures.BinarySearchTree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TreePractice {
  private static final List<Integer> uniqueKeys = Arrays.asList(5, 3, 10, 1, 9, 11, 0, 2, 7, 12);
  //         5
  //      3   10
  //    1    9  11
  //  0  2  7    12
  private final BinarySearchTree<Integer> bst = new BinarySearchTree<>();

  public static void main(String[] args) {
    TreePractice obj = new TreePractice();
    uniqueKeys.forEach(obj.bst::insert);
    obj.printSpiralTraversal(obj.bst.getRoot());
  }

  private void printSpiralTraversal(Node<Integer> root) {
    Deque<Node<Integer>> stack1 = new ArrayDeque<>();
    Deque<Node<Integer>> stack2 = new ArrayDeque<>();
    stack2.push(root);

    boolean leftToRight = true;
    while (!stack1.isEmpty() || !stack2.isEmpty()) {
      if (leftToRight) {
        int size = stack2.size();
        for (int i = 0; i < size; i++) {
          Node<Integer> popped = stack2.pop();
          System.out.print(popped.data() + "->");
          if (popped.lChild() != null) stack1.push(popped.lChild());
          if (popped.rChild() != null) stack1.push(popped.rChild());
        }
      } else {
        int size = stack1.size();
        for (int i = 0; i < size; i++) {
          Node<Integer> popped = stack1.pop();
          System.out.print(popped.data() + "->");
          if (popped.rChild() != null) stack2.push(popped.rChild());
          if (popped.lChild() != null) stack2.push(popped.lChild());
        }
      }
      leftToRight = !leftToRight;
    }
  }

  private List<List<Integer>> getSpiralTraversal(Node<Integer> root) {
    List<List<Integer>> toReturn = new LinkedList<>();
    Deque<Node<Integer>> queue = new LinkedList<>();
    queue.offer(root);

    boolean leftToRight = true;
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> currLevelNodes = new LinkedList<>();
      for (int i = 0; i < size; i++) {
        Node<Integer> polled = queue.poll();
        if (polled.lChild() != null) queue.offer(polled.lChild());
        if (polled.rChild() != null) queue.offer(polled.rChild());

        if (leftToRight) {
          currLevelNodes.add(polled.data());
        } else {
          currLevelNodes.add(0, polled.data());
        }
      }
      leftToRight = !leftToRight;
      toReturn.add(currLevelNodes);
    }

    return toReturn;
  }

  private void preOrderIterative(Node<Integer> root) {
    Deque<Node<Integer>> stack = new ArrayDeque<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      Node<Integer> popped = stack.pop();
      System.out.println(popped.data());
      Node<Integer> rightChild = popped.rChild();
      if (rightChild != null) {
        stack.push(rightChild);
      }

      Node<Integer> leftChild = popped.lChild();
      if (leftChild != null) {
        stack.push(leftChild);
      }
    }
  }

  private void inOrderIterative(Node<Integer> root) {
    Deque<Node<Integer>> stack = new ArrayDeque<>();
    Set<Node<Integer>> visited = new HashSet<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      Node<Integer> popped = stack.pop();
      if (!visited.contains(popped)) {
        visited.add(popped);
      } else {
        System.out.println(popped.data());
        continue;
      }

      Node<Integer> rightChild = popped.rChild();
      if (rightChild != null) {
        stack.push(rightChild);
      }

      stack.push(popped);
      Node<Integer> leftChild = popped.lChild();
      if (leftChild != null) {
        stack.push(leftChild);
      }
    }
  }

  private void postOrderIterative(Node<Integer> root) {
    Deque<Node<Integer>> stack = new ArrayDeque<>();
    Set<Node<Integer>> visited = new HashSet<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      Node<Integer> popped = stack.pop();
      if (!visited.contains(popped)) {
        visited.add(popped);
      } else {
        System.out.println(popped.data());
        continue;
      }
      stack.push(popped);

      Node<Integer> rightChild = popped.rChild();
      if (rightChild != null) {
        stack.push(rightChild);
      }

      Node<Integer> leftChild = popped.lChild();
      if (leftChild != null) {
        stack.push(leftChild);
      }
    }
  }
}
