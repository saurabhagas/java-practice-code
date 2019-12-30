package com.saurabh.practice;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidParenthesesTest {
  @Test
  public void testValidOneTrivial() {
    ValidParentheses obj = new ValidParentheses();
    boolean isValid = obj.isValid('[', ']');
    assertTrue(isValid);
  }

  @Test
  public void testValidTwo() {
    ValidParentheses obj = new ValidParentheses();
    boolean isValid = obj.isValid('[', ']', '(', ')');
    assertTrue(isValid);
  }

  @Test
  public void testValidThree() {
    ValidParentheses obj = new ValidParentheses();
    boolean isValid = obj.isValid('[', ']', '(', ')', '{', '}');
    assertTrue(isValid);
  }

  @Test
  public void testValidThreeIntermingled() {
    ValidParentheses obj = new ValidParentheses();
    boolean isValid = obj.isValid('[', '(', '{', '}', ')', ']');
    assertTrue(isValid);
  }

  @Test
  public void testInvalidOnlyLeft() {
    ValidParentheses obj = new ValidParentheses();
    boolean isValid = obj.isValid('[');
    assertFalse(isValid);
  }

  @Test
  public void testInvalidOnlyRight() {
    ValidParentheses obj = new ValidParentheses();
    boolean isValid = obj.isValid(']');
    assertFalse(isValid);
  }

  @Test
  public void testInvalidClosingParanMissing() {
    ValidParentheses obj = new ValidParentheses();
    boolean isValid = obj.isValid('[', '(', '{', '}', ')');
    assertFalse(isValid);
  }

  @Test
  public void testInvalidIncorrectSequenceOfClosingParantheses() {
    ValidParentheses obj = new ValidParentheses();
    boolean isValid = obj.isValid('[', '(', '{', ')', ']', '}');
    assertFalse(isValid);
  }
}