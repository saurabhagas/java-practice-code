package com.saurabh.interview.strings;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class _7_AnagramStringsTest {
  @Test
  public void testSmallAnagrams() {
    _7_AnagramStrings obj = new _7_AnagramStrings("one", "eno");
    assertTrue(obj.areAnagrams());
  }

  @Test
  public void testSmallNonAnagrams_1() {
    _7_AnagramStrings obj = new _7_AnagramStrings("One", "Two");
    assertFalse(obj.areAnagrams());
  }

  @Test
  public void testSmallNonAnagrams_2() {
    _7_AnagramStrings obj = new _7_AnagramStrings("One", "one");
    assertFalse(obj.areAnagrams());
  }

  @Test
  public void testSmallNonAnagrams_3() {
    _7_AnagramStrings obj = new _7_AnagramStrings("One", "");
    assertFalse(obj.areAnagrams());
  }

  @Test
  public void testSmallNonAnagrams_4() {
    _7_AnagramStrings obj = new _7_AnagramStrings("One", "OneOne");
    assertFalse(obj.areAnagrams());
  }

  @Test
  public void testSmallNonAnagrams_5() {
    _7_AnagramStrings obj = new _7_AnagramStrings("OneOne", "One");
    assertFalse(obj.areAnagrams());
  }

  @Test
  public void testMediumAnagrams() {
    _7_AnagramStrings obj = new _7_AnagramStrings("Geeksforgeeks", "foreeksgGeeks");
    assertTrue(obj.areAnagrams());
  }

  @Test
  public void testMediumNonAnagrams() {
    _7_AnagramStrings obj = new _7_AnagramStrings("Geeksforgeeks", "foreeksggeeks");
    assertFalse(obj.areAnagrams());
  }

  @Test
  public void testLongAnagrams() {
    _7_AnagramStrings obj = new _7_AnagramStrings("hydroxydeoxycorticosterones", "hydroxydesoxycorticosterone");
    assertTrue(obj.areAnagrams());
  }

  @Test
  public void testVeryLongAnagrams() {
    _7_AnagramStrings obj = new _7_AnagramStrings("hydroxydeoxycorticosteronesabcdefghijklmnopqrstuzwxyz1234567890", "abcdefghijklmnopqrstuzwxyz1234567890hydroxydesoxycorticosterone");
    assertTrue(obj.areAnagrams());
  }
}