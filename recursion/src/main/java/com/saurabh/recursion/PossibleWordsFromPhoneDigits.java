package com.saurabh.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/java-arraylist-to-print-all-possible-words-from-phone-digits/
 * <p>
 * { 1 }     { 2 }     { 3 }
 * [ABC]     [DEF]     [GHI]
 * <p>
 * { 4 }     { 5 }    { 6 }
 * [JKL]     [MNO]    [PQR]
 * <p>
 * { 7 }     { 8 }    { 9 }
 * [STU]     [VWX]    [YZ]
 */
public class PossibleWordsFromPhoneDigits {
  private static final String[] CODES = {
      "", // Adding empty string for number 0. Doing this makes our indexing easier
      "abc", "def", "ghi",
      "jkl", "mno", "pqr",
      "stu", "vwx", "yz"
  };

  public static void main(String[] args) {
    String str = "123";
    System.out.println(printKeyWords(str));
  }

  private static List<String> printKeyWords(String input) {
    if (input == null || input.isEmpty()) return Collections.singletonList("");
    // Assume that the combinations for N-1 size string have been done, and prepend the current char to those solutions
    return combine(input.charAt(0), printKeyWords(input.substring(1)));
  }

  private static List<String> combine(char ch, List<String> restCombinations) {
    List<String> combinations = new ArrayList<>();
    String code = CODES[ch - '0'];
    for (int i = 0; i < code.length(); i++) {
      for (String restCombination : restCombinations) {
        combinations.add(code.charAt(i) + restCombination);
      }
    }
    return combinations;
  }
}
