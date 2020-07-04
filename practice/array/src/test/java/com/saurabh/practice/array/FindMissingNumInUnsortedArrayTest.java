package com.saurabh.practice.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindMissingNumInUnsortedArrayTest {
  @Test
  public void findMissing() {
    FindMissingNumInUnsortedArray obj = new FindMissingNumInUnsortedArray();
    int missing = obj.findMissing(1, 5, 9, 6, 2, 3, 8, 7, 0);
    assertEquals(4, missing);
  }
}