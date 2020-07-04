package com.saurabh.practice.string;

/**
 * Problem -
 *
 * Approach - O(n^2) time complexity
 *
 * Approach 1 - Using dynamic programming, first find the longest common sub-sequence of the original string and reverse string.
 * The minimum number of chars to be inserted to form a Palindrome is the length of the string minus the longest common sub sequence found
 *
 * Approach 2 - Using recursion. If two chars of string are same, moving to next two to find palindrome. If not, then add 1 and find palindrome in remaining string recursively.
 */
public class FormAPalindrome {
    public int getCharsToFormPalindromeDp(String input) {

        int[][] lcsArray = new int[input.length() + 1][input.length() + 1];
        for (int i = 0; i <= input.length(); i++) {
            lcsArray[0][i] = 0;
            lcsArray[i][0] = 0;
        }
        String reverseInput = new StringBuffer(input).reverse().toString();
        for (int i = 1; i <= input.length(); i++) {
            for (int j = 1; j <= reverseInput.length(); j++) {
                if (input.charAt(i - 1) == reverseInput.charAt(j - 1)) {
                    lcsArray[i][j] = lcsArray[i - 1][j - 1] + 1;
                } else {
                    lcsArray[i][j] = Math.max(lcsArray[i][j - 1], lcsArray[i - 1][j]);
                }
            }
        }

        return input.length() - lcsArray[input.length()][input.length()];
    }

    public int getCharsToFormPalindromeRecursive(String input) {
        return findMinChars(input.toCharArray(), 0, input.length() - 1);
    }

    public int findMinChars(char[] input, int l, int h) {
        if (l > h)
            return Integer.MAX_VALUE;
        if (l == h)
            return 0;
        if (l == h - 1)
            return input[l] == input[h] ? 0 : 1;
        return input[l] == input[h] ? findMinChars(input, l + 1, h - 1) :
                Math.min(findMinChars(input, l + 1, h), findMinChars(input, l, h - 1)) + 1;
    }
}
