package com.saurabh.practice.recursion;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/203/
 */
public class SetRowsAndColumnsToZero {
  public static void main(String[] args) {
    SetRowsAndColumnsToZero obj = new SetRowsAndColumnsToZero();
    int[][] matrix = new int[][]{
      {0, 1, 2, 0},
      {3, 4, 5, 2},
      {1, 3, 1, 5}
    };
    obj.setZeroes(matrix);
    System.out.println(Arrays.deepToString(matrix));
  }

  public void setZeroes(int[][] matrix) {
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        setZeroes(matrix, i, j, visited);
      }
    }
  }

  private void setZeroes(int[][] matrix, int x, int y, boolean[][] visited) {
    if (x < 0 || x > matrix.length || y < 0 || y > matrix[0].length || visited[x][y] || matrix[x][y] != 0) {
      return;
    }

    visited[x][y] = true;
    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i][y] != 0) {
        matrix[i][y] = 0;
        visited[i][y] = true;
      }
    }

    for (int i = 0; i < matrix[0].length; i++) {
      if (matrix[x][i] != 0) {
        matrix[x][i] = 0;
        visited[x][i] = true;
      }
    }
  }
}
