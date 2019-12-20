package com.saurabh.interview;

/*
 Problem - check if two strings are anagrams of each other. Problem at: https://leetcode.com/problems/valid-anagram/
 Approach - Use hashmaps to store counts of characters.
 Approach 2 - Simple sorting based O(nlogn) solution at: https://www.youtube.com/watch?v=SQRqy7hrLJI
*/

import java.util.HashMap;

import static java.util.Objects.requireNonNull;

public class _1_AnagramStrings {
  private final String first;
  private final String second;

  public _1_AnagramStrings(String first, String second) {
    this.first = requireNonNull(first);
    this.second = requireNonNull(second);
  }

  public boolean areAnagrams() {
    if (second.length() != first.length()) {
      return false;
    }

    HashMap<Character, Integer> map = new HashMap<>(3);
    for (char ch : first.toCharArray()) {
      Integer value = map.get(ch);
      if (value == null) {
        map.put(ch, 1);
      } else {
        map.put(ch, ++value);
      }
    }

    for (char ch : second.toCharArray()) {
      Integer value = map.get(ch);
      if (value != null) {
        map.put(ch, --value);
      }
    }

    for (Integer integer : map.values()) {
      if (integer != 0) {
        return false;
      }
    }
    return true;
  }
}