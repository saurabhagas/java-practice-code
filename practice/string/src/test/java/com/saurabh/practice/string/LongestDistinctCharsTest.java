package com.saurabh.practice.string;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestDistinctCharsTest {
  @Test
  public void testDistinctChars() {
    LongestDistinctChars distinctChars = new LongestDistinctChars();
    int length = distinctChars.getLongestDistinctCharsLength("abababcdefababcdab");
    assertThat(length).isEqualTo(6);
  }

  @Test
  public void testAllDistinctChars() {
    LongestDistinctChars distinctChars = new LongestDistinctChars();
    int length = distinctChars.getLongestDistinctCharsLength("abcdefghi");
    assertThat(length).isEqualTo(9);
  }

  @Test
  public void testNoDistinctChars() {
    LongestDistinctChars distinctChars = new LongestDistinctChars();
    int length = distinctChars.getLongestDistinctCharsLength("aaaaaaaa");
    assertThat(length).isEqualTo(1);
  }

  @Test
  public void testEmptyDistinctChars() {
    LongestDistinctChars distinctChars = new LongestDistinctChars();
    int length = distinctChars.getLongestDistinctCharsLength("");
    assertThat(length).isEqualTo(0);
  }

  @Test
  public void testSameDistinctChars() {
    LongestDistinctChars distinctChars = new LongestDistinctChars();
    int length = distinctChars.getLongestDistinctCharsLength("abcdeedcba");
    assertThat(length).isEqualTo(5);
  }
}
