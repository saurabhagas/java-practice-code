package com.saurabh.practice.famous_algorithms;

/*
Problem - Largest sum contiguous subarray. Problem at: https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
  Approach (O(n) time, O(1) space) using Kadane's algorithm (DP without extra space):
   1. currSum stores the sum of current numbers
   2. maxSum keeps track of max sum so far
   3. If currSum becomes negative, reset it
   3. Return the maxSum
 */
public class Kadane {
  public int calculate(int... nums) {
    int currSum = 0;
    int maxSum = Integer.MIN_VALUE;

    // Standard DP solution using O(n) space
//    for (int i = 1; i < nums.length; i++) {
//      int num = nums[i];
//      dp[i] = Math.max(dp[i - 1], 0) + num;
//      maxSum = Math.max(currSum, maxSum);
//    }

    // O(n) space isn't really needed
    for (int num : nums) {
      currSum = Math.max(currSum, 0) + num;
      maxSum = Math.max(currSum, maxSum);
    }
    return maxSum;
  }
}