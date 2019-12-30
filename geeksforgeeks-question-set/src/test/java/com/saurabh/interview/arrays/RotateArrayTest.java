package com.saurabh.interview.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotateArrayTest {
  @Test
  public void rotate_1() {
    RotateArray obj = new RotateArray();
    int[] array = {1, 2, 3, 4, 5};
    obj.rotate(1, array);
    assertArrayEquals(new int[]{2, 3, 4, 5, 1}, array);
  }

  @Test
  public void rotate_2() {
    RotateArray obj = new RotateArray();
    int[] array = {1, 2, 3, 4, 5};
    obj.rotate(2, array);
    assertArrayEquals(new int[]{3, 4, 5, 1, 2}, array);
  }

  @Test
  public void rotate_3() {
    RotateArray obj = new RotateArray();
    int[] array = {1, 2, 3, 4, 5};
    obj.rotate(3, array);
    assertArrayEquals(new int[]{4, 5, 1, 2, 3}, array);
  }

  @Test
  public void rotate_4() {
    RotateArray obj = new RotateArray();
    int[] array = {1, 2, 3, 4, 5};
    obj.rotate(4, array);
    assertArrayEquals(new int[]{5, 1, 2, 3, 4}, array);
  }
}