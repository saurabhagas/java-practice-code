package com.saurabh.practice.dynamic_programming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxSumSubArrayTest {
  private final MaxSumSubArray obj = new MaxSumSubArray();

  @Test
  public void testSolutionInMiddleOfArray() {
    int maxContiguousSum = obj.calculate(-2, -3, 4, -1, -2, 1, 5, -3);
    assertEquals(maxContiguousSum, 7);
  }

  @Test
  public void testArrayItselfIsSolution() {
    int maxContiguousSum = obj.calculate(1, 2, 3, -2, 5);
    assertEquals(maxContiguousSum, 9);
  }

  @Test
  public void testAllNegative() {
    int maxContiguousSum = obj.calculate(-1, -2, -3, -4, -5);
    assertEquals(maxContiguousSum, -1);
  }

  @Test
  public void testAllPositive() {
    int maxContiguousSum = obj.calculate(1, 2, 3, 4, 5);
    assertEquals(maxContiguousSum, 15);
  }
}