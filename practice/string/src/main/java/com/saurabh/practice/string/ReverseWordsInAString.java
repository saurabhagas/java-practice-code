package com.saurabh.practice.string;

public class ReverseWordsInAString {
  public static void main(String[] args) {
    ReverseWordsInAString obj = new ReverseWordsInAString();
    char[] chars = "the sky is blue".toCharArray();
    obj.reverseWordsInPlace(chars);
    System.out.println(chars);
  }

  /**
   * Problem - https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/166/
   * The output should contain words separated by single space, and no leading or trailing whitespaces.
   */
  public String reverseWords(String s) {
    String[] tokens = s.split(" ");
    StringBuilder sb = new StringBuilder();
    for (int i = tokens.length - 1; i >= 0; i--) { // Run a reverse loop to add the words in reversed order
      String token = tokens[i];
      if (token.isEmpty()) continue;
      sb.append(token).append(" ");
    }
    return sb.deleteCharAt(sb.length() - 1).toString();
  }

  /**
   * Problem: https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/213/
   * @param s
   */
  public void reverseWordsInPlace(char[] s) {
    for (int first = 0, last = s.length - 1; first < last; first++, last--) {
      char temp = s[first];
      s[first] = s[last];
      s[last] = temp;
    }

    for (int i = 0; i < s.length; ) { // loops through all the words
      int wordBoundary = getWordBoundary(s, i);
      int first = i;
      int last = wordBoundary - 1;
      for (; first < last; first++, last--) { // reverses each word
        char temp = s[first];
        s[first] = s[last];
        s[last] = temp;
      }
      i = wordBoundary + 1;
    }
  }

  private int getWordBoundary(char[] s, int i) {
    while (i < s.length && s[i] != ' ') i++;
    return i;
  }
}
