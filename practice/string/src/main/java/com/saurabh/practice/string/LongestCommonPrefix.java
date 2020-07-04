package com.saurabh.practice.string;

public class LongestCommonPrefix {
  public String getLongestCommonPrefix(String[] words) {
    int noOfWords = words.length;
    if (noOfWords == 1) {
      return words[0];
    }
    int minLength = Integer.MAX_VALUE;
    for (String word : words) {
      minLength = Math.min(word.length(), minLength);
    }
    StringBuffer prefix = new StringBuffer();
    Character commonLetter = null;
    for (int j = 0; j < minLength; j++) {
      commonLetter = null;
      for (int i = 0; i < noOfWords - 1; i++) {
        if (words[i].charAt(j) == words[i + 1].charAt(j)) {
          commonLetter = words[i + 1].charAt(j);
        } else {
          commonLetter = null;
          break;
        }
      }
      if (commonLetter != null) {
        prefix.append(commonLetter);
      }
    }
    return prefix.toString().isEmpty() ? "-1" : prefix.toString();
  }
}
