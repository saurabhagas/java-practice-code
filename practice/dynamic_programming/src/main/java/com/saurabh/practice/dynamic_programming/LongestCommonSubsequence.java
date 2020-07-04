package com.saurabh.practice.dynamic_programming;

/**
 * Given two sequences, find the length of longest subsequence present in both of them. A subsequence is a sequence that
 * appears in the same relative order, but is not necessarily contiguous.
 * <p>
 * Problem description and solution at: https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 */
public class LongestCommonSubsequence {
  int calculate(String first, String second) {
    return calculateInternal(first, second)[0][0];
  }

  public String calculateAndPrint(String first, String second) {
    int[][] matrix = calculateInternal(first, second);
    StringBuilder subsequence = new StringBuilder(Math.min(first.length(), second.length()));
    int lastAddedIndex = -1;
    int i = 0;
    int j = 0;
    while (i < matrix.length - 2) {
      while (j < matrix[0].length - 2) {
        if (first.charAt(i) == second.charAt(j) && j != lastAddedIndex) {
          subsequence.append(first.charAt(i));
          lastAddedIndex++;//Exclude the matched index so that it doesn't get repeated
        }

        // Go to the index which the highest value
        if (matrix[i + 1][j + 1] > matrix[i + 1][j] && matrix[i + 1][j + 1] > matrix[i][j + 1]) {
          i++;
          j++;
        } else if (matrix[i][j + 1] > matrix[i + 1][j] && matrix[i][j + 1] > matrix[i + 1][j + 1]) {
          j++;
        } else if (matrix[i + 1][j] > matrix[i + 1][j + 1] && matrix[i + 1][j] > matrix[i + 1][j + 1]) {
          i++;
        } else {
          // all cells equal, the current value must have come from the diagonal
          i++;
          j++;
        }
      }
    }
    return subsequence.toString();
  }

  private int[][] calculateInternal(String first, String second) {
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
    return lcs;
  }
}
