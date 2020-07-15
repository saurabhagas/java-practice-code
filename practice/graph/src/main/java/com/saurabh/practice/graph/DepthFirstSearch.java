package com.saurabh.practice.graph;

import java.util.*;

public class DepthFirstSearch {
  public static void main(String[] args) {
    DepthFirstSearch dfs = new DepthFirstSearch();
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    adjList.put(0, Arrays.asList(6));
    adjList.put(1, Arrays.asList(2, 4, 6));
    adjList.put(2, Arrays.asList());
    adjList.put(3, Arrays.asList(0, 4));
    adjList.put(4, Arrays.asList());
    adjList.put(5, Arrays.asList(1));
    adjList.put(6, Arrays.asList());
    adjList.put(7, Arrays.asList(0, 1));
    List<Integer> dfsList = dfs.getDFSRecursive(adjList);
    System.out.println("dfsList = " + dfsList);
  }

  private List<Integer> getDFSRecursive(Map<Integer, List<Integer>> adjList) {
    List<Integer> result = new ArrayList<>();
    boolean[] visited = new boolean[adjList.size()];

    adjList.forEach((key, value) -> {
      visited[key] = true;
      result.add(key);
      getDFS(visited, value, adjList, result);
    });
    return result;
  }

  private void getDFS(boolean[] visited, List<Integer> nodeList, Map<Integer, List<Integer>> adjList, List<Integer> result) {
    nodeList.forEach(node -> {
      if (!visited[node]) {
        visited[node] = true;
        result.add(node);
        getDFS(visited, adjList.get(node), adjList, result);
      }
    });
  }

}
