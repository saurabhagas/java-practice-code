package com.saurabh.interview;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class _1_AnagramStringsTest {
  @Test
  public void testSmallAnagrams() {
    _1_AnagramStrings obj = new _1_AnagramStrings("one", "eno");
    assertTrue(obj.areAnagrams());
  }

  @Test
  public void testSmallNonAnagrams_1() {
    _1_AnagramStrings obj = new _1_AnagramStrings("One", "Two");
    assertFalse(obj.areAnagrams());
  }

  @Test
  public void testSmallNonAnagrams_2() {
    _1_AnagramStrings obj = new _1_AnagramStrings("One", "one");
    assertFalse(obj.areAnagrams());
  }

  @Test
  public void testSmallNonAnagrams_3() {
    _1_AnagramStrings obj = new _1_AnagramStrings("One", "");
    assertFalse(obj.areAnagrams());
  }

  @Test
  public void testSmallNonAnagrams_4() {
    _1_AnagramStrings obj = new _1_AnagramStrings("One", "OneOne");
    assertFalse(obj.areAnagrams());
  }

  @Test
  public void testSmallNonAnagrams_5() {
    _1_AnagramStrings obj = new _1_AnagramStrings("OneOne", "One");
    assertFalse(obj.areAnagrams());
  }

  @Test
  public void testMediumAnagrams() {
    _1_AnagramStrings obj = new _1_AnagramStrings("Geeksforgeeks", "foreeksgGeeks");
    assertTrue(obj.areAnagrams());
  }

  @Test
  public void testMediumNonAnagrams() {
    _1_AnagramStrings obj = new _1_AnagramStrings("Geeksforgeeks", "foreeksggeeks");
    assertFalse(obj.areAnagrams());
  }

  @Test
  public void testLongAnagrams() {
    _1_AnagramStrings obj = new _1_AnagramStrings("hydroxydeoxycorticosterones", "hydroxydesoxycorticosterone");
    assertTrue(obj.areAnagrams());
  }

  @Test
  public void testVeryLongAnagrams() {
    _1_AnagramStrings obj = new _1_AnagramStrings("hydroxydeoxycorticosteronesabcdefghijklmnopqrstuzwxyz1234567890", "abcdefghijklmnopqrstuzwxyz1234567890hydroxydesoxycorticosterone");
    assertTrue(obj.areAnagrams());
  }
}