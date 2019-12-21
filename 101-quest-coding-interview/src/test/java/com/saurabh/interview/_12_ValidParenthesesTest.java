package com.saurabh.interview;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _12_ValidParenthesesTest {
  @Test
  public void testValidOneTrivial() {
    _12_ValidParentheses obj = new _12_ValidParentheses();
    boolean isValid = obj.isValid('[', ']');
    assertTrue(isValid);
  }

  @Test
  public void testValidTwo() {
    _12_ValidParentheses obj = new _12_ValidParentheses();
    boolean isValid = obj.isValid('[', ']', '(', ')');
    assertTrue(isValid);
  }

  @Test
  public void testValidThree() {
    _12_ValidParentheses obj = new _12_ValidParentheses();
    boolean isValid = obj.isValid('[', ']', '(', ')', '{', '}');
    assertTrue(isValid);
  }

  @Test
  public void testValidThreeIntermingled() {
    _12_ValidParentheses obj = new _12_ValidParentheses();
    boolean isValid = obj.isValid('[', '(', '{', '}', ')', ']');
    assertTrue(isValid);
  }

  @Test
  public void testInvalidOnlyLeft() {
    _12_ValidParentheses obj = new _12_ValidParentheses();
    boolean isValid = obj.isValid('[');
    assertFalse(isValid);
  }

  @Test
  public void testInvalidOnlyRight() {
    _12_ValidParentheses obj = new _12_ValidParentheses();
    boolean isValid = obj.isValid(']');
    assertFalse(isValid);
  }

  @Test
  public void testInvalidClosingParanMissing() {
    _12_ValidParentheses obj = new _12_ValidParentheses();
    boolean isValid = obj.isValid('[', '(', '{', '}', ')');
    assertFalse(isValid);
  }

  @Test
  public void testInvalidIncorrectSequenceOfClosingParantheses() {
    _12_ValidParentheses obj = new _12_ValidParentheses();
    boolean isValid = obj.isValid('[', '(', '{', ')', ']', '}');
    assertFalse(isValid);
  }
}