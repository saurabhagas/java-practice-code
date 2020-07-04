package com.saurabh.practice.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class PostFixExpressionExample {
  private static final Map<Character, Operator> SUPPORTED_OPERATORS = new HashMap<>();
  private final Deque<Character> infixToPostfixStack = new ArrayDeque<>();
  private final Deque<Integer> postfixEvalStack = new ArrayDeque<>();

  static {
    SUPPORTED_OPERATORS.put('+', new Operator(1, (first, second) -> first + second));
    SUPPORTED_OPERATORS.put('-', new Operator(1, (first, second) -> first - second));
    SUPPORTED_OPERATORS.put('*', new Operator(2, (first, second) -> first * second));
    SUPPORTED_OPERATORS.put('/', new Operator(2, (first, second) -> first / second));
    SUPPORTED_OPERATORS.put('^', new Operator(2, (first, second) -> (int) Math.pow(first, second)));
  }

  public void testSimpleExpression() {
    String infixExpression = "1+2*3+4";
    int expectedResult = 11;
    String postFixedExpression = infixToPostfix(infixExpression);
    System.out.println(postFixedExpression);
    System.out.println(evaluatePostfix(postFixedExpression));
  }

  private String infixToPostfix(String input) {
    final char[] numArray = input.toCharArray();
    final StringBuilder result = new StringBuilder();
    for (char c : numArray) {
      if (Character.isDigit(c)) {
        result.append(c);
      } else if (Character.isLetter(c)) {
        throw new IllegalArgumentException("Invalid entry: " + c + " in input: " + input);
      } else {
        final Character returned = pushOnStack(c);
        if (returned != null) {
          result.append(returned);
        }
      }
    }
    result.append(getItemsFromStack());
    return result.toString();
  }

  private String getItemsFromStack() {
    return infixToPostfixStack.stream().map(Object::toString).collect(Collectors.joining());
  }

  private Character pushOnStack(char newEntry) {
    final Character lastItemOnStack = infixToPostfixStack.peek();
    Character toReturn = null;
    if (lastItemOnStack != null) {
      if (precedence(lastItemOnStack, newEntry) > 0) {
        toReturn = infixToPostfixStack.pop();
      }
    }
    infixToPostfixStack.push(newEntry);
    return toReturn;
  }

  private int precedence(char first, char second) {
    return prec(first) - prec(second);
  }

  private int prec(char operator) {
    if (!SUPPORTED_OPERATORS.keySet().contains(operator)) {
      throw new IllegalArgumentException("Invalid operator: " + operator + ". Supported operators are: " + SUPPORTED_OPERATORS);
    }

    return SUPPORTED_OPERATORS.get(operator).precedence;
  }

  private int evaluatePostfix(String input) {
    final char[] numArray = input.toCharArray();
    for (char c : numArray) {
      if (Character.isDigit(c)) {
        postfixEvalStack.push(Character.getNumericValue(c));
      } else {
        if (postfixEvalStack.size() < 2) {
          throw new AssertionError("Expected at least 2 elements in the stack at for postfix expression evaluation");
        }

        int first = postfixEvalStack.pop();
        int second = postfixEvalStack.pop();
        int result = performOperation(c, first, second);
        postfixEvalStack.push(result);
      }
    }

    if (postfixEvalStack.size() != 1) {
      throw new AssertionError("Expected only 1 element in the stack at final step of postfix evaluation");
    }
    return postfixEvalStack.pop();
  }

  private int performOperation(char operator, int first, int second) {
    if (!SUPPORTED_OPERATORS.keySet().contains(operator)) {
      throw new IllegalArgumentException("Invalid operator: " + operator + ". Acceptable operators are: " + SUPPORTED_OPERATORS);
    }

    return SUPPORTED_OPERATORS.get(operator).function.apply(first, second);
  }

  private static class Operator {
    private final int precedence;
    private final BiFunction<Integer, Integer, Integer> function;

    Operator(int precedence, BiFunction<Integer, Integer, Integer> function) {
      this.precedence = precedence;
      this.function = function;
    }
  }
}
