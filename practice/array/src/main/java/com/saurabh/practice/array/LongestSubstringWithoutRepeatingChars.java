package com.saurabh.practice.array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {
  public static void main(String[] args) {
    LongestSubstringWithoutRepeatingChars obj = new LongestSubstringWithoutRepeatingChars();
    System.out.println(obj.lengthOfLongestSubstring("abcabcbb")); // 3
    System.out.println(obj.lengthOfLongestSubstring("bbtablud")); // 6
  }

  public int lengthOfLongestSubstring(String s) {
    int left = 0, right = 0;
    Map<Character, Integer> charToPos = new HashMap<>();
    int max = 0;
    int currMax = 0;
    while (right < s.length()) {
      char ch = s.charAt(right);
      Integer pos = charToPos.get(ch);
      charToPos.put(ch, right);

      if (pos == null || pos < left) {
        currMax++;
      } else {
        currMax = currMax - (pos - left);
        left = pos + 1;
      }
      right++;
      max = Math.max(max, currMax);
    }
    return max;
  }
}