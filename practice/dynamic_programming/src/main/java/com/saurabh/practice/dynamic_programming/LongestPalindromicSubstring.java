package com.saurabh.practice.dynamic_programming;

// Problem at: https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring {
  public static void main(String[] args) {
    System.out.println("Longest palindromic substring for input 'cbbd': " + lps("cbbd"));
    System.out.println("Longest palindromic substring for input 'babad': " + lps("babad"));
    System.out.println("Longest palindromic substring for input 'babad': " + lps("babad"));
    System.out.println("Longest palindromic substring for input 'abcde': " + lps("abcde"));
  }

  public static String lps(String string) {
    int[][] memo = new int[string.length()][string.length()];
    for (int i = 0; i < string.length(); i++) {
      memo[i][i] = 1; // fill the diagonal
    }
    for (int i = string.length() - 1; i >= 0; i--) {
      for (int j = i + 1; j < string.length(); j++) {
        if (string.charAt(i) == string.charAt(j)) {
          if (j == i + 1) {
            memo[i][j] = 2;
          } else {
            memo[i][j] = memo[i + 1][j - 1] == 0 ? 0 : memo[i + 1][j - 1] + 2;
          }
        }
      }
    }

    int max = Integer.MIN_VALUE;
    int first = -1, last = -1;
    for (int i = 0; i < string.length(); i++) {
      for (int j = i; j < string.length(); j++) {
        if (max < memo[i][j]) {
          max = memo[i][j];
          first = i;
          last = j;
        }
      }
    }
    return string.substring(first, last + 1);
  }
}
