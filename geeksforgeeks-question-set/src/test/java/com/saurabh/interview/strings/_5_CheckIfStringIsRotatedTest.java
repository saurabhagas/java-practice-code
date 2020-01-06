package com.saurabh.interview.strings;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class _5_CheckIfStringIsRotatedTest {
  @Test
  public void testRotationInEvenLengthString() {
    _5_CheckIfStringIsRotated checkStringRotated = new _5_CheckIfStringIsRotated();
    boolean checkRotated = checkStringRotated.checkIfStringIsRotated("amazon", "azonam", 2);
    assertThat(checkRotated).isTrue();
  }

  @Test
  public void testRotationInOddLengthString() {
    _5_CheckIfStringIsRotated checkStringRotated = new _5_CheckIfStringIsRotated();
    boolean checkRotated = checkStringRotated.checkIfStringIsRotated("apple", "pplea", 1);
    assertThat(checkRotated).isTrue();
  }

  @Test
  public void testRotationInRandomStringLarge() {
    _5_CheckIfStringIsRotated checkStringRotated = new _5_CheckIfStringIsRotated();
    boolean checkRotated = checkStringRotated.checkIfStringIsRotated("fsbcnuvqhffbsaqxwp", "wpfsbcnuvqhffbsaqx", 2);
    assertThat(checkRotated).isTrue();
  }

  @Test
  public void testRotationInRandomStringSmall() {
    _5_CheckIfStringIsRotated checkStringRotated = new _5_CheckIfStringIsRotated();
    boolean checkRotated = checkStringRotated.checkIfStringIsRotated("amazon", "onamaz", 2);
    assertThat(checkRotated).isTrue();
  }
}
