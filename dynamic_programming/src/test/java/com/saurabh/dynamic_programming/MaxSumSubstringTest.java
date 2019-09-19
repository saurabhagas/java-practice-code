package com.saurabh.dynamic_programming;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxSumSubstringTest {
  private final MaxSumSubstring maxSumSubstring = new MaxSumSubstring();

  @Test
  public void testWithInput1() {
    int[] array = {-2, 11, -4, 13, -5, 2};
    int optimalProfit = maxSumSubstring.find(array);
    assertThat(optimalProfit).isEqualTo(20);

    String optionalSubsequence = maxSumSubstring.findAndPrint(array);
    assertThat(optionalSubsequence).isEqualTo("11, -4, 13");
  }

  @Test
  public void testWithInput2() {
    int[] array = {1, -3, 4, -2, -1, 6};
    int optimalProfit = maxSumSubstring.find(array);
    assertThat(optimalProfit).isEqualTo(7);

    String optionalSubsequence = maxSumSubstring.findAndPrint(array);
    assertThat(optionalSubsequence).isEqualTo("4, -2, -1, 6");
  }
}