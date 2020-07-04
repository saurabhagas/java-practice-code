package com.saurabh.practice.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortArrayContainingOnly012STest {
  @Test
  public void sort_1() {
    SortArrayContainingOnly012s obj = new SortArrayContainingOnly012s();
    int[] array = {0};
    obj.sort(array);
    assertArrayEquals(new int[]{0}, array);
  }

  @Test
  public void sort_2() {
    SortArrayContainingOnly012s obj = new SortArrayContainingOnly012s();
    int[] array = {1, 0};
    obj.sort(array);
    assertArrayEquals(new int[]{0, 1}, array);
  }

  @Test
  public void sort_3() {
    SortArrayContainingOnly012s obj = new SortArrayContainingOnly012s();
    int[] array = {0, 1, 2, 1, 0};
    obj.sort(array);
    assertArrayEquals(new int[]{0, 0, 1, 1, 2}, array);
  }
}