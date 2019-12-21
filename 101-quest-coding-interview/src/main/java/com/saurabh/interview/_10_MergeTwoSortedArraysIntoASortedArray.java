package com.saurabh.interview;

/*
 Problem - Merge two sorted arrays to form a bigger sorted array. Problem at: https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays/0/
 Approach (O(m+n) time, O(m+n) space):
    1. Create a new array of size m + n
    2. Loop through the two arrays, copying the smaller current element into the new array
    3. Copy leftover elements from first array into the new array
    4. Copy leftover elements from second array into the new array
    5. Return the new array
*/
public class _10_MergeTwoSortedArraysIntoASortedArray {
  public int[] merge(int[] first, int[] second) {
    if (first == null || second == null) {
      throw new NullPointerException("Arrays can't be null");
    }

    int[] merged = new int[first.length + second.length];
    int index1 = 0, index2 = 0, index3 = 0;
    while (index1 < first.length && index2 < second.length) {
      if (first[index1] <= second[index2]) {
        merged[index3++] = first[index1++];
      } else {
        merged[index3++] = second[index2++];
      }
    }

    if (index1 < first.length) {
      // Add leftover elements from first array
      for (int i = index1; i < first.length; i++) {
        merged[index3++] = first[i];
      }
    }

    if (index2 < second.length) {
      // Add leftover elements from second array
      for (int i = index2; i < second.length; i++) {
        merged[index3++] = second[i];
      }
    }

    return merged;
  }
}