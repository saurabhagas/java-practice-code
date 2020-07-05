package com.saurabh.practice.backtracking;

import com.saurabh.source.common.MathUtils;

public class MazeShortestPath {
  private static final int INFINITY = 1000000;

  public static void main(String[] args) {
    int[][] matrix = {
        {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
        {0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
        {0, 0, 1, 0, 1, 1, 1, 0, 0, 1},
        {1, 0, 1, 1, 1, 0, 1, 1, 0, 1},
    };
    int result = calculate(matrix, 3, 4);
    System.out.println(result);
  }

  public static int calculate(int[][] matrix, int destX, int destY) {
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    int result = calculate(matrix, destX, destY, 0, 0, visited);
    return result > INFINITY ? Integer.MAX_VALUE : result;
  }

  private static int calculate(int[][] matrix, int destX, int destY, int x, int y, boolean[][] visited) {
    if (!isValid(matrix, x, y, visited)) return INFINITY;

    if (destX == x && destY == y) return 1;

    visited[x][y] = true;
    int left = calculate(matrix, destX, destY, x, y - 1, visited);
    int right = calculate(matrix, destX, destY, x, y + 1, visited);
    int top = calculate(matrix, destX, destY, x - 1, y, visited);
    int bottom = calculate(matrix, destX, destY, x + 1, y, visited);
    visited[x][y] = false;
    return MathUtils.min(left, right, top, bottom) + 1;
  }

  private static boolean isValid(int[][] matrix, int x, int y, boolean[][] visited) {
    return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] == 1 && !visited[x][y];
  }
}
