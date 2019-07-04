package com.saurabh.oop;

import java.net.URL;

/**
 * Example demonstrating an effective strategy to convert checked exceptions into unchecked exceptions
 */
public class EffectiveExceptionStrategy {
  public static void main(String[] args) {
    System.out.println(UrlCreator.createUrl());
  }

  @FunctionalInterface
  interface RuntimeExceptionWrappable<T> {
    T execute() throws Exception;
  }

  static class RuntimeExceptionWrapper {
    static <T> T wrap(RuntimeExceptionWrappable<T> runtimeExceptionWrappable) {
      try {
        return runtimeExceptionWrappable.execute();
      } catch (Exception exception) {
        throw new RuntimeException(exception);
      }
    }
  }

  static class UrlCreator {
    static URL createUrl() {
      return RuntimeExceptionWrapper.wrap(() -> new URL("1", "3545", "4536356"));
    }
  }
}
