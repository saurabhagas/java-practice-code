package com.saurabh.practice.famous_algorithms.sliding_window;

import com.saurabh.source.data_structures.SegmentTree;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Calculate the sums of sliding windows of size k in an array.
 */
public class SlidingWindowSum {
  public static void main(String[] args) {
    SlidingWindowSum obj = new SlidingWindowSum();
    int[] array = {6, 5, 4, 3, 2, 13, 5, 7, 8, 6, 5};
    System.out.println(Arrays.toString(obj.calculate(array, 3)));
    System.out.println(Arrays.toString(obj.calculateUsingSegmentTree(array, 3)));
  }

  // Solution calculate the initial window sum, removes the first added element and adds a new element as the window slides.
  // Complexity: O(n) time, O(1) space.
  public int[] calculate(int[] array, int k) {
    if (array == null || array.length < k) {
      throw new IllegalArgumentException();
    }

    int windowSum = 0;
    for (int i = 0; i < k; i++) {
      windowSum += array[i];
    }

    ArrayList<Integer> toReturn = new ArrayList<>();
    toReturn.add(windowSum);
    for (int i = 0, j = k; j < array.length; i++, j++) {
      int beforeWindow = array[i];
      int afterWindow = array[j];
      windowSum = windowSum - beforeWindow + afterWindow;
      toReturn.add(windowSum);
    }

    return toReturn.stream().mapToInt(value -> value).toArray();
  }

  public int[] calculateUsingSegmentTree(int[] array, int k) {
    SegmentTree segmentTree = new SegmentTree(array, SegmentTree.Operation.of(Integer::sum, 0));
    ArrayList<Integer> toReturn = new ArrayList<>();
    for (int i = 0; i <= array.length - k; i++) {
      toReturn.add(segmentTree.rangeQuery(i, i + k - 1));
    }

    return toReturn.stream().mapToInt(value -> value).toArray();
  }
}
