package com.saurabh.interview.arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _3_ContiguousSubArrayWithMaxSumTest {
  @Test
  public void testSolutionInMiddleOfArray() {
    _3_ContiguousSubArrayWithMaxSum obj = new _3_ContiguousSubArrayWithMaxSum();
    int maxContiguousSum = obj.calculate(-2, -3, 4, -1, -2, 1, 5, -3);
    assertEquals(maxContiguousSum, 7);
  }

  @Test
  public void testArrayItselfIsSolution() {
    _3_ContiguousSubArrayWithMaxSum obj = new _3_ContiguousSubArrayWithMaxSum();
    int maxContiguousSum = obj.calculate(1, 2, 3, -2, 5);
    assertEquals(maxContiguousSum, 9);
  }

  @Test
  public void testAllNegative() {
    _3_ContiguousSubArrayWithMaxSum obj = new _3_ContiguousSubArrayWithMaxSum();
    int maxContiguousSum = obj.calculate(-1, -2, -3, -4, -5);
    assertEquals(maxContiguousSum, -1);
  }

  @Test
  public void testAllPositive() {
    _3_ContiguousSubArrayWithMaxSum obj = new _3_ContiguousSubArrayWithMaxSum();
    int maxContiguousSum = obj.calculate(1, 2, 3, 4, 5);
    assertEquals(maxContiguousSum, 15);
  }
}