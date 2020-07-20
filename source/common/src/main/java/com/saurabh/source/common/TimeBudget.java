package com.saurabh.source.common;

import java.util.concurrent.TimeUnit;

public class TimeBudget {
  private final long budgetExpiry;
  private final TimeUnit timeUnit;

  public TimeBudget(long timeout, TimeUnit timeUnit) {
    this.timeUnit = timeUnit;
    this.budgetExpiry = System.nanoTime() + TimeUnit.NANOSECONDS.convert(timeout, timeUnit);
  }

  public long remaining() {
    return remaining(timeUnit);
  }

  public long remaining(TimeUnit timeUnit) {
    long now = System.nanoTime();
    long remaining = budgetExpiry - now;
    return timeUnit.convert(remaining, TimeUnit.NANOSECONDS);
  }

  @Override
  public String toString() {
    return "TimeBudget{" +
        "budgetExpiry=" + budgetExpiry +
        ", remaining=" + remaining() +
        ", timeUnit=" + timeUnit +
        '}';
  }
}
