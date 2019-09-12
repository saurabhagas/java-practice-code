package com.saurabh.divide_and_conquer;

import org.junit.Test;

import java.util.Optional;

import static com.saurabh.divide_and_conquer.MaxElementLesserThanGivenElementInSortedArray.search;
import static org.assertj.core.api.Assertions.assertThat;

public class MaxElementLesserThanGivenElementInSortedArrayTest {
  private static final int[] ARRAY = new int[]{-1, 1, 2, 5, 7, 9, 11, 12, 19};

  @Test
  public void testWithElementInArray_atEnd() {
    assertThat(search(ARRAY, 19)).isEqualTo(Optional.of(12));
  }

  @Test
  public void testWithElementInArray_inMiddle() {
    assertThat(search(ARRAY, 7)).isEqualTo(Optional.of(5));
  }

  @Test
  public void testWithElementInArray_towardsBeginning() {
    assertThat(search(ARRAY, 1)).isEqualTo(Optional.of(-1));
  }

  @Test
  public void testWithElementInArray_atBeginning() {
    assertThat(search(ARRAY, -1)).isEqualTo(Optional.empty());
  }

  @Test
  public void testWithElementNotInArray_atEnd() {
    assertThat(search(ARRAY, 18)).isEqualTo(Optional.of(12));
  }

  @Test
  public void testWithElementNotInArray_inMiddle() {
    assertThat(search(ARRAY, 6)).isEqualTo(Optional.of(5));
  }

  @Test
  public void testWithElementNotInArray_towardsBeginning() {
    assertThat(search(ARRAY, 0)).isEqualTo(Optional.of(-1));
  }

  @Test
  public void testWithElementNotInArray_atBeginning() {
    assertThat(search(ARRAY, -2)).isEqualTo(Optional.empty());
  }
}