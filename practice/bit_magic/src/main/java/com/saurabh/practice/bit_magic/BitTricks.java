package com.saurabh.practice.bit_magic;

public class BitTricks {
  public static void main(String[] args) {
    System.out.println("------------------");
    inverseOf(10);
    inverseOf(-10);

    System.out.println("------------------");
    isEven(10);
    isEven(9);

    System.out.println("------------------");
    isPowerOf2(0);
    isPowerOf2(10);

    isPowerOf2(16);
    isPowerOf2(-16);

    isPowerOf2(15);
    isPowerOf2(-15);

    System.out.println("------------------");
    hasNthBitSet(2, 0);
    hasNthBitSet(2, 1);
    hasNthBitSet(2, 31);
    hasNthBitSet(-2, 31); // proof that negative integers have leftmost bit set

    System.out.println("------------------");
    setNthBit(2, 0); // output 3
    setNthBit(2, 32); // output 3 (<< uses modulo 32)
    setNthBit(2, 1); // output 2 (the same as input)

    System.out.println("------------------");
    unsetNthBit(2, 0); // output 2
    unsetNthBit(2, 32); // output 2 (<< uses modulo 32)
    unsetNthBit(2, 1); // output 0

    System.out.println("------------------");
    toggleNthBit(2, 0); // output 3
    toggleNthBit(2, 32); // output 3 (<< uses modulo 32)
    toggleNthBit(2, 1); // output 0

    System.out.println("------------------");
    turnOffRightmostBit(2); // output 0
    turnOffRightmostBit(3); // output 2
  }

  // Calculates arithmetic inverse of num using bitwise NOT operator
  public static void inverseOf(int num) {
    // ~ performs bitwise NOT, which is also 1's complement
    // Since numbers are represented using 2's complements, we'll add 1
    System.out.println("Arithmetic inverse of " + num + " is " + (~num + 1));
  }

  // Checks if number is even by performing AND operation with LSB
  public static void isEven(int num) {
    System.out.println(num + " is even -> " + ((num & 1) == 0));
  }

  // Checks if number is even by performing AND operation with LSB
  public static void isPowerOf2(int num) {
    System.out.println(num + " is power of 2 -> " + ((num & num - 1) == 0));
  }

  // Checks if input number has nth bit set by performing AND operation with LSB
  public static void hasNthBitSet(int num, int n) {
    System.out.println(num + " has bit at position " + n + " set -> " + ((num & (1 << n)) != 0));
  }

  public static void setNthBit(int num, int n) {
    int result = num | (1 << n);
    System.out.println("Set " + n + "th bit of number " + num + " -> " + result);
  }

  public static void unsetNthBit(int num, int n) {
    int result = num & ~(1 << n);
    System.out.println("Unset " + n + "th bit of number " + num + " -> " + result);
  }

  public static void toggleNthBit(int num, int n) {
    int result = num ^ (1 << n);
    System.out.println("Toggled " + n + "th bit of number " + num + " -> " + result);
  }

  public static void turnOffRightmostBit(int num) {
    int result = num & num - 1;
    System.out.println("Turned off rightmost bit of number " + num + " -> " + result);
  }
}
