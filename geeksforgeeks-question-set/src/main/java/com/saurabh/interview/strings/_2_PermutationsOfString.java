package com.saurabh.interview.strings;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem - Given a string S. The task is to print all permutations of a given string.
 *
 * Approach - O(n^2) time where n is numbers of characters in the string, because each character is put at every place of the newly formed string
 * Add to the string character at each position one by one in recursive manner.
 */
public class _2_PermutationsOfString {
  public List<String> getAllPermutationsOfString(String str) {
    List<String> permutations = new LinkedList<String>();
    getPermutations("", str, permutations);
    Collections.sort(permutations);
    return permutations;
  }

  private void getPermutations(String str, String remainingWord, List<String> permutations) {
    if (remainingWord.isEmpty()) {
      // Base case when the remaining substring is empty
      permutations.add(str);
    } else {
      // Loop through each character in the remaining substring and add it one by one to the newly formed string
      for (int i = 0; i < remainingWord.length(); i++) {
        getPermutations(str + remainingWord.charAt(i),
            remainingWord.substring(0, i) +
                remainingWord.substring(i + 1, remainingWord.length()), permutations);
      }
    }
  }
}
