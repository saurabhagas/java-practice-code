package com.saurabh.practice.array;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class GreaterPairPowerTest {
  @Test
  public void testEvenArray() {
    GreaterPairPower greaterPairPower = new GreaterPairPower();
    int[] X = {2, 6};
    int[] Y = {5, 1};
    int count = greaterPairPower.getGreaterPairPower(X, Y);
    assertThat(count).isEqualTo(3);
  }

  @Test
  public void testOddArray() {
    GreaterPairPower greaterPairPower = new GreaterPairPower();
    int[] X = {2, 1, 6};
    int[] Y = {5, 1};
    int count = greaterPairPower.getGreaterPairPower(X, Y);
    assertThat(count).isEqualTo(3);
  }

  @Test
  public void testBothArraysEqual() {
    GreaterPairPower greaterPairPower = new GreaterPairPower();
    int[] X = {2, 1};
    int[] Y = {1, 2};
    int count = greaterPairPower.getGreaterPairPower(X, Y);
    assertThat(count).isEqualTo(1);
  }

  @Test
  public void testBothArraysEqualAndRepeatingElements() {
    GreaterPairPower greaterPairPower = new GreaterPairPower();
    int[] X = {2, 1, 2, 1};
    int[] Y = {1, 2, 1, 2};
    int count = greaterPairPower.getGreaterPairPower(X, Y);
    assertThat(count).isEqualTo(4);
  }

  @Test
  public void testEmptyXArray() {
    GreaterPairPower greaterPairPower = new GreaterPairPower();
    int[] X = new int[]{};
    int[] Y = {1, 2, 4, 3};
    assertThatIllegalArgumentException().isThrownBy(() -> {
      greaterPairPower.getGreaterPairPower(X, Y);
    });
  }
}
