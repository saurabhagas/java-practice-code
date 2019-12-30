package com.saurabh.interview.arrays;

import com.saurabh.interview.arrays._4_findMissingNumInUnsortedArray;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _4_findMissingNumInUnsortedArrayTest {
  @Test
  public void findMissing() {
    _4_findMissingNumInUnsortedArray obj = new _4_findMissingNumInUnsortedArray();
    int missing = obj.findMissing(1, 5, 9, 6, 2, 3, 8, 7, 0);
    assertEquals(4, missing);
  }
}