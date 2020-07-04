package com.saurabh.practice.bit_magic;

/*
 Problem - Find missing number in an array containing n distinct numbers in {0, 1, 2, ..., n}
 Approach (O(n) time, O(1) space) -
    1. Find the XOR of all numbers in {0, 1, 2, ..., n} (n + 1) numbers
    2. Find the XOR of array elements
    3. XOR the result of 1) and 2)
*/

public class FindMissingNumInUnsortedArray {
  public int findMissing(int... nums) {
    int xor = 0;
    // Find the XOR of all numbers in {0, 1, 2, ..., n} (n + 1) numbers
    for (int i = 0; i <= nums.length; i++) {
      xor = xor ^ i;
    }

    for (int num : nums) {
      xor = xor ^ num;
    }

    return xor;
  }
}