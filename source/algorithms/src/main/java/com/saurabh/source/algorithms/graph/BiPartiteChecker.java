package com.saurabh.source.algorithms.graph;

import java.util.Arrays;

/**
 * If a graph can be partitioned into two sets such that the only edges in the graph and the one going
 * from one set to another, it's called a bipartite graph.
 *
 * Interesting notes:
 * 1. Every level in a tree is bipartite with every other level.
 * 2. Bipartite graph is same as the k-colorings problem with k=2.
 * 3. The complement of a bipartite graph is the 2-Clique problem. A clique is a fully-connected graph.
 * 4. Each set in the bipartite graph is an independent set (IS).
 * 5. A graph with no edges is trivially bipartite.
 * 6. A graph with one or more self-loops is trivially not bipartite.
 */
public class BiPartiteChecker {
  /**
   * Takes in a graph and determines if it's bipartite.
   * @param graph in adjacency matrix representation
   * @return true if the graph is bipartite, false otherwise
   */
  public boolean isBiPartite(int[][] graph) {
    Color[] colors = new Color[graph.length];
    Arrays.fill(colors, Color.NONE);

    colors[0] = Color.RED; // Color the first vertex RED

    for (int i = 0; i < graph.length; i++) {
      Color currentColor = colors[i];
      if (currentColor == Color.NONE) {
        Color neighborColor = Color.NONE;
        for (int j = 0; j < graph[0].length; j++) {
          if (i == j) {
            if (graph[i][j] == 1) {
              return false; // Graphs with self-loops can't be bipartite
            } else {
              continue;
            }
          }

          if (graph[i][j] == 1) {
            if (neighborColor != Color.NONE && neighborColor != colors[j]) {
              return false; // Neighbor found to have the same color
            }

            if (colors[j] != Color.NONE) {
              neighborColor = colors[j];
            }
          }
        }
        colors[i] = neighborColor == Color.RED ? Color.BLUE : Color.RED;
      } else {
        for (int j = 0; j < graph[0].length; j++) {
          if (i == j) {
            if (graph[i][j] == 1) {
              return false; // Graphs with self-loops can't be bipartite
            } else {
              continue;
            }
          }

          if (graph[i][j] == 1) {
            if (colors[j] != Color.NONE && colors[j] == currentColor) {
              return false;
            } else {
              colors[j] = currentColor == Color.RED ? Color.BLUE : Color.RED;
            }
          }
        }
      }
    }
    return true;
  }

  private enum Color {
    RED,
    BLUE,
    NONE
  }
}
