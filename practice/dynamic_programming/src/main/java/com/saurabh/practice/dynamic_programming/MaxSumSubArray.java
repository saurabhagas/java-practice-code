package com.saurabh.practice.dynamic_programming;

import static com.saurabh.source.common.MathUtils.max;

/*
Problem - Largest sum contiguous subarray. Problem at: https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 Approach (O(n) time, O(n) space) using DP:
  1. Let maxUptoI[i] be the max sum subarray upto index i, including index i
  2. Calculate maxUptoI for i's upto length of array
  3. Return the max value in mapUptoI
*/
public class MaxSumSubArray {
  public int calculate(int... nums) {
    if (nums == null || nums.length == 0) {
      throw new IllegalArgumentException("Array must not be null or empty");
    }
    int[] maxUptoI = new int[nums.length];
    maxUptoI[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      maxUptoI[i] = max(maxUptoI[i - 1] + nums[i], nums[i]);
    }
    return max(maxUptoI);
  }
}