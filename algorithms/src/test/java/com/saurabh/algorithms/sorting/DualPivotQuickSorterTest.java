package com.saurabh.algorithms.sorting;

import org.junit.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class DualPivotQuickSorterTest {
  @Test
  public void sortTest1() {
    Integer[] array = new Integer[]{9, 5, 10, 0, 6, 11, -1, 1, 2};
    Integer[] sortedArray = (Integer[]) new DualPivotQuickSorter<>().sort(array);
    assertThat(sortedArray.length).isEqualTo(9);
    assertThat(sortedArray).containsSequence(-1, 0, 1, 2, 5, 6, 9, 10, 11);
  }

  @Test
  public void sortTest2() {
    Integer[] array = new Integer[]{10, 9, 4, 7, 3, 8, 12, 5};
    Integer[] sortedArray = (Integer[]) new DualPivotQuickSorter<>().sort(array);
    assertThat(sortedArray.length).isEqualTo(8);
    assertThat(sortedArray).containsSequence(3, 4, 5, 7, 8, 9, 10, 12);
  }

  @Test
  public void sortNullArrayTest() {
    DualPivotQuickSorter<Integer> qSort = new DualPivotQuickSorter<>();
    assertThatNullPointerException()
        .isThrownBy(() ->
            qSort.sort(null)
        ).withNoCause();
  }

  @Test
  public void sortCustomClass() {
    CustomInt[] array = new CustomInt[5];
    array[0] = new CustomInt(4);
    array[1] = new CustomInt(1);
    array[2] = new CustomInt(3);
    array[3] = new CustomInt(5);
    array[4] = new CustomInt(2);

    DualPivotQuickSorter<CustomInt> bSort = new DualPivotQuickSorter<>();
    CustomInt[] sortedArray = bSort.sort(array);
    assertThat(sortedArray.length).isEqualTo(5);
    assertThat(sortedArray).extracting("element").containsSequence(1, 2, 3, 4, 5);
  }

  @Test
  public void sortTestString() {
    String[] array = new String[]{"b", "l", "a", "k", "c"};
    DualPivotQuickSorter<String> dualpivotQuickSorter = new DualPivotQuickSorter<>();
    String[] sortedArray = (String[]) dualpivotQuickSorter.sort(array, Comparator.comparing(o -> ((String) o)));
    assertThat(sortedArray.length).isEqualTo(5);
    assertThat(sortedArray).containsSequence("a", "b", "c", "k", "l");
  }

  @Test
  public void oneElementTest() {
    Integer[] array = new Integer[]{1};
    DualPivotQuickSorter<Integer> bSort = new DualPivotQuickSorter<>();
    Integer[] sortedArray = bSort.sort(array);
    assertThat(sortedArray.length).isEqualTo(1);
    assertThat(sortedArray).containsSequence(1);
  }

  @Test
  public void twoElementTest() {
    Integer[] array = new Integer[]{0, 0};
    DualPivotQuickSorter<Integer> bSort = new DualPivotQuickSorter<>();
    Integer[] sortedArray = bSort.sort(array);
    assertThat(sortedArray.length).isEqualTo(2);
    assertThat(sortedArray).containsSequence(0, 0);
  }

  @Test
  public void threeElementTest() {
    Integer[] array = new Integer[]{0, -1, 0};
    DualPivotQuickSorter<Integer> bSort = new DualPivotQuickSorter<>();
    Integer[] sortedArray = bSort.sort(array);
    assertThat(sortedArray.length).isEqualTo(3);
    assertThat(sortedArray).containsSequence(-1, 0, 0);
  }

  @Test
  public void sameElementTest() {
    Integer[] array = new Integer[]{1, 1, 1, 1};
    DualPivotQuickSorter<Integer> bSort = new DualPivotQuickSorter<>();
    Integer[] sortedArray = bSort.sort(array);
    assertThat(sortedArray.length).isEqualTo(4);
    assertThat(sortedArray).containsSequence(1, 1, 1, 1);
  }

  @Test
  public void emptyArrayTest() {
    Integer[] array = new Integer[]{};
    DualPivotQuickSorter<Integer> bSort = new DualPivotQuickSorter<>();
    Integer[] sortedArray = bSort.sort(array);
    assertThat(sortedArray.length).isEqualTo(0);
    assertThat(sortedArray).containsSequence();
  }

  @Test
  public void sortedArrayTest() {
    Integer[] array = new Integer[]{1, 2, 3, 4};
    DualPivotQuickSorter<Integer> bSort = new DualPivotQuickSorter<>();
    Integer[] sortedArray = bSort.sort(array);
    assertThat(sortedArray.length).isEqualTo(4);
    assertThat(sortedArray).containsSequence(1, 2, 3, 4);
  }
}