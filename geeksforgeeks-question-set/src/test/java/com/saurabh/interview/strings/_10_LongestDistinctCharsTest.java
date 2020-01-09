package com.saurabh.interview.strings;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _10_LongestDistinctCharsTest {
  @Test
  public void testDistinctChars() {
    _10_LongestDistinctChars distinctChars = new _10_LongestDistinctChars();
    int length = distinctChars.getLongestDistinctCharsLength("abababcdefababcdab");
    assertThat(length).isEqualTo(6);
  }

  @Test
  public void testAllDistinctChars() {
    _10_LongestDistinctChars distinctChars = new _10_LongestDistinctChars();
    int length = distinctChars.getLongestDistinctCharsLength("abcdefghi");
    assertThat(length).isEqualTo(9);
  }

  @Test
  public void testNoDistinctChars() {
    _10_LongestDistinctChars distinctChars = new _10_LongestDistinctChars();
    int length = distinctChars.getLongestDistinctCharsLength("aaaaaaaa");
    assertThat(length).isEqualTo(1);
  }

  @Test
  public void testEmptyDistinctChars() {
    _10_LongestDistinctChars distinctChars = new _10_LongestDistinctChars();
    int length = distinctChars.getLongestDistinctCharsLength("");
    assertThat(length).isEqualTo(0);
  }

  @Test
  public void testSameDistinctChars() {
    _10_LongestDistinctChars distinctChars = new _10_LongestDistinctChars();
    int length = distinctChars.getLongestDistinctCharsLength("abcdeedcba");
    assertThat(length).isEqualTo(5);
  }
}
