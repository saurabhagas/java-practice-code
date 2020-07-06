package com.saurabh.practice.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubstrings {
  public static void main(String[] args) {
    FindSubstrings s = new FindSubstrings();
    List<String> output = s.findSubstrings("bbeadcxede");
    System.out.println(output.toString());
  }

  public List<String> findSubstrings(String input) {
    Map<Character, List<Integer>> indexes = new HashMap<Character, List<Integer>>();
    int i = 0;
    for (char ch : input.toCharArray()) {
      List<Integer> list = indexes.getOrDefault(ch, new ArrayList<Integer>());
      list.add(i);
      indexes.put(ch, list);
      i++;
    }

    List<String> substrings = new ArrayList<String>();
    StringBuilder subStr = new StringBuilder();
    for (int curr = 0; curr < input.length(); curr++) {
      boolean hasCon = hasConsecutive(input, curr);
      if (hasCon && indexes.get(input.charAt(curr)).size() > 1) {
        subStr.append(input.charAt(curr));
      } else if (!hasCon && indexes.get(input.charAt(curr)).size() == 1) {
        subStr.append(input.charAt(curr));
        substrings.add(subStr.toString());
        subStr.setLength(0);
      } else if (subStr.length() > 0) {
        substrings.add(subStr.toString());
        subStr.setLength(0);
      }

    }
    return substrings;
  }

  private boolean hasConsecutive(String input, int curr) {
    if (curr == 0) {
      return input.charAt(curr) == input.charAt(curr + 1);
    } else if (curr == input.length() - 1) {
      return input.charAt(curr) == input.charAt(curr - 1);
    } else {
      return input.charAt(curr) == input.charAt(curr + 1) || input.charAt(curr) == input.charAt(curr - 1);
    }
  }
}
