package com.saurabh.practice.recursion;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/202/
 */
public class RotateImage {
  public static void main(String[] args) {
    RotateImage obj = new RotateImage();
    int[][] matrix = new int[][]{
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9},
    };
    obj.rotate(matrix);
    System.out.println(Arrays.deepToString(matrix));
  }

  public void rotate(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < 2 * (i + 1) && j < cols; j++) {
        int temp = matrix[j][rows - 1 - i];
        matrix[j][rows - 1 - i] = matrix[i][j];
        matrix[i][j] = temp;
      }
    }
  }
}
