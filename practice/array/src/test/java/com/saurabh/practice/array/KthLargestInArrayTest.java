package com.saurabh.practice.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KthLargestInArrayTest {
  @Test
  public void findKthLargest_1() {
    KthLargestInArray obj = new KthLargestInArray();
    int kthLargest = obj.findKthLargest(2, 3, 2, 1, 5, 6, 4);
    assertEquals(kthLargest, 5);
  }

  @Test
  public void findKthLargest_2() {
    KthLargestInArray obj = new KthLargestInArray();
    int kthLargest = obj.findKthLargest(4, 3, 2, 3, 1, 2, 4, 5, 5, 6);
    assertEquals(kthLargest, 4);
  }
}