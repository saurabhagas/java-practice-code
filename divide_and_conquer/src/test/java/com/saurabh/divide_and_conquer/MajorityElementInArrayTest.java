package com.saurabh.divide_and_conquer;

import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class MajorityElementInArrayTest {
  private final MajorityElementInArray obj = new MajorityElementInArray();

  @Test
  public void testWithSimpleArray() {
    int[] array = {1, 2, 3, 4, 3, 3, 3, 3, 3, 3, 3, 4, 7, 7, 1};
    assertThat(obj.find(array).get()).isEqualTo(3);
  }

  @Test
  public void testWithMajorityElementAtTheBeginning() {
    int[] array = {3, 3, 3, 3, 3, 3, 3, 3, 7, 7, 1, 1, 2, 10, 4};
    assertThat(obj.find(array).get()).isEqualTo(3);
  }

  @Test
  public void testWithAlternatingNumbers() {
    int[] array = {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 2};
    assertThat(obj.find(array).get()).isEqualTo(2);
  }

  @Test
  public void testWithNoMajorityElement() {
    int[] array = {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2};
    assertThat(obj.find(array)).isEqualTo(Optional.empty());
  }
}