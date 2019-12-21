package com.saurabh.interview;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class _10_MergeTwoSortedArraysIntoASortedArrayTest {
  @Test
  public void testWithFirstSmallerThanSecond() {
    _10_MergeTwoSortedArraysIntoASortedArray obj = new _10_MergeTwoSortedArraysIntoASortedArray();
    int[] arr1 = {2};
    int[] arr2 = {3, 10};
    int[] merged = obj.merge(arr1, arr2);
    assertArrayEquals(new int[]{2, 3, 10}, merged);
  }

  @Test
  public void testWithFirstLargerThanSecond() {
    _10_MergeTwoSortedArraysIntoASortedArray obj = new _10_MergeTwoSortedArraysIntoASortedArray();
    int[] arr1 = {3, 10};
    int[] arr2 = {2};
    int[] merged = obj.merge(arr1, arr2);
    assertArrayEquals(new int[]{2, 3, 10}, merged);
  }

  @Test
  public void testWithBothArraysOfSameSize() {
    _10_MergeTwoSortedArraysIntoASortedArray obj = new _10_MergeTwoSortedArraysIntoASortedArray();
    int[] arr1 = {2, 5};
    int[] arr2 = {3, 10};
    int[] merged = obj.merge(arr1, arr2);
    assertArrayEquals(new int[]{2, 3, 5, 10}, merged);
  }

  @Test
  public void testLargerExample() {
    _10_MergeTwoSortedArraysIntoASortedArray obj = new _10_MergeTwoSortedArraysIntoASortedArray();
    int[] arr1 = {1, 5, 9, 10, 15, 20};
    int[] arr2 = {2, 3, 8, 13};
    int[] merged = obj.merge(arr1, arr2);
    assertArrayEquals(new int[]{1, 2, 3, 5, 8, 9, 10, 13, 15, 20}, merged);
  }
}