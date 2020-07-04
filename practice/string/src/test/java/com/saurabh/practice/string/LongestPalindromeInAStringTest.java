package com.saurabh.practice.string;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestPalindromeInAStringTest {
  @Test
  public void testLongestPalindromeInAStringOfOddLength() {
    LongestPalindromeInAString longestPalindrome = new LongestPalindromeInAString();
    String palindrome = longestPalindrome.getLongestPalindrome("abcdefedghi");
    assertThat(palindrome).isEqualTo("defed");
  }

  @Test
  public void testLongestPalindromeInAStringOfEvenLength() {
    LongestPalindromeInAString longestPalindrome = new LongestPalindromeInAString();
    String palindrome = longestPalindrome.getLongestPalindrome("abcdefedchi");
    assertThat(palindrome).isEqualTo("cdefedc");
  }

  @Test
  public void testLongestPalindromeInAStringEmptyInput() {
    LongestPalindromeInAString longestPalindrome = new LongestPalindromeInAString();
    String palindrome = longestPalindrome.getLongestPalindrome("");
    assertThat(palindrome).isEqualTo("");
  }

  @Test
  public void testLongestPalindromeInAStringOfManySameLengthPalindromes() {
    LongestPalindromeInAString longestPalindrome = new LongestPalindromeInAString();
    String palindrome = longestPalindrome.getLongestPalindrome("abefeghiabaui");
    assertThat(palindrome).isEqualTo("efe");
  }

  @Test
  public void testLongestPalindromeInAStringOfManyDifferentLengthPalindromesFirstLonger() {
    LongestPalindromeInAString longestPalindrome = new LongestPalindromeInAString();
    String palindrome = longestPalindrome.getLongestPalindrome("abcefecghiabaui");
    assertThat(palindrome).isEqualTo("cefec");
  }

  @Test
  public void testLongestPalindromeInAStringOfManyDifferentLengthPalindromesSecondLonger() {
    LongestPalindromeInAString longestPalindrome = new LongestPalindromeInAString();
    String palindrome = longestPalindrome.getLongestPalindrome("abeffeghieabbaeui");
    assertThat(palindrome).isEqualTo("eabbae");
  }
}
