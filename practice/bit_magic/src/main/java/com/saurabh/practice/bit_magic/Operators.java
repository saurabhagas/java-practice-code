package com.saurabh.practice.bit_magic;

public class Operators {
  public static void main(String[] args) {
    System.out.println("------------------");
    modulo(100, -99);
    modulo(100, 99);
    modulo(-100, 99);
    modulo(-100, -99);
  }

  public static void modulo(int numerator, int denominator) {
    // num1 % num2 has the sign of the numerator, irrespective of the sign of denominator
    System.out.println(numerator + " % " + denominator + " -> " + numerator % denominator);
  }
}
