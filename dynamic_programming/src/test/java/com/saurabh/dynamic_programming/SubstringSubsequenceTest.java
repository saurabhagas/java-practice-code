package com.saurabh.dynamic_programming;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubstringSubsequenceTest {

  @Test
  public void testSimpleSubstringSubsequence() {
    String x = "abdbabfgd";
    String y = "betfdbfafr";
    SubstringSubsequence contiguousSubstrSubseq = new SubstringSubsequence();
    char[] S = contiguousSubstrSubseq.getContiguousSubstringSubsequence(x, y);
    assertThat(S).containsExactly(new char[]{'b', 'd', 'b', 'a'});
  }

  @Test
  public void testEmptySubstringSubsequence1() {
    String x = "";
    String y = "";
    SubstringSubsequence contiguousSubstrSubseq = new SubstringSubsequence();
    char[] S = contiguousSubstrSubseq.getContiguousSubstringSubsequence(x, y);
    assertThat(S).containsExactly(new char[]{});
  }

  @Test
  public void testEmptySubstringSubsequence2() {
    String x = "abdbabfgd";
    String y = "";
    SubstringSubsequence contiguousSubstrSubseq = new SubstringSubsequence();
    char[] S = contiguousSubstrSubseq.getContiguousSubstringSubsequence(x, y);
    assertThat(S).containsExactly(new char[]{});
  }

  @Test
  public void testEmptySubstringSubsequence3() {
    String x = "";
    String y = "betfdbfafr";
    SubstringSubsequence contiguousSubstrSubseq = new SubstringSubsequence();
    char[] S = contiguousSubstrSubseq.getContiguousSubstringSubsequence(x, y);
    assertThat(S).containsExactly(new char[]{});
  }

  @Test
  public void testNullSubstringSubsequence() {
    String x = null;
    String y = null;
    SubstringSubsequence contiguousSubstrSubseq = new SubstringSubsequence();
    char[] S = contiguousSubstrSubseq.getContiguousSubstringSubsequence(x, y);
    assertThat(S).containsExactly(new char[]{});
  }

  @Test
  public void testSubstringSubsequence1() {
    String x = "aaaabbbb";
    String y = "rtyeiaduaoa";
    SubstringSubsequence contiguousSubstrSubseq = new SubstringSubsequence();
    char[] S = contiguousSubstrSubseq.getContiguousSubstringSubsequence(x, y);
    assertThat(S).containsExactly(new char[]{'a', 'a', 'a'});
  }

  @Test
  public void testSubstringSubsequence2() {
    String x = "aaaabbbbaaab";
    String y = "rtybeiaduaoab";
    SubstringSubsequence contiguousSubstrSubseq = new SubstringSubsequence();
    char[] S = contiguousSubstrSubseq.getContiguousSubstringSubsequence(x, y);
    assertThat(S).containsExactly(new char[]{'b', 'a', 'a', 'a', 'b'});
  }

  @Test
  public void testSubstringSubsequenceNoSub() {
    String x = "aaaabbbbaaab";
    String y = "rtyweiuducov";
    SubstringSubsequence contiguousSubstrSubseq = new SubstringSubsequence();
    char[] S = contiguousSubstrSubseq.getContiguousSubstringSubsequence(x, y);
    assertThat(S).containsExactly(new char[]{});
  }

  @Test
  public void testSubstringSubsequenceAllSub() {
    String x = "aaaaa";
    String y = "aaaaa";
    SubstringSubsequence contiguousSubstrSubseq = new SubstringSubsequence();
    char[] S = contiguousSubstrSubseq.getContiguousSubstringSubsequence(x, y);
    assertThat(S).containsExactly(new char[]{'a', 'a', 'a', 'a', 'a'});
  }

  @Test
  public void testSubstringSubsequenceBeginning() {
    String x = "aabbbbbtrewuqdv";
    String y = "aaxxxbbbbbyyyytrewioijnuqjkjbkjvuiguyfuyd";
    SubstringSubsequence contiguousSubstrSubseq = new SubstringSubsequence();
    char[] S = contiguousSubstrSubseq.getContiguousSubstringSubsequence(x, y);
    assertThat(S).containsExactly(new char[]{'a', 'a', 'b', 'b', 'b', 'b', 'b', 't', 'r', 'e', 'w', 'u', 'q', 'd'});
  }

}
