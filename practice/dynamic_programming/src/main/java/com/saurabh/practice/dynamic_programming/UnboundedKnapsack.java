package com.saurabh.practice.dynamic_programming;

import com.saurabh.source.common.Tuple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * Unbounded Knapsack solution.
 */
public class UnboundedKnapsack implements Knapsack {
  private final Map<String, Tuple<Integer, Integer>> itemsToValuesAndWeights;
  private final int[] optimalValuesMatrix;
  private final int itemCount;
  private final int capacity;

  public UnboundedKnapsack(Map<String, Tuple<Integer, Integer>> itemsToValuesAndWeights, int capacity) {
    this.itemCount = itemsToValuesAndWeights.size();
    this.capacity = capacity;
    this.itemsToValuesAndWeights = new HashMap<>(itemsToValuesAndWeights);
    this.optimalValuesMatrix = new int[capacity + 1];
  }

  @Override
  public int calculateOptimalValue() {
    List<String> items = new ArrayList<>(itemsToValuesAndWeights.keySet());
    items.add(0, "");

    for (int b = 0; b <= capacity; b++) {
      for (int i = 1; i <= itemCount; i++) {
        String item = items.get(i);
        Tuple<Integer, Integer> tuple = itemsToValuesAndWeights.get(item);
        int value = tuple.getT1();
        int weight = tuple.getT2();
        if (weight <= b && optimalValuesMatrix[b] < value + optimalValuesMatrix[b - weight]) {
          optimalValuesMatrix[b] = value + optimalValuesMatrix[b - weight];
        }
      }
    }
    return optimalValuesMatrix[capacity];
  }
}
