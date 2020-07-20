package com.saurabh.source.common;

public class IntSequenceGenerator {
  private int currentValue;

  public IntSequenceGenerator(int initialValue) {
    this.currentValue = initialValue;
  }

  public int next() {
    return ++currentValue;
  }

  public int current() {
    return currentValue;
  }
}
