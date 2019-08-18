package com.saurabh.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 */
public class StringPermutations {
  public static void main(String[] args) {
    StringPermutations permutations = new StringPermutations();
    char[] input = {'A', 'B', 'C', 'D'};
    System.out.println("Permutations of string: " + Arrays.toString(input));
    System.out.println(permutations.permuteUsingBasics(new String(input)));
//    permutations.permuteUsingBacktracking(input, 0, input.length - 1);
  }

  private void permuteUsingBacktracking(char[] input, int left, int right) {
    if (left == right) {
      System.out.println(input);
      return;
    }

    for (int current = left; current <= right; current++) {
      swap(input, current, left);
      permuteUsingBacktracking(input, left + 1, right);
      swap(input, current, left);// Restore the original string - i.e. backtrack
    }
  }

  private List<String> permuteUsingBasics(String input) {
    if (input == null || input.isEmpty()) return null;
    // Use the results of previous permutation, and combine them with the current char
    return combine(input.charAt(0), permuteUsingBasics(input.substring(1)));
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

  private void swap(char[] input, int first, int second) {
    char temp = input[first];
    input[first] = input[second];
    input[second] = temp;
  }
}
