package com.saurabh.divide_and_conquer;

import java.util.Optional;

/**
 * Finds the majority element, if one exists, in an array. Majority element is one which exists more than n/2 times.
 */
public class MajorityElementInArray {
  //TODO: This can be achieved by finding the median of the unsorted array
  /**
   * Finds the majority element using Boyer-Moore majority vote algorithm.
   * Note: This is not a Divide-and-Conquer approach
   */
  Optional<Integer> find(int[] array) {
    int countHint = 0;
    int element = -1;
    int n = array.length;

    if (n == 0) return Optional.empty();

    for (int item : array) {
      if (countHint == 0) {
        element = item;
        countHint++;
      } else if (element == item) {
        countHint++;
      } else {
        countHint--;
      }
    }

    int count = 0;
    for (int value : array) {
      if (element == value) {
        count++;
      }
    }

    if (count > n / 2) return Optional.of(element);
    return Optional.empty();
  }
}
