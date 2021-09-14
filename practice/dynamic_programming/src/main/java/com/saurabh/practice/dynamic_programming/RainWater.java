package com.saurabh.practice.dynamic_programming;

import java.util.Arrays;

/**
 * Problem: https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/211/
 */
public class RainWater {
  public static void main(String[] args) {
    RainWater obj = new RainWater();
    System.out.println(obj.trap(new int[]{4, 2, 0, 3, 2, 5}));
  }

  public int trap(int[] heights) {
    int[] leftMax = buildLeftMax(heights);
    int[] rightMax = buildRightMax(heights);
    int[] water = new int[heights.length];
    for (int i = 0; i < heights.length; i++) {
      int min = Math.min(leftMax[i], rightMax[i]);
      if (heights[i] < min) {
        water[i] = min - heights[i];
      }
    }
    return getTotal(water);
  }

  private int[] buildLeftMax(int[] heights) {
    int[] leftMax = new int[heights.length];
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < heights.length; i++) {
      if (heights[i] > max) max = heights[i];
      leftMax[i] = max;
    }
    return leftMax;
  }

  private int[] buildRightMax(int[] heights) {
    int max = Integer.MIN_VALUE;
    int[] rightMax = new int[heights.length];
    for (int i = heights.length - 1; i >= 0; i--) {
      if (heights[i] > max) max = heights[i];
      rightMax[i] = max;
    }
    return rightMax;
  }

  private int getTotal(int[] water) {
    return Arrays.stream(water).sum();
  }
}
