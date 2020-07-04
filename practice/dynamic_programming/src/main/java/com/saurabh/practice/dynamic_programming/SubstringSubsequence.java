package com.saurabh.practice.dynamic_programming;

import java.util.Arrays;

/**
 * GA HW 1
 * Given two strings X = x1, x2, ... , xn and Y = y1, y2, ... , ym give a dynamic programming
 * algorithm to find the length k of the longest string Z = z1, ... , zk where Z appears as a substring
 * of X and as a subsequence of Y . Recall, a substring is consecutive elements.
 * For example, for the following input:
 * X = a, b, d, b, a, b, f, g, d
 * Y = b, e, t, f, d, b, f, a, f, r
 * then the answer is 4 (since, b, d, b, a is a substring of X and it is also a subsequence of Y). You do
 * not need to output the actual substring, just its length.
 * (Faster (and correct) in asymptotic O(.) notation is worth more credit.)
 * (a) Define the entries of your table in words. E.g., T(i) or T(i, j) is ....
 */

public class SubstringSubsequence {
  public char[] calculate(String x, String y) {
    if (x == null || y == null) {
      throw new NullPointerException();
    }

    if (x.isEmpty() || y.isEmpty()) {
      return new char[]{};
    }

    // rows represent the string with substring
    int[][] T = new int[x.length() + 1][y.length() + 1]; // rows represent the string with substring and columns represent string with subsequence
    for (int j = 0; j <= y.length(); j++) {
      T[0][j] = 0;
    }
    for (int i = 0; i <= x.length(); i++) {
      T[i][0] = 0;
    }

    int max = 0, maxI = 0;
    for (int i = 1; i <= x.length(); i++) {       // iterate through rows
      for (int j = 1; j <= y.length(); j++) {     // iterate through columns
        char c1 = x.charAt(i - 1);
        char c2 = y.charAt(j - 1);
        if (c1 == c2) {
          T[i][j] = 1 + T[i - 1][j - 1];          // If the two letters are equal, just add one
        } else {
          T[i][j] = T[i][j - 1];                  // If the letters are unequal,
          // carry forward the number of letters of same row but previous col
        }

        if (T[i][j] > max) {
          max = T[i][j];
          maxI = i;
        }
      }
    }

    System.out.println(" " + Arrays.toString(("0" + y).toCharArray()));
    for (int i = 0; i <= x.length(); i++) { // iterate through rows
      System.out.println(((i == 0) ? "0" : x.charAt(i - 1)) + Arrays.toString(T[i]));
    }

    char[] S = new char[max];
    for (int k = 0; k < max; k++) {
      S[max - k - 1] = x.charAt(maxI - 1);
      maxI--;
    }

    return S;
  }
}
