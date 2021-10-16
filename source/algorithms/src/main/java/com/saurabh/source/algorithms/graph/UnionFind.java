package com.saurabh.source.algorithms.graph;

public class UnionFind {
  private final int[] parents;

  public UnionFind(int vertices) {
    this.parents = makeSet(vertices);
  }

  private static int[] makeSet(int vertices) {
    int[] parents = new int[vertices];
    for (int i = 0; i < vertices; i++) {
      parents[i] = i;
    }
    return parents;
  }

  public int findSet(int vertex) {
    return parents[vertex] == vertex ? vertex : findSet(parents[vertex]);
  }

  public void unionSet(int firstSet, int secondSet) {
    parents[firstSet] = secondSet;
  }
}
