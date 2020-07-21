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

  int findSet(int vertex) {
    return parents[vertex] == vertex ? vertex : findSet(parents[vertex]);
  }

  void unionSet(int one, int two) {
    int firstSet = findSet(one);
    int secondSet = findSet(two);
    parents[firstSet] = secondSet;
  }
}
