package com.saurabh.practice.string;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class ReverseWordsInAStringTest {
  @Test
  public void testSimpleReverseString() {
    ReverseWordsInAString reverseWords = new ReverseWordsInAString();
    String originalString = "Hello What a wonderful day";
    String reversedString = reverseWords.reverseWords(originalString);
    assertEquals(reversedString, "day wonderful a What Hello");
  }

  @Test
  public void testOneAlphabetString() {
    ReverseWordsInAString reverseWords = new ReverseWordsInAString();
    String originalString = "a b c d e f g h";
    String reversedString = reverseWords.reverseWords(originalString);
    assertEquals(reversedString, "h g f e d c b a");
  }

  @Test
  public void testOneWordString() {
    ReverseWordsInAString reverseWords = new ReverseWordsInAString();
    String originalString = "Hello";
    String reversedString = reverseWords.reverseWords(originalString);
    assertEquals(reversedString, "Hello");
  }

  @Test
  public void testOneWordEndingWithSpace() {
    ReverseWordsInAString reverseWords = new ReverseWordsInAString();
    String originalString = "Hello ";
    String reversedString = reverseWords.reverseWords(originalString);
    assertEquals(reversedString, "Hello");
  }

  @Test
  public void testOneWordEndingWithMultipleSpaces() {
    ReverseWordsInAString reverseWords = new ReverseWordsInAString();
    String originalString = "Hello      ";
    String reversedString = reverseWords.reverseWords(originalString);
    assertEquals(reversedString, "Hello");
  }

  @Test
  public void testOneWordStartingWithSpace() {
    ReverseWordsInAString reverseWords = new ReverseWordsInAString();
    String originalString = " Hello";
    String reversedString = reverseWords.reverseWords(originalString);
    assertEquals(reversedString, "Hello");
  }

  @Test
  public void testOneWordStartingWithMultipleSpaces() {
    ReverseWordsInAString reverseWords = new ReverseWordsInAString();
    String originalString = "        Hello";
    String reversedString = reverseWords.reverseWords(originalString);
    assertEquals(reversedString, "Hello");
  }

  @Test
  public void testMultipleSpacesInBetweenWords() {
    ReverseWordsInAString reverseWords = new ReverseWordsInAString();
    String originalString = "a good   example";
    String reversedString = reverseWords.reverseWords(originalString);
    assertEquals(reversedString, "example good a");
  }
}
