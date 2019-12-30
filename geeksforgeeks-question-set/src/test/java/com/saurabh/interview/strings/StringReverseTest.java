package com.saurabh.interview.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringReverseTest {
  @Test
  public void testEmptyString() {
    StringReverse obj = new StringReverse();
    String reversed = obj.reverse("");
    assertEquals("", reversed);
  }

  @Test
  public void testSingletonString() {
    StringReverse obj = new StringReverse();
    String reversed = obj.reverse("1");
    assertEquals("1", reversed);
  }

  @Test
  public void testOddLengthString() {
    StringReverse obj = new StringReverse();
    String reversed = obj.reverse("123");
    assertEquals("321", reversed);
  }

  @Test
  public void testEvenLengthString() {
    StringReverse obj = new StringReverse();
    String reversed = obj.reverse("1234");
    assertEquals("4321", reversed);
  }
}