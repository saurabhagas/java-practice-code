package com.saurabh.common;

public class City {
  private int distance;
  private String name;

  public City(int distance, String name) {
    this.distance = distance;
    this.name = name;
  }

  public int getDistance() {
    return distance;
  }

  public void setDistance(int distance) {
    this.distance = distance;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
