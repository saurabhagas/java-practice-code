package com.saurabh.practice.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinCostToConnectRopes {
  public static void main(String[] args) {
    MinCostToConnectRopes minCostToConnect = new MinCostToConnectRopes();
    int minCost1 = minCostToConnect.getCostToConnectRopes(new int[]{8, 4, 6, 12});
    System.out.println("minCost = " + minCost1);
    int minCost2 = minCostToConnect.getCostToConnectRopes(new int[]{2, 2, 3, 3});
    System.out.println("minCost = " + minCost2);
    int minCost3 = minCostToConnect.getCostToConnectRopes(new int[]{20, 4, 8, 2});
    System.out.println("minCost = " + minCost3);
    int minCost4 = minCostToConnect.getCostToConnectRopes(new int[]{89, 35, 10, 5, 2, 1});
    System.out.println("minCost = " + minCost4);
  }

  private int getCostToConnectRopes(int[] ropeLengths) {

    Queue<Integer> heap = new PriorityQueue<>();
    for (int ropeLength : ropeLengths) {
      heap.add(ropeLength);
    }
    int minCost = 0;
    while (heap.size() > 1) {
      int minCost1 = heap.poll();
      int minCost2 = heap.poll();
      int currMinCost = minCost1 + minCost2;
      heap.offer(currMinCost);
      minCost += currMinCost;
    }
    return minCost;
  }
}
