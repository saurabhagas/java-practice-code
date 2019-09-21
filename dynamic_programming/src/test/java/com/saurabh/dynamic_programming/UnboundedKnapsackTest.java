package com.saurabh.dynamic_programming;

import com.saurabh.common.Tuple;
import org.junit.Test;

import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class UnboundedKnapsackTest {
  @Test
  public void testWithInput1() {
    LinkedHashMap<String, Tuple<Integer, Integer>> itemsToValuesAndWeights = new LinkedHashMap<>();
    itemsToValuesAndWeights.put("Apples", Tuple.of(10, 5));
    itemsToValuesAndWeights.put("Potatoes", Tuple.of(30, 10));
    itemsToValuesAndWeights.put("Oranges", Tuple.of(20, 15));
    int knapsackCapacity = 100;

    Knapsack unboundedKnapsack = new UnboundedKnapsack(itemsToValuesAndWeights, knapsackCapacity);
    int optimalProfit = unboundedKnapsack.calculateOptimalValue();
    assertThat(optimalProfit).isEqualTo(300);
  }

  @Test
  public void testWithInput2() {
    LinkedHashMap<String, Tuple<Integer, Integer>> itemsToValuesAndWeights = new LinkedHashMap<>();
    itemsToValuesAndWeights.put("Apples", Tuple.of(50, 2));
    itemsToValuesAndWeights.put("Potatoes", Tuple.of(100, 3));
    itemsToValuesAndWeights.put("Oranges", Tuple.of(140, 5));
    int knapsackCapacity = 17;

    Knapsack unboundedKnapsack = new UnboundedKnapsack(itemsToValuesAndWeights, knapsackCapacity);
    int optimalProfit = unboundedKnapsack.calculateOptimalValue();
    assertThat(optimalProfit).isEqualTo(550);
  }
}