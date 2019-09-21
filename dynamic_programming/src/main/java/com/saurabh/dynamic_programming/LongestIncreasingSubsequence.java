package com.saurabh.dynamic_programming;

import java.util.stream.IntStream;

/**
 * Given an array of n numbers, give an algorithm for finding the longest increasing subsequence. Subsequence means that
 * the elements don't have to be contiguous.
 */
public class LongestIncreasingSubsequence {
  // Returns the max sum substring in the array
  int find(int[] array) {
    int[] lisEndingAtIndex = new int[array.length];
    for (int i = 0; i < array.length - 1; i++) {
      lisEndingAtIndex[i] = 1;
      for (int j = 0; j < i; j++) {
        if (array[j] < array[i]) {
          lisEndingAtIndex[i] = lisEndingAtIndex[j] + 1;
        }
      }
    }

    return IntStream.of(lisEndingAtIndex).max().getAsInt();
  }
}
