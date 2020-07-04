package com.saurabh.practice.string;

import java.util.Arrays;

/**
 * Problem - Given a string, the task is to remove duplicates from it. Expected time complexity O(n) where n is length of input string and extra space O(1) under the assumption that there are total 256 possible characters in a string.
 * <p>
 * Approach - O(n) time and O(1) space complexity
 * Create an array of boolean each representing the 256 characters and make the respective flag as 1 depending on the ASCII value of the character
 */
public class RemoveDuplicates {
  public String removeDuplicates(String input) {
    char[] stringArray = input.toCharArray();
    int count = 0;
    boolean[] boolArray = new boolean[256];
    for (int i = 0; i < input.length(); i++) {
      // Check if the flag corresponding to that character is set. If not add the char to the output and set the corresponding flag to true.
      if (!boolArray[(int) input.charAt(i)]) {
        stringArray[count++] = stringArray[i];
        boolArray[(int) input.charAt(i)] = true;
      }
    }
    //Return the final string
    return String.copyValueOf(Arrays.copyOfRange(stringArray, 0, count));
  }
}
