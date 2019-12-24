package com.saurabh.dynamic_programming;

import com.saurabh.common.City;

import java.util.LinkedList;
import java.util.List;

/**
 * DPV Problem 6.2
 * You are going on a long trip. You start on the road at mile post 0. Along the way there are n
 * hotels, at mile posts a1 < a2 < ... < an, where each ai is measured from the starting point. The
 * only places you are allowed to stop are at these hotels, but you can choose which of the hotels
 * you stop at. You must stop at the final hotel (at distance an), which is your destination.
 * You'd ideally like to travel 200 miles a day, but this may not be possible (depending on the spacing
 * of the hotels). If you travel x miles during a day, the penalty for that day is (200 - x)^2. You want
 * to plan your trip so as to minimize the total penalty - that is, the sum, over all travel days, of the
 * daily penalties.
 * Give an efficient algorithm that determines the optimal sequence of hotels at which to stop.
 */

public class SequenceInRoute {

  private final int MAX_VALUE = 400000000;

  public List<City> getRoute(List<City> cityNodesList) {

    if(cityNodesList == null) {
      throw new NullPointerException("No nodes in the list of cities");
    }
    int[] distanceArray = new int[cityNodesList.size()];
    List<City> routeSequence = new LinkedList<City>();
    int count = 0;
    for(City node : cityNodesList) {
      distanceArray[count] = node.getDistance();
      count++;
    }

    if(distanceArray.length > 0) {
      int[] penaltyArray = new int[distanceArray.length];
      int[] route = new int[distanceArray.length];
      penaltyArray[0] = 0;
      route[0] = 0;
      for (int i = 1; i < distanceArray.length; i++) {
        int min = MAX_VALUE;
        int prev = 0;
        for (int j = 0; j < i; j++) {
          int currentPenalty = penaltyArray[j] + (int) Math.pow((200 - (distanceArray[i] - distanceArray[j])), 2);
          if (currentPenalty < min) {
            min = currentPenalty;
            prev = j;
          }
        }
        penaltyArray[i] = min;
        route[i] = prev;
      }


      int prev = distanceArray.length - 1;
      while (prev != 0) {
        routeSequence.add(0, cityNodesList.get(prev));
        prev = route[prev];
      }
      routeSequence.add(0, cityNodesList.get(prev));

    }
    return routeSequence;
  }


}
