package com.saurabh.practice.dynamic_programming;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestCommonSubsequenceTest {
  private final LongestCommonSubsequence lcs = new LongestCommonSubsequence();

  @Test
  public void testWithInput1() {
    String first = "ABCBDAB";
    String second = "BDCABA";
    int optimalProfit = lcs.calculate(first, second);
    assertThat(optimalProfit).isEqualTo(4);

    String optionalSubsequence = lcs.calculateAndPrint(first, second);
    assertThat(optionalSubsequence).isIn("BCBA", "BDAB", "BCAB");
  }

  @Test
  public void testWithInput2() {
    String first = "ABCDGH";
    String second = "AEDFHR";
    int optimalProfit = lcs.calculate(first, second);
    assertThat(optimalProfit).isEqualTo(3);

    String optionalSubsequence = lcs.calculateAndPrint(first, second);
    assertThat(optionalSubsequence).isIn("ADH");
  }
}