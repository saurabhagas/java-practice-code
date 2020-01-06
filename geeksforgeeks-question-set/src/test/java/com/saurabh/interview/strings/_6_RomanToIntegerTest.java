package com.saurabh.interview.strings;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class _6_RomanToIntegerTest {
  @Test
  public void testOneDigitRomanToInteger() {
    _6_RomanToInteger romanToInt = new _6_RomanToInteger();
    int intValue = romanToInt.convertRomanToInteger("X");
    assertThat(intValue).isEqualTo(10);
  }

  @Test
  public void testTensDigitRomanToInteger() {
    _6_RomanToInteger romanToInt = new _6_RomanToInteger();
    int intValue = romanToInt.convertRomanToInteger("XIIVIII");
    assertThat(intValue).isEqualTo(18);
  }

  @Test
  public void testHundredsDigitRomanToInteger() {
    _6_RomanToInteger romanToInt = new _6_RomanToInteger();
    int intValue = romanToInt.convertRomanToInteger("CCVXII");
    assertThat(intValue).isEqualTo(207);
  }

  @Test
  public void testThousandsDigitRomanToInteger() {
    _6_RomanToInteger romanToInt = new _6_RomanToInteger();
    int intValue = romanToInt.convertRomanToInteger("MMMDCCXCIV");
    assertThat(intValue).isEqualTo(3794);
  }

  @Test
  public void testEmptyStringRomanToInteger() {
    _6_RomanToInteger romanToInt = new _6_RomanToInteger();
    int intValue = romanToInt.convertRomanToInteger("");
    assertThat(intValue).isEqualTo(0);
  }
}
