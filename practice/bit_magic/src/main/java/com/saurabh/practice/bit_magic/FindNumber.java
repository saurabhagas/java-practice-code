package com.saurabh.practice.bit_magic;

public class FindNumber {
  public static void main(String[] args) {
    System.out.println("---------------------------------");
    System.out.println(findMissingNumberInWholeNumbers(0, 1, 3, 4, 5));
    System.out.println(findMissingNumberInWholeNumbers(0, 2, 3, 4, 5));
    System.out.println(findMissingNumberInWholeNumbers(0, 1, 2, 3, 4));
    System.out.println(findMissingNumberInWholeNumbers(1, 2, 3, 4, 5));

    System.out.println("---------------------------------");
    System.out.println(findOnlyNonRepeatedNumber(0, 4, 1, 1, 3, 0, 4, 5, 3));
  }

  /**
   Problem - Find missing number in an array containing n distinct numbers in {0, 1, 2, ..., n}
   Approach (O(n) time, O(1) space) -
   1. Find the XOR of all numbers in {0, 1, 2, ..., n} (n + 1) numbers
   2. Find the XOR of array elements
   3. XOR the result of 1) and 2)
   */
  public static int findMissingNumberInWholeNumbers(int... nums) {
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

  public static int findOnlyNonRepeatedNumber(int... nums) {
    int xor = 0;
    for (int num : nums) {
      xor = xor ^ num;
    }
    return xor;
  }
}