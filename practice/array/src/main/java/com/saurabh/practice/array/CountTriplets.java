package com.saurabh.practice.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem - Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.
 * <p>
 * Approach - O(n^2) time and O(n) space
 * Save all numbers in a map and for the sum of pair of two numbers, check if the sum exists in the map
 */
public class CountTriplets {
  public int countTriplets(int[] numbersArray) {

    if (numbersArray == null || numbersArray.length == 0) {
      throw new IllegalArgumentException("Array should not be null and must have at least one element");
    }

    Set<Integer> numbersSet = new HashSet<Integer>();
    int count = 0;
    for (int i : numbersArray) {
      numbersSet.add(i);
    }
    for (int in = 0; in < numbersArray.length; in++) {
      for (int out = in + 1; out < numbersArray.length; out++) {
        if (in != out) {
          int currSum = numbersArray[in] + numbersArray[out];
          if (numbersSet.contains(currSum)) {
            count++;
          }
        }
      }
    }
    return count;
  }
}
