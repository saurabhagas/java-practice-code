package com.saurabh.practice.dynamic_programming;

import java.util.Arrays;

/**
 * Problem: https://leetcode.com/explore/interview/card/microsoft/49/dynamic-programming/156/
 */
public class LongestIncreasingSubsequence {
  public int find(int[] array) {
    int[] memo = new int[array.length];
    memo[0] = 1;
    for (int i = 1; i < array.length; i++) {
      int max = 0;
      for (int j = 0; j < i; j++) {
        if (array[i] > array[j] && max < memo[j]) {
          max = memo[j];
        }
      }
      memo[i] = max + 1;
    }
    return Arrays.stream(memo).max().getAsInt();
  }
}
