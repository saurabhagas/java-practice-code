package com.saurabh.interview.arrays;

import java.util.Arrays;

/**
 * Problem - Given two arrays X and Y of positive integers, find number of pairs such that x^y > y^x (raised to power of)
 * where x is an element from X and y is an element from Y.
 * <p>
 * Approach - O(mlogn + nlogm)
 * As a rule for most numbers with y > x, x^y > y^x with some exceptions as follows:
 * 1. if x = 0, then count for this is 0.
 * 2. if x = 1, then count is total no of 0s in Y[] only.
 * 3. if x = 2, for y = 3, y = 4, the above property does not hold, and the count should be decreased
 * 4. if x = 3, for y = 2, the count need to be increased
 * Simply sort the array Y[], and for every element x in X[], find the index of smallest number just greater than x in Y[].
 * All the elements after, this index satisfy the above relation y > x.
 */
public class _7_GreaterPairPower {
  public int getGreaterPairPower(int[] X, int[] Y) {

    if (X == null || Y == null || X.length == 0 || Y.length == 0) {
      throw new IllegalArgumentException("Both Arrays should not be null and must have at least one element");
    }

    Arrays.sort(X);
    Arrays.sort(Y);
    int countGreaterPairPower = 0;
    for (int i = 0; i < X.length; i++) {
      countGreaterPairPower += getCountForY(X[i], Y);
    }
    return countGreaterPairPower;
  }

  public int getCountForY(int x, int[] Y) {
    if (x == 0) {
      return 0;
    } else if (x == 1) {
      return countNumberInArray(Y, 0);
    } else {
      int count = 0;
      int index = Arrays.binarySearch(Y, x);
      if (index < 0) {
        index = -1 * (index + 1);
      } else {
        int j = index;
        while (index < Y.length && Y[index] == x) {
          index++;
        }
      }
      count = Y.length - index;
      if (x == 2) {
        count = count - countNumberInArray(Y, 3) - countNumberInArray(Y, 4);
      }
      if (x == 3) {
        count = count + countNumberInArray(Y, 2);
      }
      count += countNumberInArray(Y, 1);
      return count;
    }
  }

  private int countNumberInArray(int[] array, int n) {
    int countN = 0;
    for (int k : array) {
      if (k == n) {
        countN++;
      }
    }
    return countN;
  }
}
