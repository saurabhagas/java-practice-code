package com.saurabh.practice.divide_and_conquer;

public class ShiftedBinarySearch {
  public static void main(String[] args) {
    int[] array = {45, 61, 71, 72, 73, 0, 1, 21, 33, 37};
    int foundAt = modifiedBinarySearch(array, 33, 0, array.length - 1);
    System.out.println("foundAt = " + foundAt);
  }

  private static int modifiedBinarySearch(int[] array, int target, int start, int end) {
    if (start > end) return -1;

    int mid = (start + end) / 2;
    int midElement = array[mid];
    if (target == midElement) {
      return mid;
    } else if (midElement >= array[start]) {
      if (target < midElement && target >= array[start]) {
        return modifiedBinarySearch(array, target, start, mid - 1);
      } else {
        return modifiedBinarySearch(array, target, mid + 1, end);
      }
    } else {
      if (target > midElement && target <= array[end]) {
        return modifiedBinarySearch(array, target, mid + 1, end);
      } else {
        return modifiedBinarySearch(array, target, start, mid - 1);
      }
    }
  }
}
