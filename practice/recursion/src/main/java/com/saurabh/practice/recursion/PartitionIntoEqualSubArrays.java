package com.saurabh.practice.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Check if an array can be partitioned into two sub-arrays such that their sum is equal to the given sum.
 */
public class PartitionIntoEqualSubArrays {
  public static void main(String[] args) {
    partition(new int[] {2, 1, 20, 3, 4, 8}, 20);
  }

  public static void partition(int[] array, int sum) {
    List<Integer> collector = new ArrayList<>();
    // Look for a sub-array of half the given sum, and collect the numbers into a list
    boolean isPossible = partition(array, sum / 2, 0, collector);
    if (isPossible) System.out.println(collector);
    else System.out.println("Not possible");
  }

  private static boolean partition(int[] array, int sum, int index, List<Integer> collector) {
    if (index >= array.length) return false;
    if (sum == 0) return true;
    boolean possibleWithInclusion = partition(array, sum - array[index], index + 1, collector);
    if (possibleWithInclusion) {
      collector.add(array[index]);
      return true;
    }
    // the partition may be possible without including this element. Don't add it in the collector in that case
    return partition(array, sum, index + 1, collector);
  }
}
