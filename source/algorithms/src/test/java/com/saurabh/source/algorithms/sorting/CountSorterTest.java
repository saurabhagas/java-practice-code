package com.saurabh.source.algorithms.sorting;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CountSorterTest {
  @Test
  public void basicTest() {
    CountSorter ob = new CountSorter();
    char[] arr = {'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S'};

    char[] sorted = ob.sort(arr);
    assertThat(sorted).containsExactly('E', 'E', 'E', 'E', 'F', 'G', 'G', 'K', 'K', 'O', 'R', 'S', 'S');
  }
}