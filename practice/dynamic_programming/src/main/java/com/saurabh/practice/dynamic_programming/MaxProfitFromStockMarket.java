package com.saurabh.practice.dynamic_programming;

/**
 * Problem: https://leetcode.com/explore/interview/card/microsoft/49/dynamic-programming/186/
 */
public class MaxProfitFromStockMarket {
  public static void main(String[] args) {
    MaxProfitFromStockMarket obj = new MaxProfitFromStockMarket();
    System.out.println(obj.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    System.out.println(obj.maxProfit(new int[]{7, 6, 4, 3, 1}));
  }

  public int maxProfit(int[] prices) {
    int[] minToLeft = new int[prices.length];
    minToLeft[0] = prices[0];
    for (int i = 1; i < prices.length; i++) {
      minToLeft[i] = Math.min(prices[i], minToLeft[i - 1]);
    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < prices.length; i++) {
      int profitFromSelling = prices[i] - minToLeft[i];
      if (profitFromSelling > max) {
        max = profitFromSelling;
      }
    }
    return max;
  }
}
