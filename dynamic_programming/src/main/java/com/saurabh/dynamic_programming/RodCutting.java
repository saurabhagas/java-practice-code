package com.saurabh.dynamic_programming;

import java.util.Map;

/**
 * Given a rod of length n units and a list of prices that contains prices of all pieces of size smaller than n,
 * determine the maximum value obtainable by cutting up the rod and selling the individual pieces.
 * <p>
 * Problem definition and solution available at: https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
 */
public class RodCutting {
  /**
   * Strategy: For a rod of length i, the optimal profit would be the maximum profit attainable for all cuts of length
   * less than i. For each cut of length j less than i, the profit can be written as value[j] + profit[i-j].
   * The optimal profit for a rod of length i then becomes max(value[j] + profit[i-j]) for 1<=j<=i.
   *
   * @param lengthToPrice  a mapping containing the length and the prices associated with them
   * @param givenRodLength the rod length
   * @return optimal profit
   */
  public int calculateOptimalProfit(Map<Integer, Integer> lengthToPrice, int givenRodLength) {
    //Maintaining an array of length givenRodLength + 1 because rodLength varies from 1 through n (both inclusive)
    int[] optimalProfit = new int[givenRodLength + 1];
    optimalProfit[0] = 0;
    for (int rodLength = 1; rodLength <= givenRodLength; rodLength++) {
      int max = Integer.MIN_VALUE;
      for (int cutSize = 1; cutSize <= rodLength; cutSize++) {
        int revenueWithCurrentCut = lengthToPrice.get(cutSize) + optimalProfit[rodLength - cutSize];
        if (revenueWithCurrentCut > max) {
          max = revenueWithCurrentCut;
        }
      }
      optimalProfit[rodLength] = max;
    }
    return optimalProfit[optimalProfit.length - 1];
  }
}
