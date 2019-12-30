package com.saurabh.interview.arrays;

import com.saurabh.interview.arrays._9_sortArrayContainingOnly012s;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class _9_sortArrayContainingOnly012sTest {
  @Test
  public void sort_1() {
    _9_sortArrayContainingOnly012s obj = new _9_sortArrayContainingOnly012s();
    int[] array = {0};
    obj.sort(array);
    assertArrayEquals(new int[]{0}, array);
  }

  @Test
  public void sort_2() {
    _9_sortArrayContainingOnly012s obj = new _9_sortArrayContainingOnly012s();
    int[] array = {1, 0};
    obj.sort(array);
    assertArrayEquals(new int[]{0, 1}, array);
  }

  @Test
  public void sort_3() {
    _9_sortArrayContainingOnly012s obj = new _9_sortArrayContainingOnly012s();
    int[] array = {0, 1, 2, 1, 0};
    obj.sort(array);
    assertArrayEquals(new int[]{0, 0, 1, 1, 2}, array);
  }
}