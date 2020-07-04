package com.saurabh.practice.array;

/**
 * Problem - Given an array of positive integers. The task is to find inversion count of array.
 * Inversion Count : For an array, inversion count indicates how far (or close) the array is from being sorted.
 * If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum.
 * Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 * Inversion count is the sum of count of all numbers lesser than a number, situated to the right of the number in an array
 * <p>
 * Approach - O(nlogn) time and O(n) space
 * In merge function of merge sort whenever merging two arrays, if any element in right array is smaller than the left one,
 * then the number of elements in the array to the right of the smaller element add to the inversion count
 */
public class InversionCountOfArray {
  public int getInversionCount(int[] numbersArray) {
    if (numbersArray == null || numbersArray.length == 0) {
      throw new IllegalArgumentException("Array should not be null and must have at least one element");
    }
    return mergeSort(numbersArray, 0, numbersArray.length - 1);
  }

  private int mergeSort(int[] array, int start, int end) {
    int inversionCount = 0;
    if (start < end) {
      int mid = (start + end) / 2;
      inversionCount += mergeSort(array, start, mid);
      inversionCount += mergeSort(array, mid + 1, end);
      inversionCount += merge(array, start, mid, end);
    }
    return inversionCount;
  }

  private int merge(int[] array, int start, int mid, int end) {
    int[] L = new int[mid - start + 1];
    int[] R = new int[end - mid];
    System.arraycopy(array, start, L, 0, mid - start + 1);
    System.arraycopy(array, mid + 1, R, 0, end - mid);
    int i = 0, j = 0, k = start, inversionCount = 0;
    while (i < L.length && j < R.length) {
      if (L[i] <= R[j]) {
        array[k++] = L[i++];
      } else {
        array[k++] = R[j++];
        //inversion count is the number of elements left after i in array L
        inversionCount += (L.length - i);
      }
    }
    while (i < L.length) {
      array[k++] = L[i++];
    }
    while (j < R.length) {
      array[k++] = R[j++];
    }
    return inversionCount;
  }
}
