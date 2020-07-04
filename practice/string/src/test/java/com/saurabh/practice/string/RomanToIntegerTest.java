package com.saurabh.practice.string;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RomanToIntegerTest {
  @Test
  public void testOneDigitRomanToInteger() {
    RomanToInteger romanToInt = new RomanToInteger();
    int intValue = romanToInt.convertRomanToInteger("X");
    assertThat(intValue).isEqualTo(10);
  }

  @Test
  public void testTensDigitRomanToInteger() {
    RomanToInteger romanToInt = new RomanToInteger();
    int intValue = romanToInt.convertRomanToInteger("XIIVIII");
    assertThat(intValue).isEqualTo(18);
  }

  @Test
  public void testHundredsDigitRomanToInteger() {
    RomanToInteger romanToInt = new RomanToInteger();
    int intValue = romanToInt.convertRomanToInteger("CCVXII");
    assertThat(intValue).isEqualTo(207);
  }

  @Test
  public void testThousandsDigitRomanToInteger() {
    RomanToInteger romanToInt = new RomanToInteger();
    int intValue = romanToInt.convertRomanToInteger("MMMDCCXCIV");
    assertThat(intValue).isEqualTo(3794);
  }

  @Test
  public void testEmptyStringRomanToInteger() {
    RomanToInteger romanToInt = new RomanToInteger();
    int intValue = romanToInt.convertRomanToInteger("");
    assertThat(intValue).isEqualTo(0);
  }
}
