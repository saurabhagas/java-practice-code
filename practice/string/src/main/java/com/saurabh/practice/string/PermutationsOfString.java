package com.saurabh.practice.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// Problem - Given a string S. The task is to print all permutations of a given string.
public class PermutationsOfString {
  public List<String> getAllPermutationsOfString(String str) {
    List<String> permutations = new ArrayList<>();
    permuteUsingRecursion("", str, permutations);
//    permuteUsingBacktracking(str, 0, str.length() - 1, permutations);
//    permuteUsingDivisionOfLabor(str);
    return permutations.stream().sorted().distinct().collect(Collectors.toList());
  }

  /**
   * Approach: Add to the string character at each position one by one in recursive manner
   * Runtime: O(n^2) time (each character is put at every place of the newly formed string)
   */
  private void permuteUsingRecursion(String str, String remainingWord, List<String> permutations) {
    if (remainingWord.isEmpty()) {
      // Base case when the remaining substring is empty
      permutations.add(str);
    } else {
      // Loop through each character in the remaining substring and add it one by one to the newly formed string
      for (int i = 0; i < remainingWord.length(); i++) {
        permuteUsingRecursion(str + remainingWord.charAt(i),
            remainingWord.substring(0, i) + remainingWord.substring(i + 1),
            permutations);
      }
    }
  }

  // Add a character, generates a combination using that change, and reverts that change
  private void permuteUsingBacktracking(String str, int left, int right, List<String> permutations) {
    if (left == right) {
      permutations.add(str);
      return;
    }

    for (int current = left; current <= right; current++) {
      swap(str, current, left);
      permuteUsingBacktracking(str, left + 1, right, permutations);
      swap(str, current, left);// Restore the original string - i.e. backtrack
    }
  }

  // Combines the result of the result of the smaller recursions with the current result
  private List<String> permuteUsingDivisionOfLabor(String input) {
    if (input == null || input.isEmpty()) return null;
    // Use the results of previous permutation, and combine them with the current char
    return combine(input.charAt(0), permuteUsingDivisionOfLabor(input.substring(1)));
  }

  private List<String> combine(char ch, List<String> strings) {
    if (strings == null) return Collections.singletonList("" + ch);

    ArrayList<String> combinations = new ArrayList<>();
    for (String string : strings) {
      for (int j = 0; j < string.length(); j++) {
        StringBuilder builder = new StringBuilder(string);
        final char temp = builder.charAt(j);
        builder.setCharAt(j, ch);
        builder.append(temp);
        combinations.add(builder.toString());
      }
      combinations.add(string + ch);
    }
    return combinations;
  }

  private void swap(String str, int first, int second) {
    char[] input = str.toCharArray();
    char temp = input[first];
    input[first] = input[second];
    input[second] = temp;
  }
}
