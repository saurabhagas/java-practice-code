package com.saurabh.practice.dynamic_programming;

import com.saurabh.source.common.Tuple;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class BoundedKnapsackTest {
  @Test
  public void testWithInput1() {
    Map<String, Tuple<Integer, Integer>> itemsToValuesAndWeights = new HashMap<>();
    itemsToValuesAndWeights.put("Apples", Tuple.of(60, 10));
    itemsToValuesAndWeights.put("Potatoes", Tuple.of(100, 20));
    itemsToValuesAndWeights.put("Oranges", Tuple.of(120, 30));
    int knapsackCapacity = 55;

    Knapsack knapsack = new BoundedKnapsack(itemsToValuesAndWeights, knapsackCapacity);
    int optimalProfit = knapsack.calculateOptimalValue();
    assertThat(optimalProfit).isEqualTo(220);
  }

  @Test
  public void testWithInput2() {
    Map<String, Tuple<Integer, Integer>> itemsToValuesAndWeights = new HashMap<>();
    itemsToValuesAndWeights.put("Apples", Tuple.of(15, 15));
    itemsToValuesAndWeights.put("Potatoes", Tuple.of(10, 12));
    itemsToValuesAndWeights.put("Oranges", Tuple.of(8, 10));
    itemsToValuesAndWeights.put("Onions", Tuple.of(1, 5));
    int knapsackCapacity = 22;

    Knapsack knapsack = new BoundedKnapsack(itemsToValuesAndWeights, knapsackCapacity);
    int optimalProfit = knapsack.calculateOptimalValue();
    assertThat(optimalProfit).isEqualTo(18);
  }
}