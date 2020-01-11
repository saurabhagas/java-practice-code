package com.saurabh.interview.strings;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class _9_FormAPalindromeTest {
    @Test
    public void testMinCharactersToFormPalindromeRecursive() {
        _9_FormAPalindrome formPalin = new _9_FormAPalindrome();
        int numOfChars = formPalin.getCharsToFormPalindromeRecursive("abcda");
        assertThat(numOfChars).isEqualTo(2);
    }

    @Test
    public void testMinCharsToFormPalindromeDp() {
        _9_FormAPalindrome formPalin = new _9_FormAPalindrome();
        int numOfChars = formPalin.getCharsToFormPalindromeDp("abcda");
        assertThat(numOfChars).isEqualTo(2);
    }

    @Test
    public void testMinCharsToFormPalindromeAllDifferent() {
        _9_FormAPalindrome formPalin = new _9_FormAPalindrome();
        int numOfChars = formPalin.getCharsToFormPalindromeDp("abcd");
        assertThat(numOfChars).isEqualTo(3);
    }

    @Test
    public void testMinCharsToFormPalindromeAllSame() {
        _9_FormAPalindrome formPalin = new _9_FormAPalindrome();
        int numOfChars = formPalin.getCharsToFormPalindromeDp("aaaa");
        assertThat(numOfChars).isEqualTo(0);
    }

}
