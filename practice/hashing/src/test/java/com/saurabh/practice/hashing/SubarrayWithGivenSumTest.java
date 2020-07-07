package com.saurabh.practice.hashing;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SubarrayWithGivenSumTest {
  @Test
  public void foundAtFirstIndex() {
    SubarrayWithGivenSum obj = new SubarrayWithGivenSum();
    int[] subarray = obj.find(30, 30, 1, 4, 20, 3, 10, 5);
    assertEquals(1, subarray.length);
  }

  @Test
  public void foundAtLastIndex() {
    SubarrayWithGivenSum obj = new SubarrayWithGivenSum();
    int[] subarray = obj.find(30, 1, 4, 20, 3, 10, 5, 30);
    assertEquals(1, subarray.length);
  }

  @Test
  public void foundInTheMiddle() {
    SubarrayWithGivenSum obj = new SubarrayWithGivenSum();
    int[] subarray = obj.find(30, 1, 4, 20, 30, 10, 5);
    assertEquals(1, subarray.length);
  }

  @Test
  public void foundInRangeStartingAtFirstIndex() {
    SubarrayWithGivenSum obj = new SubarrayWithGivenSum();
    int[] subarray = obj.find(33, 20, 3, 10, 5, 1, 4);
    assertArrayEquals(new int[]{20, 3, 10}, subarray);
  }

  @Test
  public void foundInRangeInTheMiddle() {
    SubarrayWithGivenSum obj = new SubarrayWithGivenSum();
    int[] subarray = obj.find(33, 1, 4, 20, 3, 10, 5);
    assertArrayEquals(new int[]{20, 3, 10}, subarray);
  }

  @Test
  public void foundInRangeAtEnd() {
    SubarrayWithGivenSum obj = new SubarrayWithGivenSum();
    int[] subarray = obj.find(33, 50, 1, 4, 20, 3, 10);
    assertArrayEquals(new int[]{20, 3, 10}, subarray);
  }
}