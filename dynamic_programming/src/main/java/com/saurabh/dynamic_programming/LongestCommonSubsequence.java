package com.saurabh.dynamic_programming;

/**
 * Given two sequences, find the length of longest subsequence present in both of them. A subsequence is a sequence that
 * appears in the same relative order, but is not necessarily contiguous.
 *
 * Problem description and solution at: https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 */
public class LongestCommonSubsequence {
  int calculate(String first, String second) {
    //Allocating and extra row and column so because each array cell is dependent on the cells after it.
    int[][] lcs = new int[first.length() + 1][second.length() + 1];
    // No need to put zeros in the last and second last rows and columns because java does that already

    for (int i = first.length() - 1; i >= 0; i--) {
      for (int j = second.length() - 1; j >= 0; j--) {
        if (first.charAt(i) == second.charAt(j)) {
          lcs[i][j] = 1 + lcs[i + 1][j + 1];
        } else {
          lcs[i][j] = Math.max(lcs[i][j + 1], lcs[i + 1][j]);
        }
      }
    }
    return lcs[0][0];
  }
}
