package com.saurabh.practice.string;

/**
 * Problem - Given a String of length S, reverse the whole string without reversing the individual words in it. Words are separated by dots.
 * Approach - O(n) time where n is numbers of words in the string.
 * Split the string into substrings with separator as "." and run a reverse loop on the array of split strings
 */
public class ReverseWordsInAString {
  public String reverseWords(String originalString) {
    String[] strings = originalString.split("\\.");
    StringBuffer reversedString = new StringBuffer();
    for (int i = strings.length - 1; i >= 0; i--) {
      if (!strings[i].isEmpty()) {
        reversedString.append(strings[i] + ".");
      }
    }
    reversedString.deleteCharAt(reversedString.length() - 1);
    if (originalString.startsWith(".")) {
      reversedString.insert(0, ".");
    }
    if (originalString.endsWith(".")) {
      reversedString.append(".");
    }
    return reversedString.toString();
  }
}
