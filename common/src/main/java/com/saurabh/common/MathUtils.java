package com.saurabh.common;

import java.util.stream.IntStream;

public class MathUtils {
  public static int max(int... numbers) {
    if (numbers == null || numbers.length == 0) {
      throw new IllegalArgumentException("At least one number must be provided");
    }
    return IntStream.of(numbers).max().getAsInt();
  }

  public static int min(int... numbers) {
    if (numbers == null || numbers.length == 0) {
      throw new IllegalArgumentException("At least one number must be provided");
    }
    return IntStream.of(numbers).min().getAsInt();
  }
}
