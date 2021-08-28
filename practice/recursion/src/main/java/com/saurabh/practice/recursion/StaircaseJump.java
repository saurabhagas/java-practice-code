package com.saurabh.practice.recursion;

public class StaircaseJump {
  public static void main(String[] args) {
    System.out.println(getStaircaseJumpWays(5, 1));
    System.out.println(getStaircaseJumpWays(5, 2));
    System.out.println(getStaircaseJumpWaysDP(5, 2));
  }

  private static int getStaircaseJumpWays(int height, int maxJump) {
    if (height == 0) return 1; // valid path
    if (height < 0) return 0; // invalid path

    int total = 0;
    for (int i = 1; i <= maxJump; i++) {
      total += getStaircaseJumpWays(height - i, maxJump);
    }
    return total;
  }

  private static int getStaircaseJumpWaysDP(int height, int maxJump) {
    int[] ways = new int[height + 1];
    ways[0] = 1;
    ways[1] = 1;
    for (int currHeight = 2; currHeight <= height; currHeight++) {
      for (int jump = 1; jump <= maxJump && currHeight - jump >= 0; jump++) {
        ways[currHeight] += ways[currHeight - jump];
      }
    }
    return ways[height];
  }
}
