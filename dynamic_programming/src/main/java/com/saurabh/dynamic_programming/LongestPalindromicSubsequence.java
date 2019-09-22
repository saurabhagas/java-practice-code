package com.saurabh.dynamic_programming;

/**
 * LongestPalindromicSubsequence
 */
public class LongestPalindromicSubsequence {
  private int length;
  private final String string;
  private int[][] matrix;

  public LongestPalindromicSubsequence(String string) {
    this.length = string.length();
    this.string = string;
    this.matrix = new int[this.length][this.length];
  }

  // Let LPS[i, j] denote the length of longest palindromic subsequence between indices i and j
  public int find() {
    for (int i = 0; i < length; i++) {
      // Initialize the diagonal entries to 1 as LPS[i, i]
      matrix[i][i] = 1;
    }

    for (int i = 0; i < length - 1; i++) {
      // Initialize the next diagonal entries to 2 or 1
      if (string.charAt(i) == string.charAt(i + 1)) {
        matrix[i][i + 1] = 2;
      } else {
        matrix[i][i + 1] = 1;
      }
    }

    for (int width = 2; width < length; width++) {
      for (int i = 0; i < length - width; i++) {
        int j = i + width;

        if (string.charAt(i) == string.charAt(j)) {
          matrix[i][j] = 2 + matrix[i + 1][j - 1];
        } else {
          matrix[i][j] = Math.max(matrix[i + 1][j], matrix[i][j - 1]);
        }
      }
    }
    return matrix[0][length - 1];
  }
}
