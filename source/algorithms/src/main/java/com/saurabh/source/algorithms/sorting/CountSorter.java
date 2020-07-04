package com.saurabh.source.algorithms.sorting;

import java.util.Arrays;

class CountSorter {
  //Use the entire 2-byte char space to sort all possible Java characters
  private static final int ALPHABET_SIZE = 256;

  public char[] sort(char[] arr) {
    // Create a count array to store count of individual characters and initialize count array as 0
    int[] count = new int[ALPHABET_SIZE];
    Arrays.fill(count, 0);

    // store count of each character
    for (char c : arr) ++count[c];

    // Change count[i] to contain cumulative sums to make the algorithm a stable sort
    // The index in this array would help us index in the sorted array
    for (int i = 1; i < ALPHABET_SIZE; ++i) count[i] += count[i - 1];

    // To make it stable, operate in reverse order.
    char[] output = new char[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) {
      output[count[arr[i]] - 1] = arr[i];
      --count[arr[i]];
    }

    return output;
  }
}