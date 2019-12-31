package com.saurabh.interview.strings;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _1_ReverseWordsInAStringTest {
  @Test
  public void testSimpleReverseString() {
    _1_ReverseWordsInAString reverseWords = new _1_ReverseWordsInAString();
    String originalString = "Hello.What.a.wonderful.day";
    String reversedString = reverseWords.reverseWords(originalString);
    assertEquals(reversedString, "day.wonderful.a.What.Hello");
  }

  @Test
  public void testOneAlphabetString() {
    _1_ReverseWordsInAString reverseWords = new _1_ReverseWordsInAString();
    String originalString = "a.b.c.d.e.f.g.h";
    String reversedString = reverseWords.reverseWords(originalString);
    assertEquals(reversedString, "h.g.f.e.d.c.b.a");
  }
  @Test
  public void testOneWordString() {
    _1_ReverseWordsInAString reverseWords = new _1_ReverseWordsInAString();
    String originalString = "Hello";
    String reversedString = reverseWords.reverseWords(originalString);
    assertEquals(reversedString, "Hello");
  }
  @Test
  public void testOneWordEndingWithPeriod() {
    _1_ReverseWordsInAString reverseWords = new _1_ReverseWordsInAString();
    String originalString = "Hello.";
    String reversedString = reverseWords.reverseWords(originalString);
    assertEquals(reversedString, "Hello.");
  }

  @Test
  public void testOneWordStartingWithPeriod() {
    _1_ReverseWordsInAString reverseWords = new _1_ReverseWordsInAString();
    String originalString = ".Hello";
    String reversedString = reverseWords.reverseWords(originalString);
    assertEquals(reversedString, ".Hello");
  }
}
