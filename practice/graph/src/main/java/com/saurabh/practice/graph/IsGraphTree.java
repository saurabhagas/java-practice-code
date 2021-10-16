package com.saurabh.practice.graph;

import com.saurabh.source.algorithms.graph.UnionFind;

public class IsGraphTree {
  public static void main(String[] args) {
    IsGraphTree obj = new IsGraphTree();
    int[][] array = {
      {0, 1},
      {0, 4},
      {1, 4},
      {2, 3},
    };
    System.out.println(obj.dfs(5, array));
  }

  private boolean dfs(int vertices, int[][] edges) {
    UnionFind unionFind = new UnionFind(vertices);
    for (int[] edge : edges) {
      int first = unionFind.findSet(edge[0]);
      int second = unionFind.findSet(edge[1]);
      if (first == second) return false;
      unionFind.unionSet(first, second);
    }
    return edges.length == vertices - 1;
  }
}