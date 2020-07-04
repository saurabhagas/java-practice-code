package com.saurabh.practice.famous_algorithms.sliding_window;

import java.util.HashMap;
import java.util.Map;

/*
  Problem: Longest substring with atmost k distinct characters.
  Approach: Use a sliding window of size k distinct characters. Always grow window rightwards. Shrink it from left if
  distinct letter count exceeds k. Explanation at: https://www.youtube.com/watch?v=MK-NZ4hN7rs
  Complexity: O(n) time and O(k) space
 */
public class LongestSubstringWithKDistinctLetters {
  public static void main(String[] args) {
    LongestSubstringWithKDistinctLetters obj = new LongestSubstringWithKDistinctLetters();
    System.out.println(obj.calculate("AAAHHIBC", 2));
    System.out.println(obj.calculate("HHIBCAAA", 3));
  }

  public int calculate(String input, int k) {
    int maxLength = 0;
    Map<Character, Integer> charFrequencies = new HashMap<>();
    char[] chars = input.toCharArray();
    int windowLeft = 0;
    int windowRight = 0;
    for (char ch : chars) {
      charFrequencies.put(ch, charFrequencies.getOrDefault(ch, 0) + 1);
      if (charFrequencies.keySet().size() > k) {
        while (charFrequencies.keySet().size() != k) {
          Integer oldFrequency = charFrequencies.get(chars[windowLeft]);
          if (oldFrequency == 1) {
            charFrequencies.remove(chars[windowLeft]);
          } else {
            charFrequencies.put(chars[windowLeft], oldFrequency - 1);
          }
          windowLeft++;
        }
      }

      windowRight++;
      int currLength = windowRight - windowLeft;
      if (maxLength < currLength) {
        maxLength = currLength;
      }
    }
    return maxLength;
  }
}
