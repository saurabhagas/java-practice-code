package com.saurabh.practice;

import static java.lang.System.arraycopy;

/*
 Problem - Rotate an array by k positions. Problem at: https://www.geeksforgeeks.org/array-rotation/
 Approach (O(n) time, O(1) space) -
    1. Rotate the array leftwards k times
*/
public class RotateArray {
  public void rotate(int k, int... nums) {
    if (nums == null || nums.length == 0) {
      throw new IllegalArgumentException("Array must not be null or empty");
    }

    if (k <= 0 || k >= nums.length) {
      throw new IllegalArgumentException("k must be a positive integer < array size");
    }

    for (int i = 0; i < k; i++) {
      rotateByOne(nums);
    }
  }

  private void rotateByOne(int[] nums) {
    int temp = nums[0];
    arraycopy(nums, 1, nums, 0, nums.length - 1);
    nums[nums.length - 1] = temp;
  }
}