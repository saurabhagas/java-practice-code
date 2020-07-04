package com.saurabh.source.data_structures;

public class BloomFilter {
  private final int m;
  private final int k;
  private final boolean[] array;

  public BloomFilter(int n, double fp_prob) {
    if (n <= 0) {
      throw new IllegalArgumentException("n should be a positive number");
    }

    if (fp_prob <= 0 || fp_prob >= 1) {
      throw new IllegalArgumentException("fp_prob should be >0.0 and <1.0");
    }
    this.m = - (int) ((n * Math.log(fp_prob)) / (ln2() * ln2()));
    this.k = (int) ((m * ln2()) / n) + 1; // k can be zero because of the cast, add 1 to it
    this.array = new boolean[m];
  }

  public void add(String string) {
    for (int i = 0; i < k; i++) {
      array[hash(string, i)] = true;
    }
  }

  public boolean contains(String string) {
    boolean found = true;
    for (int i = 0; i < k; i++) {
      found = found && array[hash(string, i)];
    }
    return found;
  }

  private int hash(String string, int i) {
    return Math.abs(((string.hashCode()) * (i + 1)) % m);
  }

  private double ln2() {
    return Math.log(2);
  }
}
