package com.saurabh.practice.recursion;

import java.util.Arrays;

public class AllOccurrencesInArray {
  public static void main(String[] args) {
    int[] array = {1, 2, 3, 3, 4, 5, 6, 2, 3};
    print(allOccurrences(array, 10, 0, 0)); // should be []
    print(allOccurrences(array, 0, 0, 0)); // should be []
    print(allOccurrences(array, 1, 0, 0)); // should be [0]
    print(allOccurrences(array, 5, 0, 0)); // should be [5]
    print(allOccurrences(array, 2, 0, 0)); // should be [1, 7]
    print(allOccurrences(array, 3, 0, 0)); // should be [2, 3, 8]
  }

  public static int[] allOccurrences(int[] array, int element, int index, int foundSoFar) {
    if (index == array.length) {
      return new int[foundSoFar];
    }

    int[] indexArray;
    if (array[index] == element) {
      indexArray = allOccurrences(array, element, index + 1, foundSoFar + 1);
      indexArray[foundSoFar] = index;
    } else {
      indexArray = allOccurrences(array, element, index + 1, foundSoFar);
    }
    return indexArray;
  }

  private static void print(int[] allOccurrences) {
    System.out.println(Arrays.toString(allOccurrences));
  }
}
