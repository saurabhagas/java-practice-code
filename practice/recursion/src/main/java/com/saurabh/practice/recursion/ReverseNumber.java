package com.saurabh.practice.recursion;

/**
 * https://www.geeksforgeeks.org/write-a-program-to-reverse-digits-of-a-number/
 */
public class ReverseNumber {
  private static int rev_num = 0;
  private static int base_pos = 1;

  public static void main(String[] args) {
    int number = 12345;
    System.out.println("Input: " + number + ", Output: " + reverse(number));
    number = 1;
    System.out.println("Input: " + number + ", Output: " + reverse(number));
    number = -12345;
    System.out.println("Input: " + number + ", Output: " + reverse(number));
  }

  /**
   * Facade function acting as router to internal reverse functions, constructing parameters as needed.
   *
   * @param number the input number
   * @return reverse of the input number
   */
  private static int reverse(int number) {
    int reverse = reverseInternal_impure(number);
    rev_num = 0;
    base_pos = 1;
    return reverse;
//    return reverseInternal_pure(number, getNumDigits(number));
  }

  private static int getNumDigits(int number) {
    int numDigits = 0;
    while (number != 0) {
      number /= 10;
      numDigits++;
    }
    return numDigits;
  }

  private static int reverseInternal_impure(int num) {
    if (num == 0) return 0;

    reverseInternal_impure(num / 10);
    rev_num += (num % 10) * base_pos;
    base_pos *= 10;
    return rev_num;
  }

  private static int reverseInternal_pure(int number, int numDigits) {
    if (number == 0) return 0;

    // Using standard recursive thinking - do the job assuming that the job for N-1 terms has been done already
    return pow(numDigits - 1) * (number % 10) + reverseInternal_pure(number / 10, numDigits - 1);
  }

  private static int pow(int numDigits) {
    return (int) Math.pow(10, numDigits);
  }
}
