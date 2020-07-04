package com.saurabh.practice.string;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestCommonPrefixTest {
  @Test
  public void testThreeAlphabetPrefix() {
    LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
    String prefix = longestCommonPrefix.getLongestCommonPrefix(new String[]{"apple", "apply", "append"});
    assertThat(prefix).isEqualTo("app");
  }

  @Test
  public void testOneWordPrefix() {
    LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
    String prefix = longestCommonPrefix.getLongestCommonPrefix(new String[]{"apple"});
    assertThat(prefix).isEqualTo("apple");
  }

  @Test
  public void testNoCommonPrefix() {
    LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
    String prefix = longestCommonPrefix.getLongestCommonPrefix(new String[]{"apple", "banana", "orange"});
    assertThat(prefix).isEqualTo("-1");
  }

  @Test
  public void testAllAlphabetsInOneWordCommonPrefix() {
    LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
    String prefix = longestCommonPrefix.getLongestCommonPrefix(new String[]{"apple", "applet", "appley"});
    assertThat(prefix).isEqualTo("apple");
  }

  @Test
  public void testAllAlphabetsCommonPrefix() {
    LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
    String prefix = longestCommonPrefix.getLongestCommonPrefix(new String[]{"apple", "apple", "apple"});
    assertThat(prefix).isEqualTo("apple");
  }
}
