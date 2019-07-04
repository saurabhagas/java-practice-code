package com.saurabh.oop;

import java.util.List;

/**
 * Composition is a subset of Aggregation, which is a subset of Association
 */
public class Association {
  private static class Car {
    //engine is a mandatory part of the car
    private final Engine engine; // Composition. Note the final modifier
    private List<AirBag> airBags; // Aggregation

    public Car() {
      engine = new Engine();
    }
  }

  private static class Engine {}

  private static class AirBag {}
}
