package com.saurabh.practice.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TopologicalSort {
  public static void main(String[] args) {
    TopologicalSort ts = new TopologicalSort();
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    adjList.put(0, Arrays.asList(6));
    adjList.put(1, Arrays.asList(2, 4, 6));
    adjList.put(3, Arrays.asList(0, 4));
    adjList.put(5, Arrays.asList(1));
    adjList.put(7, Arrays.asList(0, 1));
    List<Integer> sortedList = ts.sortTopologically(adjList);
    System.out.println("sortedList = " + sortedList);
    System.out.println("ts.verifyTopologicalSort(adjList, sortedList) = " + ts.verifyTopologicalSort(adjList, sortedList));
    System.out.println("ts.verifyTopologicalSort(adjList, sortedList) = " + ts.verifyTopologicalSort(adjList, Arrays.asList(7, 5, 3, 1, 4, 2, 0, 6)));
    System.out.println("ts.verifyTopologicalSort(adjList, sortedList) = " + ts.verifyTopologicalSort(adjList, Arrays.asList(7, 5, 1, 2, 3, 4, 0, 6)));
    System.out.println("ts.verifyTopologicalSort(adjList, sortedList) = " + ts.verifyTopologicalSort(adjList, Arrays.asList(5, 7, 3, 1, 0, 2, 6, 4)));
    System.out.println("ts.verifyTopologicalSort(adjList, sortedList) = " + ts.verifyTopologicalSort(adjList, Arrays.asList(3, 5, 7, 0, 1, 2, 6, 4)));
    System.out.println("ts.verifyTopologicalSort(adjList, sortedList) = " + ts.verifyTopologicalSort(adjList, Arrays.asList(3, 5, 7, 0, 1, 2, 6, 4)));
    System.out.println("ts.verifyTopologicalSort(adjList, sortedList) = " + ts.verifyTopologicalSort(adjList, Arrays.asList(5, 7, 3, 0, 1, 4, 6, 2)));
    System.out.println("ts.verifyTopologicalSort(adjList, sortedList) = " + ts.verifyTopologicalSort(adjList, Arrays.asList(7, 5, 1, 3, 4, 0, 6, 2)));
  }

  private List<Integer> sortTopologically(Map<Integer, List<Integer>> adjList) {
    // use adjacency list to calculate in-degrees of each vertex
    List<Integer> res = new ArrayList<>();
    int vertices = adjList.entrySet().stream()
      .flatMap(entry -> Stream.concat(entry.getValue().stream(), Stream.of(entry.getKey())))
      .collect(Collectors.toSet())
      .size();
    int[] inDeg = new int[vertices];
    adjList.values().forEach(list -> list.forEach(e -> inDeg[e]++));
    Queue<Integer> queue = new ArrayDeque<>();

    // Add source vertices (i.e. vertices with 0 in-degree) to the queue
    for (int i = 0; i < inDeg.length; i++) {
      if (inDeg[i] == 0) queue.add(i);
    }

    int visited = 0;
    while (!queue.isEmpty()) {
      Integer polled = queue.poll();
      res.add(polled);
      visited++;
      List<Integer> children = adjList.get(polled);
      if (children == null) continue;
      for (Integer child : children) {
        // remove the edge to every child
        inDeg[child]--;
        // once the child node has no more incoming edges, add it to the queue
        if (inDeg[child] == 0) queue.offer(child);
      }
    }

    return visited == vertices ? res : new ArrayList<>();
  }

  private Boolean verifyTopologicalSort(Map<Integer, List<Integer>> adjList, List<Integer> sortedList) {
    for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
      int parentIndex = sortedList.indexOf(entry.getKey());
      for (Integer childIndex : entry.getValue()) {
        int nodeVIndex = sortedList.indexOf(childIndex);
        if (parentIndex > nodeVIndex) {
          // parent should be placed before the child in the topological order
          return false;
        }
      }
    }
    return true;
  }
}
