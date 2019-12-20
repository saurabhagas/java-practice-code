package com.saurabh.interview;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _2_PalindromeNumberTest {
  @Test
  public void testPalindrome_1() {
    _2_PalindromeNumber number = new _2_PalindromeNumber(12321);
    assertTrue(number.isPalindrome());
  }

  @Test
  public void testPalindrome_2() {
    _2_PalindromeNumber number = new _2_PalindromeNumber(1);
    assertTrue(number.isPalindrome());
  }

  @Test
  public void testPalindrome_3() {
    _2_PalindromeNumber number = new _2_PalindromeNumber(0);
    assertTrue(number.isPalindrome());
  }

  @Test
  public void testPalindrome_4() {
    _2_PalindromeNumber number = new _2_PalindromeNumber(11111111);
    assertTrue(number.isPalindrome());
  }

  @Test
  public void testNoPalindrome_1() {
    _2_PalindromeNumber number = new _2_PalindromeNumber(123);
    assertFalse(number.isPalindrome());
  }

  @Test
  public void testNoPalindrome_2() {
    _2_PalindromeNumber number = new _2_PalindromeNumber(-1);
    assertFalse(number.isPalindrome());
  }

  @Test
  public void testNoPalindrome_3() {
    _2_PalindromeNumber number = new _2_PalindromeNumber(1000000000);
    assertFalse(number.isPalindrome());
  }
}