package com.saurabh.practice.amazon;

public class _3LongestPalindromicSubstring {
  /* Driver program to test above functions */
  public static void main(String[] args) {
    String seq = "dababad";
    System.out.println("The length of the lps is: " + lps(new StringBuilder(seq).reverse().toString()));
  }

  private static int lps(String seq) {
    // S[i, j] = S[i + 1, j - 1] + 2 if a[i] = a[j], 0 otherwise
    char[] array = seq.toCharArray();
    int rows = seq.length();
    int columns = seq.length();
    int[][] S = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (i == j) S[i][j] = 1;
        else if (i > j) S[i][j] = 0;
      }
    }

    for (int i = rows - 2; i >= 0; i--) {
      for (int j = columns - 1; j >= columns - i - 2; j--) {
        if (i == j) continue;
        if (array[i] == array[j]) S[i][j] = S[i + 1][j - 1] + 2;
        else S[i][j] = 0;
      }
    }

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (S[i][j] > max) {
          max = S[i][j];
        }
      }
    }
    return max;
  }
}
