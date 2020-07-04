package com.saurabh.source.algorithms.sorting;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class BucketSorterTest {
  @Test
  public void sortEvenNumberArrayTest() {
    Integer[] array = new Integer[]{9, 5, 10, 0, 6, 11, 3, 1, 2};
    Integer[] sortedArray = (Integer[]) new BucketSorter<>().sort(array);
    assertThat(sortedArray.length).isEqualTo(9);
    assertThat(sortedArray).containsSequence(0, 1, 2, 3, 5, 6, 9, 10, 11);
  }

  @Test
  public void sortOddNumberArrayTest() {
    Integer[] array = new Integer[]{10, 9, 4, 7, 3, 8, 12, 5};
    Integer[] sortedArray = (Integer[]) new BucketSorter<>().sort(array);
    assertThat(sortedArray.length).isEqualTo(8);
    assertThat(sortedArray).containsSequence(3, 4, 5, 7, 8, 9, 10, 12);
  }

  @Test
  public void sortNullArrayTest() {
    BucketSorter<Integer> qSort = new BucketSorter<>();
    assertThatNullPointerException().isThrownBy(() -> qSort.sort(null)).withNoCause();
  }

  @Test
  public void oneElementTest() {
    Integer[] array = new Integer[]{1};
    Integer[] sortedArray = (Integer[]) new BucketSorter<>().sort(array);
    assertThat(sortedArray.length).isEqualTo(1);
    assertThat(sortedArray).containsSequence(1);
  }

  @Test
  public void twoElementTest() {
    Integer[] array = new Integer[]{1, 0};
    Integer[] sortedArray = (Integer[]) new BucketSorter<>().sort(array);
    assertThat(sortedArray.length).isEqualTo(2);
    assertThat(sortedArray).containsSequence(0, 1);
  }

  @Test
  public void threeElementTest() {
    Integer[] array = new Integer[]{0, 2, 1};
    Integer[] sortedArray = (Integer[]) new BucketSorter<>().sort(array);
    assertThat(sortedArray.length).isEqualTo(3);
    assertThat(sortedArray).containsSequence(0, 1, 2);
  }

  @Test
  public void sameElementTest() {
    Integer[] array = new Integer[]{1, 1, 1, 1};
    Integer[] sortedArray = (Integer[]) new BucketSorter<>().sort(array);
    assertThat(sortedArray.length).isEqualTo(4);
    assertThat(sortedArray).containsSequence(1, 1, 1, 1);
  }

  @Test
  public void emptyArrayTest() {
    Integer[] array = new Integer[]{};
    Integer[] sortedArray = (Integer[]) new BucketSorter<>().sort(array);
    assertThat(sortedArray.length).isEqualTo(0);
    assertThat(sortedArray).containsSequence();
  }

  @Test
  public void sortedArrayTest() {
    Integer[] array = new Integer[]{1, 2, 3, 4};
    Integer[] sortedArray = (Integer[]) new BucketSorter<>().sort(array);
    assertThat(sortedArray.length).isEqualTo(4);
    assertThat(sortedArray).containsSequence(1, 2, 3, 4);
  }

  @Test
  public void elementsWithHugeVarianceTest() {
    Integer[] array = new Integer[]{-100000, 2, 300000000, 400000};
    Integer[] sortedArray = (Integer[]) new BucketSorter<>().sort(array);
    assertThat(sortedArray.length).isEqualTo(4);
    assertThat(sortedArray).containsSequence(-100000, 2, 400000, 300000000);
  }

  @Test
  public void largeInputArrayTest() {
    Integer[] array = new Integer[]{-100000, 2, 300000000, 400000, 1, 0, 500, 999, 88, 7, 11, 123, 3434, 56565, 432, 890};
    Integer[] sortedArray = (Integer[]) new BucketSorter<>().sort(array);
    assertThat(sortedArray.length).isEqualTo(16);
    assertThat(sortedArray).containsSequence(-100000, 0, 1, 2, 7, 11, 88, 123, 432, 500, 890, 999, 3434, 56565, 400000, 300000000);
  }

  @Test
  public void sortDoubleArrayTest() {
    Double[] array = new Double[]{21.23, 34.54, 76.23, 56.89, 12.45, 21.00};
    Double[] sortedArray = (Double[]) new BucketSorter<>().sort(array);
    assertThat(sortedArray.length).isEqualTo(6);
    assertThat(sortedArray).containsSequence(12.45, 21.00, 21.23, 34.54, 56.89, 76.23);
  }

  @Test
  public void sortFloatArrayTest() {
    Float[] array = new Float[]{21.2f, 34.54f, 76.23f, 56.8f, 34.42f, 12.45f, 21.00f, 1.2f};
    Float[] sortedArray = (Float[]) new BucketSorter<>().sort(array);
    assertThat(sortedArray.length).isEqualTo(8);
    assertThat(sortedArray).containsSequence(1.2f, 12.45f, 21.00f, 21.2f, 34.42f, 34.54f, 56.8f, 76.23f);
  }

  @Test
  public void sortFloatNegativeArrayTest() {
    Float[] array = new Float[]{-21.2f, 34.54f, 76.23f, 56.8f, 34.42f, 12.45f, 21.00f, -1.2f};
    Float[] sortedArray = (Float[]) new BucketSorter<>().sort(array);
    assertThat(sortedArray.length).isEqualTo(8);
    assertThat(sortedArray).containsSequence(-21.2f, -1.2f, 12.45f, 21.00f, 34.42f, 34.54f, 56.8f, 76.23f);
  }
}
