package com.saurabh.practice.graph;

public class NumIslands {
  public static void main(String[] args) {
    NumIslands obj = new NumIslands();
    char[][] grid = {
      {'1', '1', '1', '1', '0'},
      {'1', '1', '0', '1', '0'},
      {'1', '1', '0', '0', '0'},
      {'0', '0', '0', '0', '0'}
    };
    System.out.println(obj.numIslands(grid));
  }

  public int numIslands(char[][] grid) {
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    int numIslands = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (traverse(grid, i, j, visited)) numIslands++;
      }
    }
    return numIslands;
  }

  /**
   * @return true if at least one unvisited 1 was found starting from (x, y) including (x, y)
   */
  private boolean traverse(char[][] grid, int x, int y, boolean[][] visited) {
    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] == '0') {
      return false;
    }

    visited[x][y] = true;
    traverse(grid, x + 1, y, visited);
    traverse(grid, x - 1, y, visited);
    traverse(grid, x, y + 1, visited);
    traverse(grid, x, y - 1, visited);
    return true;
  }
}