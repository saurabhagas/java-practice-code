package com.saurabh.practice.famous_algorithms.sliding_window;

import com.saurabh.source.data_structures.SegmentTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

/*
 Calculate the maximums of sliding windows of size k in an array.
 */
public class SlidingWindowMax {
  public static void main(String[] args) {
    SlidingWindowMax obj = new SlidingWindowMax();
    int[] array = {6, 5, 4, 3, 2, 13, 5, 7, 8, 6, 5};
    System.out.println(Arrays.toString(obj.calculate(array, 3)));
    System.out.println(Arrays.toString(obj.calculateUsingSegmentTree(array, 3)));
  }

  // Solution: Progressively calculates the max in the window as the window slides.
  // Complexity: O(nk) time, O(1) space.
  public int[] calculate(int[] array, int k) {
    if (array == null || array.length < k) {
      throw new IllegalArgumentException();
    }

    int windowMax = 0;
    ArrayList<Integer> toReturn = new ArrayList<>();
    for (int i = 0, j = k; i <= array.length - k; i++, j++) {
      windowMax = max(array, i, j);
      toReturn.add(windowMax);
    }

    return toReturn.stream().mapToInt(value -> value).toArray();
  }

  // Uses a segment tree to calculate window max
  // Complexity: O(n) space, O(nlogn) time
  public int[] calculateUsingSegmentTree(int[] array, int k) {
    SegmentTree segmentTree = new SegmentTree(array, SegmentTree.Operation.of(Integer::max, Integer.MIN_VALUE));
    ArrayList<Integer> toReturn = new ArrayList<>();
    for (int i = 0; i <= array.length - k; i++) {
      toReturn.add(segmentTree.rangeQuery(i, i + k - 1));
    }

    return toReturn.stream().mapToInt(value -> value).toArray();
  }

  private int max(int[] array, int i, int j) {
    return IntStream.of(Arrays.copyOfRange(array, i, j)).max().getAsInt();
  }
}
