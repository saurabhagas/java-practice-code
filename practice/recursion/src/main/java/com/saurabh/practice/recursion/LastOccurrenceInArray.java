package com.saurabh.practice.recursion;

public class LastOccurrenceInArray {
  public static void main(String[] args) {
    int[] array = {1, 2, 3, 3, 4, 5, 6, 2, 3};
    System.out.println(lastOccurrence(array, 10, 0)); // should be -1
    System.out.println(lastOccurrence(array, 0, 0)); // should be -1
    System.out.println(lastOccurrence(array, 1, 0)); // should be 0
    System.out.println(lastOccurrence(array, 5, 0)); // should be 5
    System.out.println(lastOccurrence(array, 2, 0)); // should be 7
    System.out.println(lastOccurrence(array, 3, 0)); // should be 8
  }

  public static int lastOccurrence(int[] array, int element, int index) {
    if (index == array.length) return -1;
    int currIndex = -1;
    if (array[index] == element) {
      currIndex = index;
    }
    return Math.max(currIndex, lastOccurrence(array, element, index + 1));
  }
}
