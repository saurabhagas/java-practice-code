package com.saurabh.dynamic_programming;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestIncreasingSubsequenceTest {
  private final LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();

  @Test
  public void testWithInput1() {
    int[] array = {5, 7, 4, -3, 9, 1, 10, 4, 5, 8, 9, 3};
    int optimalProfit = lis.find(array);
    assertThat(optimalProfit).isEqualTo(6);
  }
}