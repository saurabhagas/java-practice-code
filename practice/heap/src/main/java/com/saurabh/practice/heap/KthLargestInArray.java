package com.saurabh.practice.heap;

/*
 Problem - find kth largest number in an unsorted array. Problem at: https://leetcode.com/problems/kth-largest-element-in-an-array/
 Approach - Max-heapify the array. Pop k-1 elements. Return the kth element.
*/

import com.saurabh.source.data_structures.MinMaxHeap;

public class KthLargestInArray {
  public int findKthLargest(int k, Integer... nums) {
    // Builds a heap from array in O(n) time
    MinMaxHeap<Integer> maxHeap = new MinMaxHeap<>(false, nums);

    // O(klogn) operations for k pop-ups
    for (int i = 0; i < k - 1; i++) {
      maxHeap.remove();
    }
    return maxHeap.remove();
  }
}