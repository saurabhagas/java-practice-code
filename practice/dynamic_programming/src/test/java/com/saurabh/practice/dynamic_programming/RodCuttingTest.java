package com.saurabh.practice.dynamic_programming;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RodCuttingTest {
  private final RodCutting rodCutting = new RodCutting();

  @Test
  public void testWithInput1() {
    Map<Integer, Integer> lengthToPrice = new HashMap<>();
    lengthToPrice.put(1, 2);
    lengthToPrice.put(2, 8);
    lengthToPrice.put(3, 10);
    lengthToPrice.put(4, 12);
    int givenRodLength = lengthToPrice.size();
    int optimalProfit = rodCutting.calculateOptimalProfit(lengthToPrice, givenRodLength);
    assertThat(optimalProfit).isEqualTo(16);
  }

  @Test
  public void testWithInput2() {
    Map<Integer, Integer> lengthToPrice = new HashMap<>();
    lengthToPrice.put(1, 1);
    lengthToPrice.put(2, 5);
    lengthToPrice.put(3, 8);
    lengthToPrice.put(4, 9);
    lengthToPrice.put(5, 10);
    lengthToPrice.put(6, 17);
    lengthToPrice.put(7, 17);
    lengthToPrice.put(8, 20);
    int givenRodLength = lengthToPrice.size();
    int optimalProfit = rodCutting.calculateOptimalProfit(lengthToPrice, givenRodLength);
    assertThat(optimalProfit).isEqualTo(22);
  }

}