package com.saurabh.practice.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
  private static final int INFINITY = 1000; // Not using Integer.MAX_VALUE because addition to it overflows

  public static void main(String[] args) {
    System.out.println(countWays_jumpsOneTwoOrThree(10));
    Map<Integer, Integer> jumpMapping = new HashMap<>();
    jumpMapping.put(0, 2);
    jumpMapping.put(1, 3);
    jumpMapping.put(2, 0);
    jumpMapping.put(3, 1);
    jumpMapping.put(4, 2);
    jumpMapping.put(5, 3);
    System.out.println(countWays_variableJumps(6, jumpMapping));
    System.out.println(minWays_variableJumps(6, jumpMapping));
  }

  /**
   * Count the number of ways in which a staircase can be climbed from the bottom.
   * Inputs:
   * - n (size of the staircase)
   * - x, y, z (size of jumps which can be taken)
   */
  public static int countWays_jumpsOneTwoOrThree(int size) {
    // num of ways to reach any level from the bottom are equal to the sum of ways for the lower levels
    int[] numPaths = new int[size + 1];
    numPaths[0] = 1;
    for (int i = 1; i <= size; i++) {
      numPaths[i] = numPaths[i - 1] + (i >= 2 ? numPaths[i - 2] : 0) + (i >= 3 ? numPaths[i - 3] : 0);
    }
    return numPaths[size];
  }

  /**
   * Count the number of ways in which a staircase can be climbed from the bottom.
   * Inputs:
   * - n (size of the staircase)
   * - jump map by level (jumps which can be taken at a given level)
   */
  public static int countWays_variableJumps(int size, Map<Integer, Integer> possibleJumpsByLevel) {
    // num of ways to reach the top from the current level
    int[] numPaths = new int[size + 1];
    numPaths[size] = 1;
    for (int level = size - 1; level >= 0; level--) {
      int jumpsFromCurrentLevel = possibleJumpsByLevel.get(level);
      for (int jump = 1; jump <= jumpsFromCurrentLevel && level + jump <= size; jump++) {
        numPaths[level] += numPaths[level + jump];
      }
    }
    return numPaths[0];
  }

  /**
   * Count the minimum number of jumps required to reach the top of the staircase.
   * Inputs:
   * - n (size of the staircase)
   * - jump map by level (jumps which can be taken at a given level)
   */
  public static int minWays_variableJumps(int size, Map<Integer, Integer> possibleJumpsByLevel) {
    // num of ways to reach the top from the current level
    int[] minWays = new int[size + 1];
    minWays[size] = 1;
    for (int level = size - 1; level >= 0; level--) {
      int jumpsFromCurrentLevel = possibleJumpsByLevel.get(level);
      int min = INFINITY;
      int minLevel = -1;
      for (int jump = 1; jump <= jumpsFromCurrentLevel && level + jump <= size; jump++) {
        if (min >= minWays[level + jump] && minLevel < level + jump) {
          min = minWays[level + jump];
          minLevel = level + jump;
        }
      }

      if (minLevel != size) {
        min++; // need to go via another level, add 1 jump corresponding to this
      }
      minWays[level] = min;
    }
    return minWays[0]; // a value >= INFINITY denotes that no jumps are possible
  }
}
