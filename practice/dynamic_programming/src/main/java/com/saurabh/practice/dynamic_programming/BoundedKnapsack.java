package com.saurabh.practice.dynamic_programming;

import com.saurabh.source.common.Tuple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 0-1 Bounded Knapsack solution.
 */
public class BoundedKnapsack implements Knapsack {
  private final Map<String, Tuple<Integer, Integer>> itemsToValuesAndWeights;
  private final int[][] optimalValuesMatrix;
  private final int itemCount;
  private final int capacity;

  public BoundedKnapsack(Map<String, Tuple<Integer, Integer>> itemsToValuesAndWeights, int capacity) {
    this.itemCount = itemsToValuesAndWeights.size();
    this.capacity = capacity;
    this.itemsToValuesAndWeights = new HashMap<>(itemsToValuesAndWeights);
    this.optimalValuesMatrix = new int[itemCount + 1][capacity + 1];
  }

  @Override
  public int calculateOptimalValue() {
    List<String> items = new ArrayList<>(itemsToValuesAndWeights.keySet());
    items.add(0, "");

    for (int i = 1; i <= itemCount; i++) {
      String item = items.get(i);
      Tuple<Integer, Integer> tuple = itemsToValuesAndWeights.get(item);
      int value = tuple.getT1();
      int weight = tuple.getT2();

      for (int b = 1; b <= capacity; b++) {
        if (weight > b) {
          optimalValuesMatrix[i][b] = optimalValuesMatrix[i - 1][b];
        } else {
          optimalValuesMatrix[i][b] = Math.max(value + optimalValuesMatrix[i - 1][b - weight], optimalValuesMatrix[i - 1][b]);
        }
      }
    }
    return optimalValuesMatrix[itemCount][capacity];
  }
}
