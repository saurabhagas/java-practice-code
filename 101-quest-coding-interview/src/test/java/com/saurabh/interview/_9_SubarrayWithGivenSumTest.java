package com.saurabh.interview;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class _9_SubarrayWithGivenSumTest {
  @Test
  public void foundAtFirstIndex() {
    _9_SubarrayWithGivenSum obj = new _9_SubarrayWithGivenSum();
    int[] subarray = obj.find(30, 30, 1, 4, 20, 3, 10, 5);
    assertEquals(1, subarray.length);
  }

  @Test
  public void foundAtLastIndex() {
    _9_SubarrayWithGivenSum obj = new _9_SubarrayWithGivenSum();
    int[] subarray = obj.find(30, 1, 4, 20, 3, 10, 5, 30);
    assertEquals(1, subarray.length);
  }

  @Test
  public void foundInTheMiddle() {
    _9_SubarrayWithGivenSum obj = new _9_SubarrayWithGivenSum();
    int[] subarray = obj.find(30, 1, 4, 20, 30, 10, 5);
    assertEquals(1, subarray.length);
  }

  @Test
  public void foundInRangeStartingAtFirstIndex() {
    _9_SubarrayWithGivenSum obj = new _9_SubarrayWithGivenSum();
    int[] subarray = obj.find(33, 20, 3, 10, 5, 1, 4);
    assertArrayEquals(new int[] {20, 3, 10}, subarray);
  }

  @Test
  public void foundInRangeInTheMiddle() {
    _9_SubarrayWithGivenSum obj = new _9_SubarrayWithGivenSum();
    int[] subarray = obj.find(33, 1, 4, 20, 3, 10, 5);
    assertArrayEquals(new int[] {20, 3, 10}, subarray);
  }

  @Test
  public void foundInRangeAtEnd() {
    _9_SubarrayWithGivenSum obj = new _9_SubarrayWithGivenSum();
    int[] subarray = obj.find(33, 50, 1, 4, 20, 3, 10);
    assertArrayEquals(new int[] {20, 3, 10}, subarray);
  }
}