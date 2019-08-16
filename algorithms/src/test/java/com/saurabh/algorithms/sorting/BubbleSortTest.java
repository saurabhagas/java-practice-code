package com.saurabh.algorithms.sorting;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class BubbleSortTest {
  @Test
  public void sortTest() {
    Integer[] array = new Integer[]{9, 5, 10, 0, 6, 11, -1, 1, 2};
    Integer[] sortedArray = (Integer[]) new BubbleSorter<>().sort(array);
    assertThat(sortedArray.length).isEqualTo(9);
    assertThat(Arrays.equals(sortedArray, new Integer[]{-1, 0, 1, 2, 5, 6, 9, 10, 11}));
  }

  @Test
  public void sortNullArrayTest() {
    BubbleSorter<Integer> bSort = new BubbleSorter<>();
    assertThatNullPointerException().isThrownBy(() -> bSort.sort(null));
  }

  @Test
  public void sortCustomClass() {
    CustomInt[] array = new CustomInt[5];
    array[0] = new CustomInt(4);
    array[1] = new CustomInt(1);
    array[2] = new CustomInt(3);
    array[3] = new CustomInt(5);
    array[4] = new CustomInt(2);

    CustomInt[] answerArray = new CustomInt[5];
    answerArray[0] = new CustomInt(1);
    answerArray[1] = new CustomInt(2);
    answerArray[2] = new CustomInt(3);
    answerArray[3] = new CustomInt(4);
    answerArray[4] = new CustomInt(5);

    BubbleSorter<CustomInt> bSort = new BubbleSorter<>();
    CustomInt[] sortedArray = bSort.sort(array);
    assertThat(sortedArray.length).isEqualTo(5);
    assertThat(Arrays.equals(sortedArray, answerArray));
  }

  @Test
  public void oneElementTest() {
    Integer[] array = new Integer[]{1};
    BubbleSorter<Integer> bSort = new BubbleSorter<>();
    Integer[] sortedArray = bSort.sort(array);
    assertThat(sortedArray.length).isEqualTo(1);
    assertThat(sortedArray).containsOnly(1);
  }

  @Test
  public void twoElementTest() {
    Integer[] array = new Integer[]{1, 0};
    BubbleSorter<Integer> bSort = new BubbleSorter<>();
    Integer[] sortedArray = bSort.sort(array);
    assertThat(sortedArray.length).isEqualTo(2);
    assertThat(sortedArray).containsOnly(0, 1);
  }

  @Test
  public void threeElementTest() {
    Integer[] array = new Integer[]{0, -1, 10};
    BubbleSorter<Integer> bSort = new BubbleSorter<>();
    Integer[] sortedArray = bSort.sort(array);
    assertThat(sortedArray.length).isEqualTo(3);
    assertThat(sortedArray).containsOnly(-1, 0, 10);
  }

  @Test
  public void sameElementTest() {
    Integer[] array = new Integer[]{1, 1, 1, 1};
    BubbleSorter<Integer> bSort = new BubbleSorter<>();
    Integer[] sortedArray = bSort.sort(array);
    assertThat(sortedArray.length).isEqualTo(4);
    assertThat(sortedArray).containsOnly(1, 1, 1, 1);
  }

  @Test
  public void emptyArrayTest() {
    Integer[] array = new Integer[]{};
    BubbleSorter<Integer> bSort = new BubbleSorter<>();
    Integer[] sortedArray = bSort.sort(array);
    assertThat(sortedArray.length).isEqualTo(0);
    assertThat(sortedArray).containsOnly();
  }

  @Test
  public void sortedArrayTest() {
    Integer[] array = new Integer[]{1, 2, 3, 4};
    BubbleSorter<Integer> bSort = new BubbleSorter<>();
    Integer[] sortedArray = bSort.sort(array);
    assertThat(sortedArray.length).isEqualTo(4);
    assertThat(sortedArray).containsOnly(1, 2, 3, 4);
  }

  @Test
  public void sortDuplicateElementsTest() {
    Integer[] array = new Integer[]{9, 5, 10, 0, 6, 11, 1, 1, 2};
    BubbleSorter<Integer> bSort = new BubbleSorter<>();
    Integer[] sortedArray = bSort.sort(array);
    assertThat(sortedArray.length).isEqualTo(9);
    assertThat(Arrays.equals(sortedArray, new Integer[]{0, 1, 1, 2, 5, 6, 9, 10, 11}));
  }
}
