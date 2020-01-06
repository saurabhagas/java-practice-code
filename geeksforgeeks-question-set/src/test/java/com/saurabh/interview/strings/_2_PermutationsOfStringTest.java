package com.saurabh.interview.strings;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class _2_PermutationsOfStringTest {
  @Test
  public void testPermutationsOfStringTwoLetters() {
    _2_PermutationsOfString permutationsOfString = new _2_PermutationsOfString();
    String str = "ab";
    List<String> permutations = permutationsOfString.getAllPermutationsOfString(str);
    assertThat(permutations).containsExactly("ab", "ba");
  }

  @Test
  public void testPermutationsOfStringThreeLetters() {
    _2_PermutationsOfString permutationsOfString = new _2_PermutationsOfString();
    String str = "abc";
    List<String> permutations = permutationsOfString.getAllPermutationsOfString(str);
    assertThat(permutations).containsExactly("abc", "acb", "bac", "bca", "cab", "cba");
  }

  @Test
  public void testPermutationsOfStringFourLetters() {
    _2_PermutationsOfString permutationsOfString = new _2_PermutationsOfString();
    String str = "mnop";
    List<String> permutations = permutationsOfString.getAllPermutationsOfString(str);
    assertThat(permutations).containsExactly("mnop", "mnpo", "monp", "mopn", "mpno", "mpon", "nmop", "nmpo", "nomp", "nopm",
        "npmo", "npom", "omnp", "ompn", "onmp", "onpm", "opmn", "opnm", "pmno", "pmon", "pnmo", "pnom", "pomn", "ponm");
  }
}
