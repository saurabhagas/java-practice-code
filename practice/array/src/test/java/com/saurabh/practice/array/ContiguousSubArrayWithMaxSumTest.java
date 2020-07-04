package com.saurabh.practice.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContiguousSubArrayWithMaxSumTest {
  @Test
  public void testSolutionInMiddleOfArray() {
    ContiguousSubArrayWithMaxSum obj = new ContiguousSubArrayWithMaxSum();
    int maxContiguousSum = obj.calculate(-2, -3, 4, -1, -2, 1, 5, -3);
    assertEquals(maxContiguousSum, 7);
  }

  @Test
  public void testArrayItselfIsSolution() {
    ContiguousSubArrayWithMaxSum obj = new ContiguousSubArrayWithMaxSum();
    int maxContiguousSum = obj.calculate(1, 2, 3, -2, 5);
    assertEquals(maxContiguousSum, 9);
  }

  @Test
  public void testAllNegative() {
    ContiguousSubArrayWithMaxSum obj = new ContiguousSubArrayWithMaxSum();
    int maxContiguousSum = obj.calculate(-1, -2, -3, -4, -5);
    assertEquals(maxContiguousSum, -1);
  }

  @Test
  public void testAllPositive() {
    ContiguousSubArrayWithMaxSum obj = new ContiguousSubArrayWithMaxSum();
    int maxContiguousSum = obj.calculate(1, 2, 3, 4, 5);
    assertEquals(maxContiguousSum, 15);
  }
}