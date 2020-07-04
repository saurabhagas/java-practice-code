package com.saurabh.practice.recursion;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Example showing stack sorting using recursion
 */
public class StackSort {
  public static void main(String[] args) {
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(3);
    stack.push(1);
    stack.push(4);
    stack.push(2);
    stack.push(5);

    System.out.println("Original stack: " + stack);
    sort(stack);
    System.out.println("Sorted stack: " + stack);
  }

  private static void sort(Deque<Integer> stack) {
    if (stack.peek() != null) {
      final Integer poppedElement = stack.pop();
      sort(stack);
      insertInSortedOrder(poppedElement, stack);
    }
  }

  private static void insertInSortedOrder(Integer element, Deque<Integer> stack) {
    if (stack.isEmpty()) {
      stack.push(element);
    } else {
      final Integer topItem = stack.peek();
      if (element < topItem) {
        stack.pop();
        insertInSortedOrder(element, stack);
        stack.push(topItem);
      } else {
        stack.push(element);
      }
    }
  }
}
