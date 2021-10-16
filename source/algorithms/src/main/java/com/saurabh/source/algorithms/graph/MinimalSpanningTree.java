package com.saurabh.source.algorithms.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimalSpanningTree {
  public static void main(String[] args) {
    int vertices = 6;
    List<Edge> edges = new ArrayList<>();
    edges.add(new Edge(0, 1, 4));
    edges.add(new Edge(0, 2, 3));
    edges.add(new Edge(1, 2, 1));
    edges.add(new Edge(1, 3, 2));
    edges.add(new Edge(2, 3, 4));
    edges.add(new Edge(3, 4, 2));
    edges.add(new Edge(4, 5, 6));
    Graph graph = new Graph(vertices, edges);
    System.out.println("Graph: " + graph);
    List<Edge> mst = graph.kruskal();
    System.out.println("Minimum Spanning Tree: " + mst);
  }

  static class Edge {
    private final int source;
    private final int destination;
    private final int weight;

    Edge(int source, int destination, int weight) {
      this.source = source;
      this.destination = destination;
      this.weight = weight;
    }

    @Override
    public String toString() {
      return "(" + source + "," + destination + ",weight=" + weight + ")";
    }
  }

  static class Graph {
    private final int vertices;
    private final List<Edge> allEdges;

    Graph(int vertices, List<Edge> allEdges) {
      this.vertices = vertices;
      this.allEdges = allEdges;
    }

    List<Edge> kruskal() {
      Queue<Edge> heap = new PriorityQueue<>(Comparator.comparingInt(one -> one.weight));
      heap.addAll(allEdges);
      UnionFind unionFind = new UnionFind(vertices);
      List<Edge> mst = new ArrayList<>();
      while (mst.size() < vertices - 1) {
        Edge polled = heap.poll();

        // check which sets the starting and ending vertices of this edge lie in
        int sourceSet = unionFind.findSet(polled.source);
        int destinationSet = unionFind.findSet(polled.destination);

        // If those sets aren't equal - add the edge to MST and combine the two sets
        if (sourceSet != destinationSet) {
          mst.add(polled);
          unionFind.unionSet(sourceSet, destinationSet);
        }
      }
      return mst;
    }

    @Override
    public String toString() {
      return allEdges.toString();
    }
  }
}