package com.saurabh.interview;

/*
 Problem - Sort an array containing only 0s, 1s and 2s.
 Approach (O(n) time, O(1) space) -
    1. Maintain 3 counters for 0, 1 and 2 respectively
    2. Update these counters while doing a pass through the array
    3. Reconstruct the array based on the counters
*/

public class _4_sortArrayContainingOnly012s {
  public void sort(int[] nums) {
    int counter0 = 0, counter1 = 0, counter2 = 0;
    for (int num : nums) {
      if (num == 0) {
        counter0++;
      } else if (num == 1) {
        counter1++;
      } else if (num == 2) {
        counter2++;
      } else {
        throw new IllegalArgumentException("Array can contain only 0s, 1s and 2s");
      }
    }

    int i = 0;
    while (counter0 != 0) {
      nums[i] = 0;
      counter0--;
      i++;
    }
    while (counter1 != 0) {
      nums[i] = 1;
      counter1--;
      i++;
    }
    while (counter2 != 0) {
      nums[i] = 2;
      counter2--;
      i++;
    }
  }
}