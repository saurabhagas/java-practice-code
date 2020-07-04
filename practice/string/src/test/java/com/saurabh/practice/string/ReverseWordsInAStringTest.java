package com.saurabh.practice.string;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseWordsInAStringTest {
  @Test
  public void testSimpleReverseString() {
    ReverseWordsInAString reverseWords = new ReverseWordsInAString();
    String originalString = "Hello.What.a.wonderful.day";
    String reversedString = reverseWords.reverseWords(originalString);
    assertEquals(reversedString, "day.wonderful.a.What.Hello");
  }

  @Test
  public void testOneAlphabetString() {
    ReverseWordsInAString reverseWords = new ReverseWordsInAString();
    String originalString = "a.b.c.d.e.f.g.h";
    String reversedString = reverseWords.reverseWords(originalString);
    assertEquals(reversedString, "h.g.f.e.d.c.b.a");
  }

  @Test
  public void testOneWordString() {
    ReverseWordsInAString reverseWords = new ReverseWordsInAString();
    String originalString = "Hello";
    String reversedString = reverseWords.reverseWords(originalString);
    assertEquals(reversedString, "Hello");
  }

  @Test
  public void testOneWordEndingWithPeriod() {
    ReverseWordsInAString reverseWords = new ReverseWordsInAString();
    String originalString = "Hello.";
    String reversedString = reverseWords.reverseWords(originalString);
    assertEquals(reversedString, "Hello.");
  }

  @Test
  public void testOneWordStartingWithPeriod() {
    ReverseWordsInAString reverseWords = new ReverseWordsInAString();
    String originalString = ".Hello";
    String reversedString = reverseWords.reverseWords(originalString);
    assertEquals(reversedString, ".Hello");
  }
}
