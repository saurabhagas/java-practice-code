package com.saurabh.common;

import java.util.Objects;

public class Tuple<T1, T2> {
  private final T1 t1;
  private final T2 t2;

  private Tuple(T1 t1, T2 t2) {
    this.t1 = t1;
    this.t2 = t2;
  }

  public static <T1, T2> Tuple<T1, T2> of(T1 t1, T2 t2) {
    return new Tuple<>(t1, t2);
  }

  public T1 getT1() {
    return t1;
  }

  public T2 getT2() {
    return t2;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Tuple<?, ?> tuple = (Tuple<?, ?>) o;
    // Using deepEquals because the parameters can be arrays. deepEquals() calls equals() when the Object is not an array.
    return Objects.deepEquals(t1, tuple.t1) && Objects.deepEquals(t2, tuple.t2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(t1, t2);
  }

  @Override
  public String toString() {
    return "(" + t1 + ", " + t2 + ")";
  }
}
