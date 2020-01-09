package com.saurabh.interview.strings;

/**
 * Problem - Given a string S, find length of the longest substring with all distinct characters.  For example, for input "abca", the output is 3 as "abc" is the longest substring with all distinct characters.
 * <p>
 * Approach - O(n) time complexity and O(1) space complexity
 * Check that current character is present in the substring of the previous longest distinct char sequence.
 * If the current character is repeated then, change the longest distinct substring starting just after the lastIndex of the repeating character to the current index.
 * Update the length of longest distinct chars every time.
 */
public class _10_LongestDistinctChars {
  public int getLongestDistinctCharsLength(String input) {
    int longestLength = 0;
    int startIndex = 0;
    int currLength = 0;
    for (int i = 0; i < input.length(); i++) {
      String sub = input.substring(startIndex, i);
      if (sub.lastIndexOf(input.charAt(i)) != -1) {
        currLength = i - sub.lastIndexOf(input.charAt(i)) - startIndex;
        startIndex = sub.lastIndexOf(input.charAt(i)) + 1 + startIndex;
      } else {
        currLength++;
      }
      if (currLength > longestLength) {
        longestLength = currLength;
      }
    }
    return longestLength;
  }
}
