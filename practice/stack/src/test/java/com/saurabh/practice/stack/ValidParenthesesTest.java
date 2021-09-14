package com.saurabh.practice.stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidParenthesesTest {
  @Test
  public void testMatching() {
    assertTrue(ValidParentheses.isValid("()"));
    assertTrue(ValidParentheses.isValid("[]"));
    assertTrue(ValidParentheses.isValid("{}"));
    assertTrue(ValidParentheses.isValid("{[]}"));
    assertTrue(ValidParentheses.isValid("()[]{}"));
  }

  @Test
  public void testNonMatching() {
    assertFalse(ValidParentheses.isValid("("));
    assertFalse(ValidParentheses.isValid("(("));
    assertFalse(ValidParentheses.isValid(")"));
    assertFalse(ValidParentheses.isValid("))"));
    assertFalse(ValidParentheses.isValid("(()[]{}"));
    assertFalse(ValidParentheses.isValid("()[]{}}"));
  }
}