package com.saurabh.interview.arrays;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class _1_SubarrayWithGivenSumTest {
  @Test
  public void foundAtFirstIndex() {
    _1_SubarrayWithGivenSum obj = new _1_SubarrayWithGivenSum();
    int[] subarray = obj.find(30, 30, 1, 4, 20, 3, 10, 5);
    assertEquals(1, subarray.length);
  }

  @Test
  public void foundAtLastIndex() {
    _1_SubarrayWithGivenSum obj = new _1_SubarrayWithGivenSum();
    int[] subarray = obj.find(30, 1, 4, 20, 3, 10, 5, 30);
    assertEquals(1, subarray.length);
  }

  @Test
  public void foundInTheMiddle() {
    _1_SubarrayWithGivenSum obj = new _1_SubarrayWithGivenSum();
    int[] subarray = obj.find(30, 1, 4, 20, 30, 10, 5);
    assertEquals(1, subarray.length);
  }

  @Test
  public void foundInRangeStartingAtFirstIndex() {
    _1_SubarrayWithGivenSum obj = new _1_SubarrayWithGivenSum();
    int[] subarray = obj.find(33, 20, 3, 10, 5, 1, 4);
    assertArrayEquals(new int[] {20, 3, 10}, subarray);
  }

  @Test
  public void foundInRangeInTheMiddle() {
    _1_SubarrayWithGivenSum obj = new _1_SubarrayWithGivenSum();
    int[] subarray = obj.find(33, 1, 4, 20, 3, 10, 5);
    assertArrayEquals(new int[] {20, 3, 10}, subarray);
  }

  @Test
  public void foundInRangeAtEnd() {
    _1_SubarrayWithGivenSum obj = new _1_SubarrayWithGivenSum();
    int[] subarray = obj.find(33, 50, 1, 4, 20, 3, 10);
    assertArrayEquals(new int[] {20, 3, 10}, subarray);
  }
}