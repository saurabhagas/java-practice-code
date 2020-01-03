package com.saurabh.interview.arrays;

/**
 * Problem - Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S).
 * Palindrome string: A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.
 * Incase of conflict, return the substring which occurs first ( with the least starting index ).
 *
 * Approach - O(n^2) time and O(n) space
 * Reverse original string. Extract substrings of all lengths starting from first letter and then check if it is present in the reversed string
 */
public class _3_LongestPalindromeInAString {
    public String getLongestPalindrome(String input) {

        StringBuffer sb = new StringBuffer(input);
        String reverseInput = sb.reverse().toString();
        String longestSubStr = "";
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                String substring = input.substring(i, j);
                if (reverseInput.contains(substring) && substring.length() > longestSubStr.length()) {
                    longestSubStr = substring;
                }
            }
        }
        return longestSubStr;
    }
}
