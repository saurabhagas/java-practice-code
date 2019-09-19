package com.saurabh.dynamic_programming;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestCommonSubsequenceTest {
  private final LongestCommonSubsequence lcs = new LongestCommonSubsequence();

  @Test
  public void testWithInput1() {
    String first = "ABCBDAB";
    String second = "BDCABA";
    // LCS(first, second) = {"BCBA", "BDAB", "BCAB"}
    int optimalProfit = lcs.calculate(first, second);
    assertThat(optimalProfit).isEqualTo(4);
  }

  @Test
  public void testWithInput2() {
    String first = "ABCDGH";
    String second = "AEDFHR";
    // LCS(first, second) = {"ADH"}
    int optimalProfit = lcs.calculate(first, second);
    assertThat(optimalProfit).isEqualTo(3);
  }
}