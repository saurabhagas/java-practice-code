package com.saurabh.practice;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromeNumberTest {
  @Test
  public void testPalindrome_1() {
    PalindromeNumber number = new PalindromeNumber(12321);
    assertTrue(number.isPalindrome());
  }

  @Test
  public void testPalindrome_2() {
    PalindromeNumber number = new PalindromeNumber(1);
    assertTrue(number.isPalindrome());
  }

  @Test
  public void testPalindrome_3() {
    PalindromeNumber number = new PalindromeNumber(0);
    assertTrue(number.isPalindrome());
  }

  @Test
  public void testPalindrome_4() {
    PalindromeNumber number = new PalindromeNumber(11111111);
    assertTrue(number.isPalindrome());
  }

  @Test
  public void testNoPalindrome_1() {
    PalindromeNumber number = new PalindromeNumber(123);
    assertFalse(number.isPalindrome());
  }

  @Test
  public void testNoPalindrome_2() {
    PalindromeNumber number = new PalindromeNumber(-1);
    assertFalse(number.isPalindrome());
  }

  @Test
  public void testNoPalindrome_3() {
    PalindromeNumber number = new PalindromeNumber(1000000000);
    assertFalse(number.isPalindrome());
  }
}