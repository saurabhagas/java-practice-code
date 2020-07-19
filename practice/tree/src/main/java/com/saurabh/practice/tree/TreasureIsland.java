package com.saurabh.practice.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreasureIsland {
  public static void main(String[] args) {
    int[][] maze = {
        {'O', 'O', 'O', 'O'},
        {'D', 'O', 'D', 'O'},
        {'O', 'O', 'O', 'O'},
        {'X', 'D', 'D', 'O'}
    };

    TreasureIsland treasureIsland = new TreasureIsland();
    int steps = treasureIsland.findSteps(maze);
    System.out.println("steps = " + steps);
  }

  private int findSteps(int[][] maze) {
    Queue<Position> queue = new ArrayDeque<>();
    int steps = 0;
    queue.offer(new Position(0, 0));
    int v[][] = new int[maze.length][maze[0].length];

    int i = 0, j = 0;
    int[][] directions = {
        {1, 0},
        {0, 1},
        {-1, 0},
        {0, -1}
    };
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int k = 0; k < size; k++) {
        Position position = queue.poll();
        i = position.x;
        j = position.y;
        if (i < maze.length && j < maze.length && maze[i][j] == 'X') {
          return steps;
        }

        for (int[] direction : directions) {
          int x = i + direction[0];
          int y = j + direction[1];
          if (x < maze.length && x >= 0 && y < maze[0].length && y >= 0 && maze[x][y] != 'D' && v[x][y] == 0) {
            queue.offer(new Position(x, y));
            v[x][y] = 1;
          }
        }

      }
      steps++;

    }
    return steps;
  }


}

class Position {
  public int x, y;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
