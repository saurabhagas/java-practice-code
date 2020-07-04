package com.saurabh.practice.famous_algorithms;

/*
Problem - Largest sum contiguous subarray. Problem at: https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
  Approach (O(n) time, O(1) space) using Kadane's algorithm:
   1. currSum stores the sum of current numbers
   2. maxSum keeps track of max sum so far
   3. If currSum becomes negative, reset it
   3. Return the maxSum
 */
public class Kadane {
  public int calculate(int... nums) {
    int currSum = 0;
    int maxSum = Integer.MIN_VALUE;

    for (int num : nums) {
      currSum += num;

      if (currSum > maxSum) {
        maxSum = currSum;
      }

      if (currSum < 0) {
        currSum = 0;
      }
    }
    return maxSum;
  }
}