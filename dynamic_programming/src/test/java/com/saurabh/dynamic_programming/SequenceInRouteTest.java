package com.saurabh.dynamic_programming;

import com.saurabh.common.City;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SequenceInRouteTest {
  @Test
  public void testSequenceInRoute1() {
    int[] a = new int[]{0, 50, 150, 300, 450, 500};
    SequenceInRoute sequenceInRoute = new SequenceInRoute();
    List<City> cityList = initNodeList(a);
    List<City> route = sequenceInRoute.getRoute(cityList);
    assertThat(route).containsSubsequence(cityList.get(0), cityList.get(2), cityList.get(3), cityList.get(5));
  }

  @Test
  public void testSequenceInRoute2() {
    int[] a = new int[]{0, 50, 100, 220, 350, 580};
    SequenceInRoute sequenceInRoute = new SequenceInRoute();
    List<City> cityList = initNodeList(a);
    List<City> route = sequenceInRoute.getRoute(cityList);
    assertThat(route).containsSequence(cityList.get(0), cityList.get(3), cityList.get(4), cityList.get(5));
  }

  @Test
  public void testSequenceInRoute3() {
    int[] a = new int[]{0, 50, 100, 150, 200, 250, 300, 350, 400, 450, 500};
    SequenceInRoute sequenceInRoute = new SequenceInRoute();
    List<City> cityList = initNodeList(a);
    List<City> route = sequenceInRoute.getRoute(cityList);
    assertThat(route).containsSequence(cityList.get(0), cityList.get(5), cityList.get(10));
  }

  private List<City> initNodeList(int[] distances) {
    List<City> cityDistances = new LinkedList<>();
    int count = 0;
    for (int distance : distances) {
      cityDistances.add(new City(distance, "City" + count));
      count++;
    }
    return cityDistances;
  }
}
