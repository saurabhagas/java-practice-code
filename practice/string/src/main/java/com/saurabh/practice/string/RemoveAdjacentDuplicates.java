package com.saurabh.practice.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem - Given a string s, recursively remove adjacent duplicate characters from the string s. The output string should not have any adjacent duplicates.
 * <p>
 * Approach - O(n) time where n is numbers of characters in the string.
 * Create a set of indexes to be removed which contain same adjacent characters and add to the new string
 * only those character indexes which are not there in the set.
 * Call this function recursively and stop when the input string and output string become the same when there is no more scope for removal of chars
 */
public class RemoveAdjacentDuplicates {
  public String removeAdjacentDuplicates(String input) {
    if (input.length() <= 0) {
      return "";
    }
    StringBuffer sb = new StringBuffer();
    char lastChar = input.charAt(0);
    Set<Integer> indexesToBeRemoved = new HashSet<>();
    for (int i = 1; i < input.length(); i++) {
      if (input.charAt(i) == lastChar) {
        indexesToBeRemoved.add(i - 1);
        indexesToBeRemoved.add(i);
      }
      lastChar = input.charAt(i);
    }

    // Add only those indexes in string in the output which should not be removed
    for (int i = 0; i < input.length(); i++) {
      if (!indexesToBeRemoved.contains(i)) {
        sb.append(input.charAt(i));
      }
    }

    // Stop recursion when the input and output become the same and there is no more same adjacent chars
    if (sb.toString().equals(input)) {
      return sb.toString();
    } else {
      return removeAdjacentDuplicates(sb.toString());
    }
  }
}
