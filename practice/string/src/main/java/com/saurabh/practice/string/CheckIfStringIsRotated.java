package com.saurabh.practice.string;

/**
 * Problem - Given two strings a and b. The task is to find if a string 'a' can be obtained by rotating another string 'b' by 2 places.
 *
 * Approach - O(n) time where n is numbers of characters in the string.
 * Find substrings till the number of places of rotation nd form two strings and check if they do not further contain any adjacent duplicates recursively
 */
public class CheckIfStringIsRotated {

  public boolean checkIfStringIsRotated(String input, String rotated, int places) {
    if (input.isEmpty() && rotated.isEmpty()) {
      return true;
    }
    if ((input.isEmpty() && !rotated.isEmpty()) || (!input.isEmpty() && rotated.isEmpty())) {
      return false;
    }
    if (input.length() != rotated.length()) {
      return false;
    }
    StringBuffer sbAntiClockwise = new StringBuffer();
    StringBuffer sbClockwise = new StringBuffer();
    int inputLength = input.length();
    sbAntiClockwise.append(input.substring(places) + input.substring(0, places));
    sbClockwise.append(input.substring(inputLength - places) + input.substring(0, inputLength - places));

    return sbAntiClockwise.toString().equals(rotated) || sbClockwise.toString().equals(rotated);
  }

  public boolean checkIfStringIsRotatedForLoop(String input, String rotated, int places) {
    if (input.isEmpty() && rotated.isEmpty()) {
      return true;
    }
    if ((input.isEmpty() && !rotated.isEmpty()) || (!input.isEmpty() && rotated.isEmpty())) {
      return false;
    }
    if (input.length() != rotated.length()) {
      return false;
    }
    StringBuffer sbAntiClockwise = new StringBuffer();
    StringBuffer sbClockwise = new StringBuffer();
    int inputLength = input.length();
    for (int i = 0; i < inputLength; i++) {
      int index = (i + places) % inputLength;
      sbAntiClockwise.append(input.charAt(index));
      sbClockwise.append(input.charAt((inputLength + i - places) % inputLength));
      System.out.println("");
    }

    return sbAntiClockwise.toString().equals(rotated) || sbClockwise.toString().equals(rotated);
  }
}
