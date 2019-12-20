package com.saurabh.interview;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class _4_sortArrayContainingOnly012sTest {
  @Test
  public void sort_1() {
    _4_sortArrayContainingOnly012s obj = new _4_sortArrayContainingOnly012s();
    int[] array = {0};
    obj.sort(array);
    assertArrayEquals(new int[]{0}, array);
  }

  @Test
  public void sort_2() {
    _4_sortArrayContainingOnly012s obj = new _4_sortArrayContainingOnly012s();
    int[] array = {1, 0};
    obj.sort(array);
    assertArrayEquals(new int[]{0, 1}, array);
  }

  @Test
  public void sort_3() {
    _4_sortArrayContainingOnly012s obj = new _4_sortArrayContainingOnly012s();
    int[] array = {0, 1, 2, 1, 0};
    obj.sort(array);
    assertArrayEquals(new int[]{0, 0, 1, 1, 2}, array);
  }
}