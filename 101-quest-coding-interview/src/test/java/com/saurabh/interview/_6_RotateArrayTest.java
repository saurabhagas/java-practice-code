package com.saurabh.interview;

import org.junit.Test;

import static org.junit.Assert.*;

public class _6_RotateArrayTest {
  @Test
  public void rotate_1() {
    _6_RotateArray obj = new _6_RotateArray();
    int[] array = {1, 2, 3, 4, 5};
    obj.rotate(1, array);
    assertArrayEquals(new int[]{2, 3, 4, 5, 1}, array);
  }

  @Test
  public void rotate_2() {
    _6_RotateArray obj = new _6_RotateArray();
    int[] array = {1, 2, 3, 4, 5};
    obj.rotate(2, array);
    assertArrayEquals(new int[]{3, 4, 5, 1, 2}, array);
  }

  @Test
  public void rotate_3() {
    _6_RotateArray obj = new _6_RotateArray();
    int[] array = {1, 2, 3, 4, 5};
    obj.rotate(3, array);
    assertArrayEquals(new int[]{4, 5, 1, 2, 3}, array);
  }

  @Test
  public void rotate_4() {
    _6_RotateArray obj = new _6_RotateArray();
    int[] array = {1, 2, 3, 4, 5};
    obj.rotate(4, array);
    assertArrayEquals(new int[]{5, 1, 2, 3, 4}, array);
  }
}