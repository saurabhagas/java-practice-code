package com.saurabh.practice.recursion;

/**
 * Logarithmic time implementation of a function which calculates the power(base, exponent).
 */
public class FastPower {
  public static void main(String[] args) {
    System.out.println(fastPower(2, 5));
    System.out.println(fastPower(2, 10));
    System.out.println(fastPower(2, 20));
    System.out.println(fastPower(2, 30));
    System.out.println(fastPower(2, 40));
    System.out.println(fastPower(2, 500));
  }

  public static long fastPower(long base, long exponent) {
    if (exponent == 0) return 1;
    if ((exponent & 1) == 1) {
      return base * fastPower(base, exponent - 1);
    }

    base = Math.multiplyExact(base, base);
    exponent >>= 1;
    return fastPower(base, exponent);
  }
}
