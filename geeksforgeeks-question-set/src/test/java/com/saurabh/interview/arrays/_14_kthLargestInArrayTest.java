package com.saurabh.interview.arrays;

import com.saurabh.interview.arrays._14_kthLargestInArray;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _14_kthLargestInArrayTest {
  @Test
  public void findKthLargest_1() {
    _14_kthLargestInArray obj = new _14_kthLargestInArray();
    int kthLargest = obj.findKthLargest(2, 3, 2, 1, 5, 6, 4);
    assertEquals(kthLargest, 5);
  }

  @Test
  public void findKthLargest_2() {
    _14_kthLargestInArray obj = new _14_kthLargestInArray();
    int kthLargest = obj.findKthLargest(4, 3, 2, 3, 1, 2, 4, 5, 5, 6);
    assertEquals(kthLargest, 4);
  }
}