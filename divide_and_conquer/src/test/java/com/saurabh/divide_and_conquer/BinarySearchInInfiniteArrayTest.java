package com.saurabh.divide_and_conquer;

import org.junit.Test;

import static com.saurabh.divide_and_conquer.BinarySearchInInfiniteArray.search;
import static java.lang.Integer.MAX_VALUE;
import static org.junit.Assert.assertEquals;

public class BinarySearchInInfiniteArrayTest {
  private static int[] array = new int[]{1, 5, 10, 18, 20, 37, 70, 90, 100, MAX_VALUE, MAX_VALUE, MAX_VALUE, MAX_VALUE,
      MAX_VALUE, MAX_VALUE, MAX_VALUE, MAX_VALUE, MAX_VALUE, MAX_VALUE, MAX_VALUE, MAX_VALUE};

  @Test
  public void testAbsentElement_1() {
    int elementToSearch = 95;
    assertEquals(search(array, elementToSearch), -1);
  }

  @Test
  public void testAbsentElement_2() {
    int elementToSearch = 0;
    assertEquals(search(array, elementToSearch), -1);
  }

  @Test
  public void testAbsentElement_3() {
    int elementToSearch = 110;
    assertEquals(search(array, elementToSearch), -1);
  }

  @Test
  public void testAbsentElement_4() {
    int elementToSearch = 50;
    assertEquals(search(array, elementToSearch), -1);
  }

  @Test
  public void testAbsentElement_5() {
    int elementToSearch = 2;
    assertEquals(search(array, elementToSearch), -1);
  }

  @Test
  public void testPresentElement_1() {
    int elementToSearch = 1;
    assertEquals(search(array, elementToSearch), 0);
  }

  @Test
  public void testPresentElement_2() {
    int elementToSearch = 5;
    assertEquals(search(array, elementToSearch), 1);
  }

  @Test
  public void testPresentElement_3() {
    int elementToSearch = 10;
    assertEquals(search(array, elementToSearch), 2);
  }

  @Test
  public void testPresentElement_4() {
    int elementToSearch = 18;
    assertEquals(search(array, elementToSearch), 3);
  }

  @Test
  public void testPresentElement_5() {
    int elementToSearch = 20;
    assertEquals(search(array, elementToSearch), 4);
  }

  @Test
  public void testPresentElement_6() {
    int elementToSearch = 37;
    assertEquals(search(array, elementToSearch), 5);
  }

  @Test
  public void testPresentElement_7() {
    int elementToSearch = 70;
    assertEquals(search(array, elementToSearch), 6);
  }

  @Test
  public void testPresentElement_8() {
    int elementToSearch = 90;
    assertEquals(search(array, elementToSearch), 7);
  }

  @Test
  public void testPresentElement_9() {
    int elementToSearch = 100;
    assertEquals(search(array, elementToSearch), 8);
  }
}