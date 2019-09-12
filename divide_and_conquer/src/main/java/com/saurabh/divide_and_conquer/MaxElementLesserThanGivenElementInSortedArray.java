package com.saurabh.divide_and_conquer;

import java.util.Optional;

public class MaxElementLesserThanGivenElementInSortedArray {
  static Optional<Integer> search(int[] array, int givenElement) {
    int foundAt = -1;
    int low = 0, high = array.length - 1;
    while (low <= high && foundAt == -1) {
      int mid = (low + high) / 2;
      if (array[mid] == givenElement) {
        foundAt = mid;
      } else if (givenElement > array[mid]) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    Optional<Integer> optional = Optional.empty();
    if (foundAt == -1 && high >= 0) {
      return Optional.of(array[high]); // array[high] is on the left of low, and contains our desired result
    } else if (foundAt - 1 >= 0) {
      return Optional.of(array[foundAt - 1]);
    }
    return optional;
  }
}
