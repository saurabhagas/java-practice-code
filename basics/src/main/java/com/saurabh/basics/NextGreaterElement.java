package com.saurabh.basics;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.IntStream;

/**
 * Problem description at: https://www.geeksforgeeks.org/next-greater-element/
 */
public class NextGreaterElement {
  public static int[] nextGreaterElement(int[] arr) {
    // Initialize with -1's as -1 denotes NGE not being present
    int[] ngeArray = IntStream.generate(() -> -1).limit(arr.length).toArray();
    int resultArrayIndex = -1;

    // Maintain a stack of all elements. To be used to track smaller elements
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(arr[0]);

    for (int i = 1; i < arr.length; i++) {
      int currentArrayElement = arr[i];
      if (!stack.isEmpty()) {
        int topElement = stack.peek();
        while (topElement < currentArrayElement) {
          stack.pop();
          // currentArrayElement is the NGE, save it in results array
          ngeArray[++resultArrayIndex] = currentArrayElement;
          if (stack.isEmpty()) {
            break;
          }
          topElement = stack.peek();
        }
      }
      stack.push(currentArrayElement);
    }
    return ngeArray;
  }

  public static void main(String[] args) {
    int[] arr = {4, 6, 3, 2, 8, 1, 9, 9, 9};
    System.out.println("Original : " + Arrays.toString(arr));
    System.out.println("NGE array: " + Arrays.toString(nextGreaterElement(arr)));
  }
}