package com.saurabh.common;

public class City {
  private final int distance;
  private final String name;

  public City(int distance, String name) {
    this.distance = distance;
    this.name = name;
  }

  public int getDistance() {
    return distance;
  }

  public String getName() {
    return name;
  }
}
