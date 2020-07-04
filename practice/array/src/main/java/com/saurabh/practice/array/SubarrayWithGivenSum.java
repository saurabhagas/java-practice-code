package com.saurabh.practice.array;

import java.util.HashMap;

/*
 Problem - Find the subarray whose sum is equal to the given sum. Problem at: https://leetcode.com/problems/find-pivot-index/
 Approach (O(n) time, O(1) space):
    1. Create a map to store cumulative sum to index mappings
    2. Create a variable cum_sum to store the cumulative sum
    3. Loop through the array updating the cumulative sum variable.
    4. If `cum_sum - sum` exists in the map, return the subarray.
    5. Else, store the cum_sum in the map.
*/
public class SubarrayWithGivenSum {
  public int[] find(int sum, int... nums) {
    if (nums == null || nums.length == 0) {
      throw new IllegalArgumentException("Array must not be null or empty");
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    int cumulative = 0;

    for (int i = 0; i < nums.length; i++) {
      cumulative += nums[i];

      if (map.containsKey(cumulative - sum)) {
        int start = map.get(cumulative - sum);
        int[] dest = new int[i - start];
        System.arraycopy(nums, start + 1, dest, 0, i - start);
        return dest;
      } else if (cumulative == sum) {
        // This means that the sum is possible using the first index
        int start = -1;
        int[] dest = new int[i - start];
        System.arraycopy(nums, start + 1, dest, 0, i - start);
        return dest;
      }

      map.put(cumulative, i);
    }
    return new int[0];
  }
}