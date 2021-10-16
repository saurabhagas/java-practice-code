package com.saurabh.practice.bit_magic;

// Problem at: https://www.geeksforgeeks.org/count-set-bits-in-an-integer/
public class CountSetBits {
  public static void main(String[] args) {
    System.out.println(countUsingNShifts(64));
    System.out.println(countUsingNShifts(63));
    System.out.println(countUsingNShifts(-63));

    System.out.println("---------------------------------");
    System.out.println(countUsingAmpersand(64));
    System.out.println(countUsingAmpersand(63));
    System.out.println(countUsingAmpersand(-63));

    System.out.println("---------------------------------");
    System.out.println(countUsingLeastSignificantBitMask(64));
    System.out.println(countUsingLeastSignificantBitMask(63));
    System.out.println(countUsingLeastSignificantBitMask(-63));

    System.out.println("---------------------------------");
    System.out.println(countUsingPrecomputedArray(64));
    System.out.println(countUsingPrecomputedArray(63));
    System.out.println(countUsingPrecomputedArray(-63));
  }

  // Runtime O(logn) since there are logn bits in an integer of value n.
  public static int countUsingNShifts(int num) {
    int count = 0;
    int mask = 1;
    int numBits = 32; // int is 32 bits in size
    for (int i = 0; i < numBits; i++) {
      int result = num & mask;
      if (result != 0) {
        count++;
      }
      mask = mask << 1;
    }
    return count;
  }

  // Performs (num & num - 1) which resets the rightmost bit. The number of times this happens before the number becomes
  // 0 is the answer. Runtime O(logn) since there are logn bits in an integer of value n.
  public static int countUsingAmpersand(int num) {
    int count = 0;
    while (num != 0) {
      num = num & num - 1; // masks away all bits starting from kth bit, including kth
      count++;
    }
    return count;
  }

  // Runtime O(logn) since there are logn bits in an integer of value n.
  public static int countUsingLeastSignificantBitMask(int num) {
    int count = 0;
    while (num != 0) {
      int mask = num & -num;
      num = num ^ mask;
      count++;
    }
    return count;
  }

  // Pre-computes the number of set bits in a nibble (4 bits). Uses a mask of size 4 bits, and uses this lookup table.
  // Runs in O(logn) time and O(1) space as the runtime and storage depend on the nibble size only, not the input.
  public static int countUsingPrecomputedArray(int num) {
    if (num == 0) return 0;
    //0000 contains 0 set bits, 0001 contains 1, 0010 contains 1 and so on..
    int[] array = new int[] {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};
    // Mask of 1111 to only lookup the current nibble
    int masked = num & 0xf;
    // Use the unsigned >>> operator to make the function work for negative numbers as well (>> would fill 1's, >>> fills 0's)
    return array[masked] + countUsingPrecomputedArray(num >>> 4);
  }
}
