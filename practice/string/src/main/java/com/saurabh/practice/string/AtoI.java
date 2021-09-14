package com.saurabh.practice.string;

public class AtoI {
  public static void main(String[] args) {
    System.out.println(Long.MAX_VALUE);
     long prod = (long) Integer.MAX_VALUE * Integer.MAX_VALUE;
//    long prod = (long) Integer.MAX_VALUE * Integer.MAX_VALUE; // correct answer
    System.out.println(prod);
    int num = 912834723;
    num = num * 2; // is within range
    num = num * 3; // overflows and becomes negative
    num = num * 4; // remains negative
    num = num * 5; // becomes positive again
    // therefore, checking the sign after arbitrary multiplication won't help detect overflow
    System.out.println("--------------------");
    System.out.println(myAtoi("-91283472332"));
  }

  public static int myAtoi(String s) {
    int i = 0;
    int number = 0;
    while (i < s.length() && s.charAt(i) == ' ') {
      i++;
    }

    boolean isPositive = true;
    if (i < s.length() && s.charAt(i) == '-') {
      isPositive = false;
      i++;
    } else if (i < s.length() && s.charAt(i) == '+') i++;

    System.out.println("isPositive: " + isPositive + ", i: " + i);
    while (i < s.length()) {
      char ch = s.charAt(i);
      if (!Character.isDigit(ch)) break;

      int product = number * 10;
      if (number != 0 && product / number != 10) {
        return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }

      int digit = ch - '0';
      if (Integer.MAX_VALUE - product < digit) {
        return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }
      number = product + digit;
      i++;
    }
    return isPositive ? number : -number;
  }
}
