package com.saurabh.practice.amazon;

import java.util.ArrayDeque;
import java.util.Deque;

// Problem at: https://leetcode.com/problems/rotting-oranges/
public class _2RottingOranges {
  public static void main(String[] args) {
    _2RottingOranges obj = new _2RottingOranges();
    int[][] grid = {
        {2, 1, 1},
        {1, 1, 0},
        {0, 1, 1}
    };
    System.out.println(obj.orangesRotting(grid));
  }

  public int orangesRotting(int[][] grid) {
    Deque<Tuple> queue = new ArrayDeque<>(); // Queue of rotten oranges
    int rows = grid.length;
    int columns = grid[0].length;
    int freshOranges = 0;
    int iteration = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (grid[i][j] == 1) freshOranges++;
        else if (grid[i][j] == 2) queue.offer(new Tuple(i, j, iteration));
      }
    }

    if (freshOranges == 0) return 0; // If there are no fresh oranges, everything is already rotten

    while (!queue.isEmpty()) {
      Tuple rotten = queue.poll();
      int x = rotten.x;
      int y = rotten.y;
      iteration = rotten.iteration;

      if (x - 1 >= 0 && grid[x - 1][y] == 1) {
        grid[x - 1][y] = 2;
        freshOranges--;
        queue.offer(new Tuple(x - 1, y, iteration + 1));
      }
      if (x + 1 < rows && grid[x + 1][y] == 1) {
        grid[x + 1][y] = 2;
        freshOranges--;
        queue.offer(new Tuple(x + 1, y, iteration + 1));
      }
      if (y - 1 >= 0 && grid[x][y - 1] == 1) {
        grid[x][y - 1] = 2;
        freshOranges--;
        queue.offer(new Tuple(x, y - 1, iteration + 1));
      }
      if (y + 1 < columns && grid[x][y + 1] == 1) {
        grid[x][y + 1] = 2;
        freshOranges--;
        queue.offer(new Tuple(x, y + 1, iteration + 1));
      }
    }

    return freshOranges == 0 ? iteration : -1;
  }

  private static class Tuple {
    final int x;
    final int y;
    final int iteration;

    Tuple(int x, int y, int iteration) {
      this.x = x;
      this.y = y;
      this.iteration = iteration;
    }

    @Override
    public String toString() {
      return "x=" + x + ", y=" + y;
    }
  }
}


