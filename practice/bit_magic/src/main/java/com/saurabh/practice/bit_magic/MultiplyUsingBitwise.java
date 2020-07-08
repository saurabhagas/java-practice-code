package com.saurabh.practice.bit_magic;

public class MultiplyUsingBitwise {
  public static void main(String[] args) {
    int one = 150;
    int two = 10;
    System.out.println(one + " * " + two + " = " + multiply(one, two));
    System.out.println(one + " * " + two + " = " + multiply(one, one));
    System.out.println(one + " * " + two + " = " + multiply(one, 0));
    System.out.println(one + " * " + two + " = " + multiply(one, -two));
  }

  public static long multiply(int one, int two) {
    int result = 0;
    boolean shouldBeNegative = false;
    if (one < 0 && two > 0) {
      one = -one;
      shouldBeNegative = true;
    } else if (one > 0 && two < 0) {
      two = -two;
      shouldBeNegative = true;
    }

    while (two >= 1) {
      one = one << 1;
      two = two >> 1;
      if ((two & 1) == 1) {
        result += one;
      }
    }
    return shouldBeNegative ? -result : result;
  }
}
