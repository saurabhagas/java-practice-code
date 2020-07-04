package com.saurabh.practice.array;

/*
 Problem - Find the index for which the left array sum is equal to the right array sum, if such an index exists, -1 otherwise.
           Problem at: https://leetcode.com/problems/find-pivot-index/
 Approach (O(n) time, O(n) space):
    1. Create a prefix sum array of size nums.length
    2. Fill prefix sum array with sums of numbers to the left of any index. Repeat for i upto n.
    3. Loop through the nums array, check if postFixSum == prefixSum. Return the first such index.
    4. Return -1 otherwise.
*/
public class EquilibriumPointInArray {
  public int find(int... nums) {
    if (nums == null || nums.length == 0) {
      throw new IllegalArgumentException("Array must not be null or empty");
    }

    // No equilibrium point for arrays containing 1 or 2 elements
    if (nums.length < 2) {
      return -1;
    }

    int[] prefixSums = new int[nums.length];
    prefixSums[0] = -1;
    prefixSums[1] = nums[0];
    for (int i = 2; i < nums.length; i++) {
      prefixSums[i] = prefixSums[i - 1] + nums[i - 1];
    }

    for (int i = 1; i < nums.length; i++) {
      int postFixSum = prefixSums[nums.length - 1] + nums[nums.length - 1] - nums[i] - prefixSums[i];
      if (prefixSums[i] == postFixSum) {
        return i;
      }
    }
    return -1;
  }
}