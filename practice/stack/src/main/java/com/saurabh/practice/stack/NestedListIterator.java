package com.saurabh.practice.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

interface NestedInteger {

  // @return true if this NestedInteger holds a single integer, rather than a nested list.
  boolean isInteger();

  // @return the single integer that this NestedInteger holds, if it holds a single integer
  // Return null if this NestedInteger holds a nested list
  Integer getInteger();

  // @return the nested list that this NestedInteger holds, if it holds a nested list
  // Return empty list if this NestedInteger holds a single integer
  List<NestedInteger> getList();
}

public class NestedListIterator implements Iterator<Integer> {
  private final Deque<NestedInteger> stack;

  public NestedListIterator(List<NestedInteger> nestedList) {
    this.stack = new ArrayDeque<>(nestedList);
  }

  @Override
  public Integer next() {
    return stack.pop().getInteger();
  }

  @Override
  public boolean hasNext() {
    updateStack();
    return !stack.isEmpty();
  }

  private void updateStack() {
    while (!stack.isEmpty() && !stack.peek().isInteger()) {
      List<NestedInteger> children = stack.pop().getList();
      for (int i = children.size() - 1; i >= 0; i--) {
        stack.push(children.get(i));
      }
    }
  }
}