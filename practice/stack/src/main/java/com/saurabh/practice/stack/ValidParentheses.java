package com.saurabh.practice.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
  public static boolean isValid(String s) {
    Deque<Character> openBrackets = new ArrayDeque<>();
    for (char ch : s.toCharArray()) {
      if (ch == '(' || ch == '{' || ch == '[') {
        openBrackets.push(ch);
      } else {
        Character topElement = openBrackets.peek();
        if (topElement == null) return false;
        topElement = openBrackets.pop();
        if (ch == ')' && topElement == '(') continue;
        if (ch == ']' && topElement == '[') continue;
        if (ch == '}' && topElement == '{') continue;
        return false;
      }
    }

    return openBrackets.isEmpty(); // the stack should become empty for matching parentheses
  }
}
