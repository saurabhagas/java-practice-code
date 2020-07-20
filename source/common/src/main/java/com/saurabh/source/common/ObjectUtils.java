package com.saurabh.source.common;

import java.util.List;

public class ObjectUtils {
  public static <T> List<T> requireNonEmpty(List<T> employees) {
    if (employees == null || employees.isEmpty()) {
      throw new IllegalArgumentException();
    }
    return employees;
  }
}
