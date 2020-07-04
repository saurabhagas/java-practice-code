package com.saurabh.practice.dynamic_programming;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an array of n numbers, give an algorithm for finding a contiguous subsequence A(i)... A(j) for which the sum of
 * elements is maximum.
 */
public class MaxSumSubstring {
  // Returns the max sum substring in the array
  int find(int[] array) {
    int[] maxSumSubstringEndingAtIndex = new int[array.length];
    return maxSumSubstringEndingAtIndex[findInternal(array, maxSumSubstringEndingAtIndex)];
  }

  String findAndPrint(int[] array) {
    int[] maxSumSubstringEndingAtIndex = new int[array.length];
    int indexOfMaxSumSubstring = findInternal(array, maxSumSubstringEndingAtIndex);

    Deque<Integer> stack = new ArrayDeque<>();
    for (
        int currentIndex = indexOfMaxSumSubstring, currentValue = maxSumSubstringEndingAtIndex[indexOfMaxSumSubstring];
        currentIndex >= 0 && currentValue != 0;
        currentIndex--
    ) {
      stack.push(array[currentIndex]);
      currentValue = currentValue - array[currentIndex];
    }

    StringBuilder toReturn = new StringBuilder();
    stack.iterator().forEachRemaining(item -> toReturn.append(item).append(", "));
    return toReturn.substring(0, toReturn.length() - 2);
  }

  // Returns the index corresponding to the max sum in the array
  private int findInternal(int[] array, int[] maxSumSubstringEndingAtIndex) {
    maxSumSubstringEndingAtIndex[0] = array[0];
    for (int i = 1; i < array.length; i++) {
      maxSumSubstringEndingAtIndex[i] = Math.max(maxSumSubstringEndingAtIndex[i - 1] + array[i], array[i]);
    }

    int maxIndex = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] > array[maxIndex]) {
        maxIndex = i;
      }
    }
    return maxIndex;
  }
}
