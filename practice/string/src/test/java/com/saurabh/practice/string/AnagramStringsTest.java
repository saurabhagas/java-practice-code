package com.saurabh.practice.string;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnagramStringsTest {
  @Test
  public void testSmallAnagrams() {
    AnagramStrings obj = new AnagramStrings("one", "eno");
    assertTrue(obj.areAnagrams());
  }

  @Test
  public void testSmallNonAnagrams_1() {
    AnagramStrings obj = new AnagramStrings("One", "Two");
    assertFalse(obj.areAnagrams());
  }

  @Test
  public void testSmallNonAnagrams_2() {
    AnagramStrings obj = new AnagramStrings("One", "one");
    assertFalse(obj.areAnagrams());
  }

  @Test
  public void testSmallNonAnagrams_3() {
    AnagramStrings obj = new AnagramStrings("One", "");
    assertFalse(obj.areAnagrams());
  }

  @Test
  public void testSmallNonAnagrams_4() {
    AnagramStrings obj = new AnagramStrings("One", "OneOne");
    assertFalse(obj.areAnagrams());
  }

  @Test
  public void testSmallNonAnagrams_5() {
    AnagramStrings obj = new AnagramStrings("OneOne", "One");
    assertFalse(obj.areAnagrams());
  }

  @Test
  public void testMediumAnagrams() {
    AnagramStrings obj = new AnagramStrings("Geeksforgeeks", "foreeksgGeeks");
    assertTrue(obj.areAnagrams());
  }

  @Test
  public void testMediumNonAnagrams() {
    AnagramStrings obj = new AnagramStrings("Geeksforgeeks", "foreeksggeeks");
    assertFalse(obj.areAnagrams());
  }

  @Test
  public void testLongAnagrams() {
    AnagramStrings obj = new AnagramStrings("hydroxydeoxycorticosterones", "hydroxydesoxycorticosterone");
    assertTrue(obj.areAnagrams());
  }

  @Test
  public void testVeryLongAnagrams() {
    AnagramStrings obj = new AnagramStrings("hydroxydeoxycorticosteronesabcdefghijklmnopqrstuzwxyz1234567890", "abcdefghijklmnopqrstuzwxyz1234567890hydroxydesoxycorticosterone");
    assertTrue(obj.areAnagrams());
  }
}