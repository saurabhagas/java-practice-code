package com.saurabh.algorithms.sorting;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class SelectionSortTest {
  private static final Integer[] array = new Integer[]{9, 5, 10, 0, 6, 11, -1, 1, 2};

  @Test
  public void sortTest() {
    SelectionSorter<Integer> bSort = new SelectionSorter<>();
    Integer[] sortedArray = bSort.sort(array);
    assertThat(sortedArray.length).isEqualTo(9);
    assertThat(Arrays.equals(sortedArray, new Integer[]{-1, 0, 1, 2, 5, 6, 9, 10, 11}));
  }

  @Test
  public void sortNullArrayTest() {
    SelectionSorter<Integer> bSort = new SelectionSorter<>();
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

    SelectionSorter<CustomInt> bSort = new SelectionSorter<>();
    CustomInt[] sortedArray = bSort.sort(array);
    assertThat(sortedArray.length).isEqualTo(5);
    assertThat(Arrays.equals(sortedArray, answerArray));
  }
}

