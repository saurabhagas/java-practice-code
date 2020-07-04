package com.saurabh.practice.string;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class FormAPalindromeTest {
    @Test
    public void testMinCharactersToFormPalindromeRecursive() {
        FormAPalindrome formPalin = new FormAPalindrome();
        int numOfChars = formPalin.getCharsToFormPalindromeRecursive("abcda");
        assertThat(numOfChars).isEqualTo(2);
    }

    @Test
    public void testMinCharsToFormPalindromeDp() {
        FormAPalindrome formPalin = new FormAPalindrome();
        int numOfChars = formPalin.getCharsToFormPalindromeDp("abcda");
        assertThat(numOfChars).isEqualTo(2);
    }

    @Test
    public void testMinCharsToFormPalindromeAllDifferent() {
        FormAPalindrome formPalin = new FormAPalindrome();
        int numOfChars = formPalin.getCharsToFormPalindromeDp("abcd");
        assertThat(numOfChars).isEqualTo(3);
    }

    @Test
    public void testMinCharsToFormPalindromeAllSame() {
        FormAPalindrome formPalin = new FormAPalindrome();
        int numOfChars = formPalin.getCharsToFormPalindromeDp("aaaa");
        assertThat(numOfChars).isEqualTo(0);
    }

}
