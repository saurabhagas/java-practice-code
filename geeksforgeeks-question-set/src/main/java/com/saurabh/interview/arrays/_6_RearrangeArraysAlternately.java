package com.saurabh.interview.arrays;

/**
 * Problem - Given a sorted array of positive integers. Rearrange the array elements alternatively i.e first element should be max value, second should be min value, third should be second max, fourth should be second min and so on...
 * <p>
 * Approach - O(nlogn) time just needed for sorting, swapping needs O(logn) time and O(1) space
 * Sort all the numbers in descending order and keep swapping the largest and smallest by using two pointers
 */
public class _6_RearrangeArraysAlternately {
  public int[] getRearrangedArray(int[] array) {

    if (array == null || array.length == 0) {
      throw new IllegalArgumentException("Array should not be null and must have at least one element");
    }

    array = sortDescending(array);
    int n = array.length;
    int count = n - 2;
    //Start one pointers from each end till the middle of the array and keep on swapping the two elements pointed by them
    for (int i = 0, j = array.length - 1; i <= Math.ceil(array.length / 2.0); i += 2, count -= 2) {
      int temp = array[j];
      System.arraycopy(array, i + 1, array, i + 2, count);
      array[i + 1] = temp;
    }
    return array;
  }

  private int[] sortDescending(int[] arrayToSort) {

    int temp;
    //Sort the array in descending order
    for (int i = 0; i < arrayToSort.length; i++) {
      for (int j = i + 1; j < arrayToSort.length; j++) {
        if (arrayToSort[i] < arrayToSort[j]) {
          temp = arrayToSort[i];
          arrayToSort[i] = arrayToSort[j];
          arrayToSort[j] = temp;
        }
      }
    }

    return arrayToSort;
  }
}
