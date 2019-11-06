package com.saurabh.algorithms.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class Kruskal {
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
      return "Edge{" +
          "source=" + source +
          ", destination=" + destination +
          ", weight=" + weight +
          '}';
    }
  }

  static class UnionFind {
    private final int[] parents;

    UnionFind(int vertices) {
      this.parents = makeSet(vertices);
    }

    private int[] makeSet(int vertices) {
      int[] parents = new int[vertices];
      //Make set- creating a new element with a parent pointer to itself.
      for (int i = 0; i < vertices; i++) {
        parents[i] = i;
      }
      return parents;
    }

    int findSet(int vertex) {
      // search until an element is reached whose parent is itself
      return parents[vertex] != vertex ? findSet(parents[vertex]) : vertex;
    }

    void unionSet(int parent, int child) {
      parents[findSet(child)] = findSet(parent);
    }
  }

  static class Graph {
    private final int vertices;
    private final List<Edge> allEdges;

    Graph(int vertices, List<Edge> allEdges) {
      this.vertices = vertices;
      this.allEdges = allEdges;
    }

    void kruskal() {
      Queue<Edge> pq = new PriorityQueue<>(allEdges.size(), Comparator.comparingInt(o -> o.weight));
      pq.addAll(allEdges);
      UnionFind unionFind = new UnionFind(vertices);
      ArrayList<Edge> mst = new ArrayList<>();

      //process vertices - 1 edges
      int index = 0;
      while (index < vertices - 1) {
        Edge edge = pq.remove();
        int x_set = unionFind.findSet(edge.source);
        int y_set = unionFind.findSet(edge.destination);

        if (x_set != y_set) {
          //x and y belong to different sets, adding this edge does not create a cycle, so add it to the MST
          mst.add(edge);
          index++;
          unionFind.unionSet(x_set, y_set);
        }
      }

      System.out.println("Minimum Spanning Tree:\n" + printGraph(mst));
    }

    String printGraph(List<Edge> edgeList) {
      return edgeList.stream().map(Edge::toString).collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String toString() {
      return printGraph(allEdges);
    }
  }

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
    graph.kruskal();
  }
}