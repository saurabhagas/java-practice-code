package com.saurabh.practice.graph;

import java.util.ArrayList;
import java.util.List;

public class MaxInfectablePeople {
  public static void main(String[] args) {
    // 0 - positive
    // 1 - negative
    // 2 - vaccinated
    int[][] matrix = new int[][]{
      {0, 2, 1, 0},
      {1, 1, 2, 2},
      {0, 2, 0, 1}
    };
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
//    System.out.println(countReachablePeople(matrix, 1, 2, visited) - 1);
//    System.out.println(isAtRisk(matrix, 1, 1, visited));
//    int clusters = 0;
//    for (int i = 0; i < matrix.length; i++) {
//      for (int j = 0; j < matrix[0].length; j++) {
//        if (traverse(matrix, i, j, visited)) {
//          clusters++;
//        }
//      }
//    }
//    System.out.println(clusters);

    List<Integer> ranks = new ArrayList<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        int rank = calculateRank(matrix, i, j, visited);
        if (rank != 0) ranks.add(rank);
      }
    }
    ranks.sort(Integer::compareTo);
    System.out.println(ranks);
  }

  public static int countReachablePeople(int[][] matrix, int x, int y, boolean[][] visited) {
    if (x < 0 || x == matrix.length || y < 0 || y == matrix[0].length || visited[x][y] || matrix[x][y] == 2) {
      return 0;
    }
    int infected = 1;
    visited[x][y] = true;
    infected += countReachablePeople(matrix, x, y + 1, visited); // right
    infected += countReachablePeople(matrix, x, y - 1, visited); // left
    infected += countReachablePeople(matrix, x - 1, y, visited); // top
    infected += countReachablePeople(matrix, x + 1, y, visited); // bottom
    return infected;
  }

  public static boolean isAtRisk(int[][] matrix, int x, int y, boolean[][] visited) {
    if (x < 0 || x == matrix.length || y < 0 || y == matrix[0].length || visited[x][y] || matrix[x][y] == 2) {
      return false;
    }
    if (matrix[x][y] == 0) return true;

    visited[x][y] = true;
    return isAtRisk(matrix, x, y + 1, visited) // right
      || isAtRisk(matrix, x, y - 1, visited) // left
      || isAtRisk(matrix, x - 1, y, visited) // top
      || isAtRisk(matrix, x + 1, y, visited); // bottom
  }

  public static boolean traverse(int[][] matrix, int x, int y, boolean[][] visited) {
    if (x < 0 || x == matrix.length || y < 0 || y == matrix[0].length || visited[x][y] || matrix[x][y] == 2) {
      return false;
    }
    visited[x][y] = true;
    traverse(matrix, x, y + 1, visited); // right
    traverse(matrix, x, y - 1, visited);// left
    traverse(matrix, x - 1, y, visited); // top
    traverse(matrix, x + 1, y, visited); // bottom
    return true;
  }

  public static int calculateRank(int[][] matrix, int x, int y, boolean[][] visited) {
    if (x < 0 || x == matrix.length || y < 0 || y == matrix[0].length || visited[x][y] || matrix[x][y] == 2) {
      return 0;
    }
    int infected = 0;
    if (matrix[x][y] == 0) infected++;
    visited[x][y] = true;
    infected += calculateRank(matrix, x, y + 1, visited); // right
    infected += calculateRank(matrix, x, y - 1, visited); // left
    infected += calculateRank(matrix, x - 1, y, visited); // top
    infected += calculateRank(matrix, x + 1, y, visited); // bottom
    return infected;
  }
}
