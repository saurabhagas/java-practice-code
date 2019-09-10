package com.saurabh.divide_and_conquer;

/**
 * Program which finds if an element exists in an array consisting of n integers in increasingly sorted order (where n is
 * unknown) and infinite values after index n.
 *
 * Program runtime: O(logn)
 */
public class BinarySearchInInfiniteArray {
  static int search(int[] array, int elementToSearch) {
    int low = 0;
    int high = 0;

    while (true) {
      if (array[high] == elementToSearch) {
        return high;
      } else if (elementToSearch > array[high]) {
        low = high;
        high = low == 0 ? low + 1 : low * 2;
      } else {
        return binarySearch(array, elementToSearch, low, high);
      }
    }
  }

  /**
   * @return the index of the found element, -1 otherwise
   */
  private static int binarySearch(int[] array, int elementToSearch, int low, int high) {
    if (low > high) {
      return -1;
    }

    int mid = (low + high) / 2;
    if (array[mid] == elementToSearch) {
      return mid;
    } else if (elementToSearch > array[mid]) {
      return binarySearch(array, elementToSearch, mid + 1, high);
    } else {
      return binarySearch(array, elementToSearch, low, mid - 1);
    }
  }
}
