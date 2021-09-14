package com.saurabh.practice.dynamic_programming;

public class MinPathCostInMatrix {
  private static final int INFINITY = 1000;

  public static void main(String[] args) {
    int[][] matrix = new int[][]{
      {2, 8, 4, 1, 6, 4, 2},
      {6, 0, 9, 5, 3, 8, 5},
      {1, 4, 3, 4, 0, 6, 5},
      {6, 4, 7, 2, 4, 6, 1},
      {1, 0, 3, 7, 1, 2, 7},
      {1, 5, 3, 2, 3, 0, 9},
      {2, 2, 5, 1, 9, 8, 2}
    };
    int row = matrix.length - 1;
    int col = matrix[0].length - 1;
    int[][] cost = new int[row + 1][col + 1];
    System.out.println(minPathCost_recursion(matrix, 0, 0, cost));
    System.out.println(minPathCost_dp(matrix));
  }

  public static int minPathCost_recursion(int[][] matrix, int x, int y, int[][] cost) {
    if (x == matrix.length || y == matrix[0].length) return INFINITY;
    if (cost[x][y] == 0) {
      int min = Math.min(minPathCost_recursion(matrix, x + 1, y, cost), minPathCost_recursion(matrix, x, y + 1, cost));
      cost[x][y] = matrix[x][y] + (min >= INFINITY ? 0 : min);
    }
    return cost[x][y];
  }

  public static int minPathCost_dp(int[][] matrix) {
    int[][] cost = new int[matrix.length][matrix[0].length];
    for (int i = matrix.length - 1; i >= 0; i--) {
      for (int j = matrix[0].length - 1; j >= 0; j--) {
        int min = Math.min(cost(i + 1, j, cost), cost(i, j + 1, cost));
        cost[i][j] = matrix[i][j] + (min >= INFINITY ? 0 : min);
      }
    }
    return cost[0][0];
  }

  private static int cost(int i, int j, int[][] cost) {
    if (i >= cost.length || j >= cost[0].length) return INFINITY;
    return cost[i][j];
  }
}
