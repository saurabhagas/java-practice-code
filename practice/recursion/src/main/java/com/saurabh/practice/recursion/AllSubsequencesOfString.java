package com.saurabh.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class AllSubsequencesOfString {
  public static void main(String[] args) {
    System.out.println(allSubsequences("abc", 0));
  }

  public static List<String> allSubsequences(String str, int index) {
    if (index == str.length()) {
      List<String> combinations = new ArrayList<>();
      combinations.add("");
      return combinations;
    }

    List<String> combos = allSubsequences(str, index + 1);
    List<String> combosWithCurrentElement = new ArrayList<>();

    for (String combo : combos) {
      combosWithCurrentElement.add(combo);
      combosWithCurrentElement.add(str.charAt(index) + combo);
    }
    return combosWithCurrentElement;
  }
}
