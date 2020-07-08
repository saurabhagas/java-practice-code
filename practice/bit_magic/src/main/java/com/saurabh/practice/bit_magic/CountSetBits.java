package com.saurabh.practice.bit_magic;

// Problem at: https://www.geeksforgeeks.org/count-set-bits-in-an-integer/
public class CountSetBits {
  public static void main(String[] args) {
    System.out.println(countUsingAmpersand(64));
    System.out.println(countUsingAmpersand(63));
    System.out.println(countUsingAmpersand(-63));

    System.out.println(countUsingPrecomputedArray(64));
    System.out.println(countUsingPrecomputedArray(63));
    System.out.println(countUsingPrecomputedArray(-63));
  }

  // Performs (num & num - 1) which resets the rightmost bit. The number of times this happens before the number becomes
  // 0 is the answer. Runtime O(logn) since there are logn bits in an integer.
  public static int countUsingAmpersand(int num) {
    int count = 0;

    while (num != 0) {
      num = num & num - 1;
      count++;
    }
    return count;
  }

  // Pre-computes the number of set bits in a nibble (4 bits). Uses a mask of size 4 bits, and uses this lookup table.
  // Runs in O(1) time and O(1) space as the runtime and storage depend on the nibble size only, not the input.
  public static int countUsingPrecomputedArray(int num) {
    if (num == 0) return 0;
    //0000 contains 0 bits, 0001 contains 1, 0010 contains 1 and so on..
    int[] array = new int[] {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};
    // Mask of 1111 to only lookup the current nibble
    int masked = num & 0xf;
    // Use the unsigned >>> operator to make the function work for negative numbers as well (>> would fill 1's, >>> fills 0's)
    return array[masked] + countUsingPrecomputedArray(num >>> 4);
  }
}
