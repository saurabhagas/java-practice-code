package com.saurabh.practice.string;

/**
 * Problem - Given an string in roman no format (s)  your task is to convert it to integer .
 *
 * Approach - O(n) time where n is numbers of characters in the RomanInteger.
 * For each character in the string add its respective int value to the total. If any prev character is smaller than the current char,
 * then subtract twice the value of the prev char to make the total appropriate
 */

public class RomanToInteger {

  public int convertRomanToInteger(String roman) {
    char[] chars = roman.toCharArray();
    int intValue = 0;
    int prev = 1001;
    for (char romanDigit : chars) {
      int currentVal = 0;
      if (romanDigit == 'I') {
        currentVal = 1;
        intValue++;
      } else if (romanDigit == 'V') {
        currentVal = 5;
        intValue += 5;
      } else if (romanDigit == 'X') {
        currentVal = 10;
        intValue += 10;
      } else if (romanDigit == 'L') {
        currentVal = 50;
        intValue += 50;
      } else if (romanDigit == 'C') {
        currentVal = 100;
        intValue += 100;
      } else if (romanDigit == 'D') {
        currentVal = 500;
        intValue += 500;
      } else if (romanDigit == 'M') {
        currentVal = 1000;
        intValue += 1000;
      }
      if (prev < currentVal) {
        intValue -= (2 * prev);
      }
      prev = currentVal;
    }
    return intValue;
  }
}
