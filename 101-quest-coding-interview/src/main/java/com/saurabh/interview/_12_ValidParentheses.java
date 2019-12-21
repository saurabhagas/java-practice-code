package com.saurabh.interview;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;

/*
 Problem - Check if a string has valid sequence of parantheses or not. Parantheses can only be '{', '}', '[', ']', '(', ')'.
*/
public class _12_ValidParentheses {
  public boolean isValid(char... chars) {
    ArrayDeque<Character> stack = new ArrayDeque<>();
    for (char aChar : chars) {
      if (aChar == '(' || aChar == '{' || aChar == '[') {
        stack.push(aChar);
      }

      try {
        if (aChar == ')' && stack.pop() != '(' ||
            aChar == '}' && stack.pop() != '{' ||
            aChar == ']' && stack.pop() != '[') {
          return false;
        }
      } catch (NoSuchElementException e) {
        // thrown when pop() fails - meaning that a match wasn't found
        return false;
      }
    }

    return stack.size() == 0;
  }
}