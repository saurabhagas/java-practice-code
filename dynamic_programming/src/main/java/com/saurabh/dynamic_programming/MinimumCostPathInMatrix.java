package com.saurabh.dynamic_programming;

/**
 * https://www.geeksforgeeks.org/min-cost-path-dp-6/
 */
public class MinimumCostPathInMatrix {
  public static void main(String[] args) {
    int[][] costMatrix = {
        {1, 2, 3, 4},
        {4, 8, 2, 10},
        {1, 5, 3, 0}
    };

//    System.out.println(minCost(costMatrix, costMatrix.length - 1, costMatrix[0].length - 1));
    System.out.println(
        String.format(
            "Min path cost from [0][0] to [%d][%d] is of length %s",
            costMatrix.length - 1,
            costMatrix[0].length - 1,
            minCostDP(costMatrix, costMatrix.length - 1, costMatrix[0].length - 1)
        )
    );
  }

  /**
   * Finds the minimum cost between (0,0) and (x,y). This program can compute the max cost by replacing MAX_VALUE with
   * MIN_VALUE and replacing the min() call with a max() call.
   *
   * @param costMatrix matrix containing the cost of vertices
   * @param x          the x coordinate of the destination
   * @param y          the y coordinate of the destination
   * @return the cost of the minimum path
   */
  private static int minCost(int[][] costMatrix, int x, int y) {
    if (x < 0 || y < 0) return Integer.MAX_VALUE;
    if (x == 0 && y == 0) return costMatrix[0][0];

    return costMatrix[x][y] + min(
        minCost(costMatrix, x - 1, y - 1),
        minCost(costMatrix, x - 1, y),
        minCost(costMatrix, x, y - 1)
    );
  }

  /**
   * Dynamic programming flavor of {@link #minCost(int[][], int, int)} function.
   */
  private static int minCostDP(int[][] costMatrix, int x, int y) {
    int[][] minCostMatrix = new int[x + 1][y + 1];

    minCostMatrix[0][0] = costMatrix[0][0];

    //Initialize first column of minCostMatrix
    for (int i = 1; i <= x; i++)
      minCostMatrix[i][0] = minCostMatrix[i - 1][0] + costMatrix[i][0];

    //Initialize first row of minCostMatrix
    for (int j = 1; j <= y; j++)
      minCostMatrix[0][j] = minCostMatrix[0][j - 1] + costMatrix[0][j];

    //Construct rest of the minCostMatrix array
    for (int i = 1; i <= x; i++)
      for (int j = 1; j <= y; j++) {
        int minThusFar = min(
            minCostMatrix[i - 1][j - 1],
            minCostMatrix[i - 1][j],
            minCostMatrix[i][j - 1]
        );
        minCostMatrix[i][j] = minThusFar + costMatrix[i][j];
      }

    return minCostMatrix[x][y];
  }

  private static int min(int a, int b, int c) {
    return a < b ? Math.min(a, c) : Math.min(b, c);
  }
}
