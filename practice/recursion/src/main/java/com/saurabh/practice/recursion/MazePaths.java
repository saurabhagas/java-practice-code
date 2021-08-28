package com.saurabh.practice.recursion;

/**
 * Count the number of paths in a maze of size m x n.
 * Allowed directions are down and right.
 * Starting point (0, 0), ending point (m - 1, n - 1)
 */
public class MazePaths {
  public static void main(String[] args) {
    System.out.println(getMazePaths(1, 1));
    System.out.println(getMazePaths(3, 1));
    System.out.println(getMazePaths(1, 3));
    System.out.println(getMazePaths(2, 2));
    System.out.println(getMazePaths(3, 3));
    System.out.println(getMazePaths(4, 4));
    System.out.println(getMazePaths(5, 5));
    System.out.println(getMazePaths(4, 5));
    System.out.println(getMazePaths(5, 4));
    System.out.println(getMazePaths(5, 3));
  }

  private static int getMazePaths(int rows, int columns) {
    if (rows < 1 || columns < 1) return 0;
    if (rows == 1 || columns == 1) return 1;
    return getMazePaths(rows - 1, columns) + getMazePaths(rows, columns - 1);
  }
}
