package com.saurabh.practice.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Problem - Given a string S. The task is to print all permutations of a given string.
public class PermutationsOfString {
  public List<String> getAllPermutationsOfString(String str) {
//    List<String> permutations = new ArrayList<>();
//    permuteUsingRecursion(str, "", permutations);
//    permuteUsingBacktracking(str.toCharArray(), 0, str.length() - 1, permutations);
    List<String> permutations = permuteUsingDivisionOfLabor(str);
    return permutations.stream().sorted().collect(Collectors.toList());
  }

  /**
   * Approach: Add to the string character at each position one by one in recursive manner
   * Runtime: O(n^2) time (each character is put at every place of the newly formed string)
   */
  private void permuteUsingRecursion(String originalModified, String current, List<String> permutations) {
    if (originalModified.isEmpty()) {
      permutations.add(current);
      return;
    }

    for (int i = 0; i < originalModified.length(); i++) {
      char currChar = originalModified.charAt(i);
      permuteUsingRecursion(originalModified.substring(0, i) + originalModified.substring(i + 1), current + currChar, permutations);
    }
  }

  // Add a character, generates a combination using that change, and reverts that change
  private void permuteUsingBacktracking(char[] originalModified, int left, int right, List<String> permutations) {
    if (left == right) {
      permutations.add(new String(originalModified));
      return;
    }

    for (int i = left; i <= right; i++) {
      swap(originalModified, i, left);
      permuteUsingBacktracking(originalModified, left + 1, right, permutations);
      swap(originalModified, i, left);
    }
  }

  // Combines the result of the result of the smaller recursions with the current result
  private List<String> permuteUsingDivisionOfLabor(String input) {
    if (input == null || input.isEmpty()) return new ArrayList<>();
    // Use the results of previous permutation, and combine them with the current char
    return combine(input.charAt(0), permuteUsingDivisionOfLabor(input.substring(1)));
  }

  private List<String> combine(char toCombine, List<String> permutations) {
    if (permutations.isEmpty()) {
      permutations.add("" + toCombine);
      return permutations;
    }

    int size = permutations.size();
    for (int i = 0; i < size; i++) { // Don't use permutations.size() as the size of the list is changing
      String permutation = permutations.remove(0); // always get the 0th element (the content of position 0 is changing)
      for (int j = 0; j <= permutation.length(); j++) {
        StringBuilder temp = new StringBuilder(permutation);
        temp.insert(j, toCombine);
        permutations.add(temp.toString());
      }
    }
    return permutations;
  }

  private void swap(char[] input, int first, int second) {
    if (first == second) return;
    char temp = input[first];
    input[first] = input[second];
    input[second] = temp;
  }
}
