package com.saurabh.practice.backtracking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {
  public static void main(String[] args) {
    CombinationSum obj = new CombinationSum();
    int[] array = {10, 1, 2, 7, 6, 1, 5};
    System.out.println(obj.combinationSum2(array, 8));
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Set<List<Integer>> sets = new HashSet<>();
    permutations(candidates, 0, 0, sets, target);
    return new ArrayList<>(sets);
  }

  private void permutations(int[] array, int pos, int sumSoFar, Set<List<Integer>> sets, int target) {
    if (sumSoFar > target) return;
    if (sumSoFar == target) {
      List<Integer> current = new ArrayList<>();
      for (int i = 0; i < pos; i++) {
        current.add(array[i]);
      }
      current.sort(Comparator.naturalOrder()); // TODO[Saurabh]: This step is expensive - compute combinations directly
      sets.add(current);
      return;
    }

    for (int i = pos; i < array.length; i++) {
      swap(array, i, pos);
      permutations(array, pos + 1, sumSoFar + array[pos], sets, target);
      swap(array, i, pos);
    }
  }

  private void swap(int[] input, int first, int second) {
    if (first == second) return;
    int temp = input[first];
    input[first] = input[second];
    input[second] = temp;
  }
}
