package com.saurabh.practice.string;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CheckIfStringIsRotatedTest {
  @Test
  public void testRotationInEvenLengthString() {
    CheckIfStringIsRotated checkStringRotated = new CheckIfStringIsRotated();
    boolean checkRotated = checkStringRotated.checkIfStringIsRotated("amazon", "azonam", 2);
    assertThat(checkRotated).isTrue();
  }

  @Test
  public void testRotationInOddLengthString() {
    CheckIfStringIsRotated checkStringRotated = new CheckIfStringIsRotated();
    boolean checkRotated = checkStringRotated.checkIfStringIsRotated("apple", "pplea", 1);
    assertThat(checkRotated).isTrue();
  }

  @Test
  public void testRotationInRandomStringLarge() {
    CheckIfStringIsRotated checkStringRotated = new CheckIfStringIsRotated();
    boolean checkRotated = checkStringRotated.checkIfStringIsRotated("fsbcnuvqhffbsaqxwp", "wpfsbcnuvqhffbsaqx", 2);
    assertThat(checkRotated).isTrue();
  }

  @Test
  public void testRotationInRandomStringSmall() {
    CheckIfStringIsRotated checkStringRotated = new CheckIfStringIsRotated();
    boolean checkRotated = checkStringRotated.checkIfStringIsRotated("amazon", "onamaz", 2);
    assertThat(checkRotated).isTrue();
  }
}
