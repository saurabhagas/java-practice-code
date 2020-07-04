package com.saurabh.practice.array;

import java.util.Arrays;

/**
 * Problem - Given arrival and departure times of all trains that reach a railway station. Your task is to find the minimum number of platforms required for the railway station so that no train waits.
 * Note: Consider that all the trains arrive on the same day and leave on the same day. Also, arrival and departure times will not be same for a train, but we can have arrival time of one train equal to departure of the other.
 * In such cases, we need different platforms, i.e at any given instance of time, same platform can not be used for both departure of a train and arrival of another.
 *
 * Approach - O(n log n)
 * Sort both arrays of arrival and departure times. If the arrival time of next train is before the departure time of the previous train then we have to add a new platform.
 * If the arrival time of the next train is after the departure time of the previous train then we decrease the platforms.
 * For more explanation: https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 */
public class MinimumPlatforms {
  public int getMinimumPlatforms(int[] arrival, int[] departure) {
    int platforms = 1, result = 1;
    Arrays.sort(arrival);
    Arrays.sort(departure);
    int i = 1, j = 0;
    while (i < arrival.length && j < departure.length) {
      //If the train is scheduled to arrive next then we increase the platform count
      if (arrival[i] <= departure[j]) {
        platforms++;
        i++;
        if (platforms > result) {
          result = platforms;
        }

      } else {
        //If the train is scheduled to depart next then we decrease the platform count
        platforms--;
        j++;
      }
    }
    return result;
  }
}
