package com.saurabh.practice.dynamic_programming;

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

  @Test
  public void testWithInput2() {
    int[] array = {0, 1, 0, 3, 2, 3};
    int optimalProfit = lis.find(array);
    assertThat(optimalProfit).isEqualTo(4);
  }

  @Test
  public void testWithAllZeroEntries() {
    int[] array = {0, 0, 0, 0, 0, 0};
    int optimalProfit = lis.find(array);
    assertThat(optimalProfit).isEqualTo(1);
  }

  @Test
  public void testWithAllPositiveEntries() {
    int[] array = {10, 10, 10, 10, 10, 10};
    int optimalProfit = lis.find(array);
    assertThat(optimalProfit).isEqualTo(1);
  }

  @Test
  public void testWithAllNegativeEntries() {
    int[] array = {-10, -10, -10, -10, -10, -10};
    int optimalProfit = lis.find(array);
    assertThat(optimalProfit).isEqualTo(1);
  }
}