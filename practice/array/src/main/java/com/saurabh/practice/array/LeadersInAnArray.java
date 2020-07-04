package com.saurabh.practice.array;

import java.util.Arrays;

/**
 * Problem - Given an array of positive integers. Your task is to find the leaders in the array.
 * Note: An element of array is leader if it is greater than or equal to all the elements to its right side. Also, the rightmost element is always a leader.
 *
 * Approach - O(n) time complexity O(1) space complexity
 *
 * Start from the right side of the array and maintain the max number and if the input number is greater than the max number then add to the array of leaders
 */
public class LeadersInAnArray {
  public int[] getLeadersInAnArray(int[] inputArray) {
    int max = Integer.MIN_VALUE, count = inputArray.length - 1;
    int[] leaders = new int[inputArray.length];
    for (int i = inputArray.length - 1; i >= 0; i--) {
      if (max <= inputArray[i]) {
        leaders[count--] = inputArray[i];
        max = inputArray[i];
      }
    }
    return Arrays.copyOfRange(leaders, count + 1, inputArray.length);
  }
}
