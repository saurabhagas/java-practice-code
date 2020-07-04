package com.saurabh.practice.string;

import java.util.HashMap;

/*
 Problem - check if two strings are anagrams of each other. Problem at: https://leetcode.com/problems/valid-anagram/
 Approach - Use hashmaps to store counts of characters. O(n) time with O(1) space
*/

import static java.util.Objects.requireNonNull;

public class AnagramStrings {
  private final String first;
  private final String second;

  public AnagramStrings(String first, String second) {
    this.first = requireNonNull(first);
    this.second = requireNonNull(second);
  }

  public boolean areAnagrams() {
    if (second.length() != first.length()) {
      return false;
    }

    HashMap<Character, Integer> map = new HashMap<>(26); // This is O(1) space
    for (char ch : first.toCharArray()) {
      map.put(ch, map.getOrDefault(ch, 0) + 1);
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