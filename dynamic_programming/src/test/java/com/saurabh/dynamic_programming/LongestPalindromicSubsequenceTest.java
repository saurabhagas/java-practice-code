package com.saurabh.dynamic_programming;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestPalindromicSubsequenceTest {
  @Test
  public void testWithInput1() {
    String input = "AGCTCBMAACTGGAM";
    LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence(input);
    int lpsLength = lps.find();
    assertThat(lpsLength).isEqualTo(10);
  }
}