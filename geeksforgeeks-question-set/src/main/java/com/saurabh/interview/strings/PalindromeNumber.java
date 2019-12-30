package com.saurabh.interview.strings;

/*
 Problem - check if a number is a palindrome. Problem at: https://leetcode.com/problems/palindrome-number/
 Approach - Reverse the number and check for equality with the original number. Negative numbers aren't palindromic.
*/

public class PalindromeNumber {
  private final int number;

  public PalindromeNumber(int number) {
    this.number = number;
  }

  public boolean isPalindrome() {
    int reversed = 0;
    int copy = number;
    while (copy > 0) {
      int mod = copy % 10;
      copy /= 10;
      reversed = 10 * reversed + mod;
    }

    return reversed == number;
  }
}