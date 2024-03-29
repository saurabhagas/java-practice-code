package com.saurabh.practice.array;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CountTripletsTest {
  @Test
  public void testNumberSeriesArrayTriplets() {
    CountTriplets triplets = new CountTriplets();
    int[] array = new int[]{1, 2, 3, 4, 5};
    int count = triplets.countTriplets(array);
    assertThat(count).isEqualTo(4);
  }

  @Test
  public void testEvenNumberTriplets() {
    CountTriplets triplets = new CountTriplets();
    int[] array = new int[]{2, 4, 6, 8, 10, 12};
    int count = triplets.countTriplets(array);
    assertThat(count).isEqualTo(6);
  }

  @Test
  public void testOddNumberTriplets() {
    CountTriplets triplets = new CountTriplets();
    int[] array = new int[]{3, 8, 2, 5, 1};
    int count = triplets.countTriplets(array);
    assertThat(count).isEqualTo(3);
  }

  @Test
  public void testSameNumberTriplets() {
    CountTriplets triplets = new CountTriplets();
    int[] array = new int[]{3, 3, 3, 3};
    int count = triplets.countTriplets(array);
    assertThat(count).isEqualTo(0);
  }

  @Test
  public void testLesserThanThreeArraySizeTriplets() {
    CountTriplets triplets = new CountTriplets();
    int[] array = new int[]{3, 2};
    int count = triplets.countTriplets(array);
    assertThat(count).isEqualTo(0);
  }

  @Test
  public void testEmptyArray() {
    CountTriplets triplets = new CountTriplets();
    int[] array = new int[]{};
    assertThatIllegalArgumentException().isThrownBy(() -> {
      triplets.countTriplets(array);
    });
  }
}
