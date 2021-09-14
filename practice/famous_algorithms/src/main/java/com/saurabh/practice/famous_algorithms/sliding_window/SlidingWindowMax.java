package com.saurabh.practice.famous_algorithms.sliding_window;

import java.util.Arrays;

import com.saurabh.source.data_structures.SegmentTree;
import com.saurabh.source.data_structures.SegmentTree.Operation;

/*
 Calculate the maximums of sliding windows of size k in an array.
 */
public class SlidingWindowMax {
  public static void main(String[] args) {
    SlidingWindowMax obj = new SlidingWindowMax();
    int[] array = {6, 5, 4, 3, 2, 13, 5, 7, 8, 6, 5};
    System.out.println("Using naive approach: " + Arrays.toString(obj.calculate(array, 3)));
    System.out.println("Using segment tree:   " + Arrays.toString(obj.calculateUsingSegmentTree(array, 3)));
  }

  // Solution: Progressively calculates the max in the window as the window slides.
  // Complexity: O(nk) time, O(1) space.
  public int[] calculate(int[] array, int k) {
    checkArguments(array, k);

    int[] toReturn = new int[array.length - k + 1];
    for (int i = 0, index = 0; i <= array.length - k; i++, index++) {
      toReturn[index] = max(array, i, i + k - 1);
    }
    return toReturn;
  }

  // Uses a segment tree to calculate window max
  // Complexity: O(n) space, O(nlogn) time

  public int[] calculateUsingSegmentTree(int[] array, int k) {
    checkArguments(array, k);

    SegmentTree segmentTree = new SegmentTree(array, Operation.of(Integer::max, Integer.MIN_VALUE));
    int[] toReturn = new int[array.length - k + 1];
    for (int i = 0, j = 0; i <= array.length - k; i++, j++) {
      toReturn[j] = segmentTree.rangeQuery(i, i + k - 1);
    }

    return toReturn;
  }

  private int max(int[] array, int i, int j) {
    int max = Integer.MIN_VALUE;
    for (int k = i; k <= j && k < array.length; k++) {
      max = Math.max(max, array[k]);
    }
    return max;
  }

  private void checkArguments(int[] array, int k) {
    if (array == null || array.length == 0 || array.length < k || k == 0) {
      throw new IllegalArgumentException();
    }
  }
}
