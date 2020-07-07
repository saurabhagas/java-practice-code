package com.saurabh.practice.backtracking;

import com.saurabh.source.common.Tuple;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SimpleRatInMaze {
  public static void main(String[] args) {
    int[][] maze = {
        { 1, 0, 0, 0 },
        { 1, 1, 0, 1 },
        { 0, 1, 0, 0 },
        { 1, 1, 1, 1 }
    };
    System.out.println(solve(maze));
  }

  public static String solve(int[][] maze) {
    List<Tuple<Integer, Integer>> traversal = new ArrayList<>();
    boolean[][] visited = new boolean[maze.length][maze[0].length];
    solveInternal(maze, 0, 0, traversal, visited);
    if (traversal.isEmpty()) {
      return "Not possible";
    } else {
      return traversal.toString();
    }
  }

  private static boolean solveInternal(int[][] maze, int x, int y, List<Tuple<Integer, Integer>> traversal, boolean[][] visited) {
    if (x >= maze.length || y >= maze[0].length || maze[x][y] == 0) return false;
    if (x == maze.length - 1 && y == maze[0].length - 1) {
      traversal.add(new Tuple<>(x, y));
      return true;
    }

    visited[x][y] = true;
    traversal.add(new Tuple<>(x, y));

    boolean forward = solveInternal(maze, x, y + 1, traversal, visited);
    boolean down = solveInternal(maze, x + 1, y, traversal, visited);

    if (!forward && !down) traversal.remove(new Tuple<>(x, y));
    visited[x][y] = false;
    return forward || down;
  }
}
