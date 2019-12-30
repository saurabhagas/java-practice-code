package com.saurabh.interview.arrays;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class _6_RearrangeArraysAlternatelyTest {
  @Test
  public void testEvenSequentialArray() {
    _6_RearrangeArraysAlternately rearrangeArraysAlternately = new _6_RearrangeArraysAlternately();
    int[] array = new int[]{1, 2, 3, 4, 5, 6};
    rearrangeArraysAlternately.getRearrangedArray(array);
    assertThat(array).containsSequence(6, 1, 5, 2, 4, 3);
  }

  @Test
  public void testOddSequentialArray() {
    _6_RearrangeArraysAlternately rearrangeArraysAlternately = new _6_RearrangeArraysAlternately();
    int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
    rearrangeArraysAlternately.getRearrangedArray(array);
    assertThat(array).containsSequence(7, 1, 6, 2, 5, 3, 4);
  }

  @Test
  public void testEvenRandomArray() {
    _6_RearrangeArraysAlternately rearrangeArraysAlternately = new _6_RearrangeArraysAlternately();
    int[] array = new int[]{9, 3, 8, 5, 2, 1};
    rearrangeArraysAlternately.getRearrangedArray(array);
    assertThat(array).containsSequence(9, 1, 8, 2, 5, 3);
  }

  @Test
  public void testOddRandomArray() {
    _6_RearrangeArraysAlternately rearrangeArraysAlternately = new _6_RearrangeArraysAlternately();
    int[] array = new int[]{55, 78, 23, 54, 12, 98, 34};  //12 23 34 54 55 78 98
    rearrangeArraysAlternately.getRearrangedArray(array);
    assertThat(array).containsSequence(98, 12, 78, 23, 55, 34, 54);
  }

  @Test
  public void testEmptyArray() {
    _6_RearrangeArraysAlternately rearrangeArraysAlternately = new _6_RearrangeArraysAlternately();
    int[] array = new int[]{};
    assertThatIllegalArgumentException().isThrownBy(() -> {
      rearrangeArraysAlternately.getRearrangedArray(array);
    });
  }
}
