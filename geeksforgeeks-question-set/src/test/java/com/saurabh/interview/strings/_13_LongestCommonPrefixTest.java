package com.saurabh.interview.strings;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _13_LongestCommonPrefixTest {
  @Test
  public void testThreeAlphabetPrefix() {
    _13_LongestCommonPrefix longestCommonPrefix = new _13_LongestCommonPrefix();
    String prefix = longestCommonPrefix.getLongestCommonPrefix(new String[]{"apple", "apply", "append"});
    assertThat(prefix).isEqualTo("app");
  }

  @Test
  public void testOneWordPrefix() {
    _13_LongestCommonPrefix longestCommonPrefix = new _13_LongestCommonPrefix();
    String prefix = longestCommonPrefix.getLongestCommonPrefix(new String[]{"apple"});
    assertThat(prefix).isEqualTo("apple");
  }

  @Test
  public void testNoCommonPrefix() {
    _13_LongestCommonPrefix longestCommonPrefix = new _13_LongestCommonPrefix();
    String prefix = longestCommonPrefix.getLongestCommonPrefix(new String[]{"apple", "banana", "orange"});
    assertThat(prefix).isEqualTo("-1");
  }

  @Test
  public void testAllAlphabetsInOneWordCommonPrefix() {
    _13_LongestCommonPrefix longestCommonPrefix = new _13_LongestCommonPrefix();
    String prefix = longestCommonPrefix.getLongestCommonPrefix(new String[]{"apple", "applet", "appley"});
    assertThat(prefix).isEqualTo("apple");
  }

  @Test
  public void testAllAlphabetsCommonPrefix() {
    _13_LongestCommonPrefix longestCommonPrefix = new _13_LongestCommonPrefix();
    String prefix = longestCommonPrefix.getLongestCommonPrefix(new String[]{"apple", "apple", "apple"});
    assertThat(prefix).isEqualTo("apple");
  }
}
