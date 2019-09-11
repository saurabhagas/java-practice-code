package com.saurabh.divide_and_conquer;

/**
 * Finds the magic index, if one exists, in an array containing unique elements sorted in increasing order.
 * A magic index is the index at which array[i] = i.
 */
public class MagicIndexInArray {
  int search(int[] array) {
    int low = 0;
    int high = 0;

    while (true) {
      if (array[high] == high) {
        return high;
      } else if (high > array[high]) {
        low = high;
        high = low == 0 ? low + 1 : low * 2;
      } else {
        // index i found where array[i] > i. This means the magic index cannot be found rightwards of this
        // index given the problem restrictions
        return binarySearch(array, low, high);
      }
    }
  }

  /**
   * @return the index of the found element, -1 otherwise
   */
  private int binarySearch(int[] array, int low, int high) {
    if (low > high) {
      return -1;
    }

    int mid = (low + high) / 2;
    if (array[mid] == mid) {
      return mid;
    } else if (mid > array[mid]) {
      return binarySearch(array, mid + 1, high);
    } else {
      return binarySearch(array, low, mid - 1);
    }
  }
}
