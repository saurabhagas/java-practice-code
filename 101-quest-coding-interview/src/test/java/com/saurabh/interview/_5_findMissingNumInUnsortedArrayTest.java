package com.saurabh.interview;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _5_findMissingNumInUnsortedArrayTest {
  @Test
  public void findMissing() {
    _5_findMissingNumInUnsortedArray obj = new _5_findMissingNumInUnsortedArray();
    int missing = obj.findMissing(1, 5, 9, 6, 2, 3, 8, 7, 0);
    assertEquals(4, missing);
  }
}