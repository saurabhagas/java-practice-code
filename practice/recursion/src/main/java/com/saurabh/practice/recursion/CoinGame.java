package com.saurabh.practice.recursion;

import static java.lang.Math.max;
import static java.lang.Math.min;

/*
 Problem: Max number of coins that can be won in a coin game played between two equally competent players.
 Problem with solution at: https://www.youtube.com/watch?v=JMxl5rk7kGo
 Approach: Calculate optimal strategy at each decision point
 Runtime: O(n^2) time, O(1) space
*/
public class CoinGame {
  public static void main(String[] args) {
    System.out.println(coinMax(new int[]{1, 5, 700, 2}, 0, 3));
  }

  public static int coinMax(int[] array, int left, int right) {
    if (left + 1 == right) return max(array[left], array[right]);
    int leftAnswer = array[left] + min(coinMax(array, left + 2, right), coinMax(array, left + 1, right - 1));
    int rightAnswer = array[right] + min(coinMax(array, left + 1, right - 1), coinMax(array, left, right - 2));
    return max(leftAnswer, rightAnswer);
  }
}
