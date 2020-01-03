package com.saurabh.interview.arrays;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _3_LongestPalindromeInAStringTest {
    @Test
    public void testLongestPalindromeInAStringOfOddLength() {
        _3_LongestPalindromeInAString longestPalindrome = new _3_LongestPalindromeInAString();
        String palindrome = longestPalindrome.getLongestPalindrome("abcdefedghi");
        assertThat(palindrome).isEqualTo("defed");
    }

    @Test
    public void testLongestPalindromeInAStringOfEvenLength() {
        _3_LongestPalindromeInAString longestPalindrome = new _3_LongestPalindromeInAString();
        String palindrome = longestPalindrome.getLongestPalindrome("abcdefedchi");
        assertThat(palindrome).isEqualTo("cdefedc");
    }

    @Test
    public void testLongestPalindromeInAStringEmptyInput() {
        _3_LongestPalindromeInAString longestPalindrome = new _3_LongestPalindromeInAString();
        String palindrome = longestPalindrome.getLongestPalindrome("");
        assertThat(palindrome).isEqualTo("");
    }

    @Test
    public void testLongestPalindromeInAStringOfManySameLengthPalindromes() {
        _3_LongestPalindromeInAString longestPalindrome = new _3_LongestPalindromeInAString();
        String palindrome = longestPalindrome.getLongestPalindrome("abefeghiabaui");
        assertThat(palindrome).isEqualTo("efe");
    }

    @Test
    public void testLongestPalindromeInAStringOfManyDifferentLengthPalindromesFirstLonger() {
        _3_LongestPalindromeInAString longestPalindrome = new _3_LongestPalindromeInAString();
        String palindrome = longestPalindrome.getLongestPalindrome("abcefecghiabaui");
        assertThat(palindrome).isEqualTo("cefec");
    }

    @Test
    public void testLongestPalindromeInAStringOfManyDifferentLengthPalindromesSecondLonger() {
        _3_LongestPalindromeInAString longestPalindrome = new _3_LongestPalindromeInAString();
        String palindrome = longestPalindrome.getLongestPalindrome("abeffeghieabbaeui");
        assertThat(palindrome).isEqualTo("eabbae");
    }
}
