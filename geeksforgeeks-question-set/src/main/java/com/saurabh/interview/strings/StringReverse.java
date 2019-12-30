package com.saurabh.interview.strings;

/*
 Problem - Reverse a string.
*/
public class StringReverse {
  public String reverse(String string) {
    if (string == null) {
      throw new NullPointerException("String can't be null");
    }

    char[] chars = string.toCharArray();
    for (int i = 0, j = chars.length - 1; j > i; i++, j--) {
      char temp = chars[j];
      chars[j] = chars[i];
      chars[i] = temp;
    }
    return new String(chars);
  }
}