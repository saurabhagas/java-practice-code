package com.saurabh.practice.bit_magic;

/**
 * Taken from: https://www.geeksforgeeks.org/russian-peasant-multiply-two-numbers-using-bitwise-operators/
 */
public class MultiplyUsingBitwise {
  public static void main(String[] args) {
    int one = 10;
    int two = 150;
    System.out.println(one + " * " + two + " = " + multiply(one, two));
    System.out.println(one + " * " + one + " = " + multiply(one, one));
    System.out.println(one + " * 0 = " + multiply(one, 0));
    System.out.println("0 * " + two + " = " + multiply(0, two));
    System.out.println(one + " * -" + two + " = " + multiply(one, -two));
    System.out.println("-" + one + " * " + two + " = " + multiply(-one, two));
    System.out.println("-" + one + " * -" + two + " = " + multiply(-one, -two));
  }

  /**
   * The value of a*b is same as (a*2)*(b/2) if b is even, otherwise the value is same as ((a*2)*(b/2) + a)
   */
  public static long multiply(int one, int two) {
    int result = 0;
    boolean shouldBeNegative = false;
    if (one < 0 && two > 0) {
      one = -one;
      shouldBeNegative = true;
    } else if (one > 0 && two < 0) {
      two = -two;
      shouldBeNegative = true;
    } else if (one < 0 && two < 0) {
      one = -one;
      two = -two;
    }

    while (two != 0) {
      one = one << 1;
      two = two >> 1;
      if ((two & 1) == 1) {
        result += one;
      }
    }
    return shouldBeNegative ? -result : result;
  }
}
