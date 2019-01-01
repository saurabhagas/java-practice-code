package code.recursion;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Example showing stack reversal using recursion
 */
public class StackReverse {
  public static void main(String[] args) {
    final Deque<Integer> stack = new ArrayDeque<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);

    System.out.println("Original stack: " + stack);
    reverseStack(stack);
    System.out.println("Reversed stack: " + stack);
  }

  private static void reverseStack(Deque<Integer> stack) {
    if (stack.peek() != null) {
      Integer poppedElement = stack.pop();
      reverseStack(stack);
      insertAtBottom(poppedElement, stack);
    }
  }

  private static void insertAtBottom(Integer element, Deque<Integer> stack) {
    if (stack.isEmpty()) {
      stack.push(element);
    } else {
      Integer poppedElement = stack.pop();
      insertAtBottom(element, stack);
      stack.push(poppedElement);
    }
  }
}
