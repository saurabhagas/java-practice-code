package com.saurabh.divide_and_conquer;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MagicIndexInArrayTest {
  private final MagicIndexInArray obj = new MagicIndexInArray();

  @Test
  public void testWithMagicIndex_1() {
    int[] array = {-1, 0, 2, 5, 7, 9, 11, 12, 19};
    assertThat(obj.search(array)).isEqualTo(2);
  }

  @Test
  public void testWithMagicIndex_2() {
    int[] array = {-100, -10, 0, 1, 2, 4, 5, 7, 19, 20, 100};
    assertThat(obj.search(array)).isEqualTo(7);
  }

  @Test
  public void testWithNoMagicIndex() {
    int[] array = {1, 2, 3, 4, 5};
    assertThat(obj.search(array)).isEqualTo(-1);
  }
}