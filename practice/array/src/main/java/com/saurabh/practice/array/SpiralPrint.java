package com.saurabh.practice.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralPrint {
  public static void main(String[] args) {
    SpiralPrint spiralPrint = new SpiralPrint();
    int[][] matrix = new int[][]{
      {1, 2, 3, 4},
      {14, 15, 16, 5},
      {13, 20, 17, 6},
      {12, 19, 18, 7},
      {11, 10, 9, 8},
    };
    System.out.println(spiralPrint.spiralOrder(matrix));
  }

  public List<Integer> spiralOrder(int[][] matrix) {
    final int rows = matrix.length;
    final int cols = matrix[0].length;
    final List<Integer> spiralOrder = new ArrayList<>();

    int iteration = 0, row = 0, col = 0;
    int addedInIteration = 0;
    while (spiralOrder.size() != rows * cols) {
      spiralOrder.add(matrix[row][col]);
      addedInIteration++;
      if (addedInIteration == maxPerIteration(iteration, rows, cols)) {
        addedInIteration = 0;
        iteration++;
      }
      if (row == iteration && col < cols - iteration - 1) {
        col++;
      } else if (col == cols - iteration - 1 && row < rows - iteration - 1) {
        row++;
      } else if (row == rows - iteration - 1 && col > iteration) {
        col--;
      } else if (col == iteration && row > iteration){
        row--;
      }
    }
    return spiralOrder;
  }

  private int maxPerIteration(int iteration, int rows, int cols) {
    return 2 * (cols - 1 - 2 * iteration) + 2 * (rows - 1 - 2 * iteration);
  }
}
