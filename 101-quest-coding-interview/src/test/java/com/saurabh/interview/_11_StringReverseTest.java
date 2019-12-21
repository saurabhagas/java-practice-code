package com.saurabh.interview;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _11_StringReverseTest {
  @Test
  public void testEmptyString() {
    _11_StringReverse obj = new _11_StringReverse();
    String reversed = obj.reverse("");
    assertEquals("", reversed);
  }

  @Test
  public void testSingletonString() {
    _11_StringReverse obj = new _11_StringReverse();
    String reversed = obj.reverse("1");
    assertEquals("1", reversed);
  }

  @Test
  public void testOddLengthString() {
    _11_StringReverse obj = new _11_StringReverse();
    String reversed = obj.reverse("123");
    assertEquals("321", reversed);
  }

  @Test
  public void testEvenLengthString() {
    _11_StringReverse obj = new _11_StringReverse();
    String reversed = obj.reverse("1234");
    assertEquals("4321", reversed);
  }
}