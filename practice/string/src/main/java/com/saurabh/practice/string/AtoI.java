package com.saurabh.practice.string;

/**
 * Problem - Your task  is to implement the function atoi. The function takes a string(str) as argument and converts it to an integer and returns it
 * <p>
 * Approach - O(1) time complexity
 * Parse the given string and return the int value else if there is an exception return -1
 */
public class AtoI {
  public int getAtoI(String str) {
    try {
      return Integer.parseInt(str);
    } catch (Exception e) {
      return -1;
    }
  }
}
