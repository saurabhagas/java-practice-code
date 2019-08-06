package com.saurabh.basics;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * An implementation of stacks which returns the min() in the stack in O(1) time
 */
public class MinValueInStackInConstantTime {
  public static void main(String[] args) {
    NewStack stack = new NewStack(6);
    stack.push(9);
    stack.push(3);
    stack.push(1);
    stack.push(4);
    stack.push(2);
    stack.push(5);
    System.out.println(stack.min());

    stack.pop();
    System.out.println(stack.min());
    stack.pop();
    stack.pop();
    stack.pop();
    System.out.println(stack.min());
  }

  private static class NewStack {

    //We will use two stacks mainStack to hold original values and minStack to hold minimum values.
    //Top of minStack will always be the minimum value from mainStack
    private final Deque<Integer> mainStack;
    private final Deque<Integer> minStack;

    NewStack(int size) {
      mainStack = new ArrayDeque<>(size);
      minStack = new ArrayDeque<>(size);
    }

    //Removes and return value from newStack
    //1. Pop element from minStack to make it sync with mainStack,
    //2. Pop element from mainStack and return that value.
    int pop() {
      minStack.pop();
      return mainStack.pop();
    }

    //Pushes values into newStack
    //1. Push value in mainStack and check value with the top value of minStack
    //2. If value is greater than top, then push top in minStack
    //else push value in minStack.
    void push(int value) {
      mainStack.push(value);

      if (!minStack.isEmpty() && value > minStack.peek()) {
        minStack.push(minStack.peek());
      } else {
        minStack.push(value);
      }
    }

    //Returns minimum value from newStack in O(1) Time
    int min() {
      return minStack.peek();
    }
  }
}