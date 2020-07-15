package com.saurabh.practice.graph;

import java.util.*;

public class TopologicalSort {
  public static void main(String[] args) {
    TopologicalSort ts = new TopologicalSort();
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    adjList.put(0, Arrays.asList(6));
    adjList.put(1, Arrays.asList(2, 4, 6));
    adjList.put(2, Arrays.asList());
    adjList.put(3, Arrays.asList(0, 4));
    adjList.put(4, Arrays.asList());
    adjList.put(5, Arrays.asList(1));
    adjList.put(6, Arrays.asList());
    adjList.put(7, Arrays.asList(0, 1));
    ArrayList<Integer> sortedList = ts.sortTopologically(adjList);
    System.out.println("sortedList = " + sortedList);
    System.out.println("ts.verifyTopologicalSort(adjList, sortedList) = " + ts.verifyTopologicalSort(adjList, sortedList));
    System.out.println("ts.verifyTopologicalSort(adjList, sortedList) = " + ts.verifyTopologicalSort(adjList, Arrays.asList(7,5,3,1,4,2,0,6)));
    System.out.println("ts.verifyTopologicalSort(adjList, sortedList) = " + ts.verifyTopologicalSort(adjList, Arrays.asList(7,5,1,2,3,4,0,6)));
    System.out.println("ts.verifyTopologicalSort(adjList, sortedList) = " + ts.verifyTopologicalSort(adjList, Arrays.asList(5,7,3,1,0,2,6,4)));
    System.out.println("ts.verifyTopologicalSort(adjList, sortedList) = " + ts.verifyTopologicalSort(adjList, Arrays.asList(3,5,7,0,1,2,6,4)));
    System.out.println("ts.verifyTopologicalSort(adjList, sortedList) = " + ts.verifyTopologicalSort(adjList, Arrays.asList(3,5,7,0,1,2,6,4)));
    System.out.println("ts.verifyTopologicalSort(adjList, sortedList) = " + ts.verifyTopologicalSort(adjList, Arrays.asList(5,7,3,0,1,4,6,2)));
    System.out.println("ts.verifyTopologicalSort(adjList, sortedList) = " + ts.verifyTopologicalSort(adjList, Arrays.asList(7,5,1,3,4,0,6,2)));
  }

  private ArrayList<Integer> sortTopologically(Map<Integer, List<Integer>> adjList) {
    ArrayList<Integer> res = new ArrayList<Integer>();
    int[] inDeg = new int[adjList.size()];
    adjList.values().forEach(list -> list.forEach(e -> inDeg[e]++));
    Deque<Integer> queue = new ArrayDeque<>();

    for (int i = 0; i < inDeg.length; i++) {
      if (inDeg[i] == 0) queue.add(i);
    }

    int visited = 0;
    while (!queue.isEmpty()) {
      Integer polled = queue.poll();
      res.add(polled);
      visited++;
      List<Integer> children = adjList.get(polled);
      for (int i = 0; i < children.size(); i++) {
        Integer child = children.get(i);
        inDeg[child]--;
        if (inDeg[child] == 0) queue.offer(child);
      }

    }
    if (visited == adjList.size()) {
      return res;
    } else {
      return new ArrayList<>();
    }
  }

  private Boolean verifyTopologicalSort(Map<Integer, List<Integer>> adjList, List<Integer> sortedList) {
    for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
      Integer nodeU = entry.getKey();
      int nodeUIndex = sortedList.indexOf(nodeU);
      List<Integer> nodeList = entry.getValue();
      for (Integer nodeV : nodeList) {
        int nodeVIndex = sortedList.indexOf(nodeV);
        if (nodeUIndex > nodeVIndex) {
          return false;
        }
      }
    }
    return true;
  }
}
