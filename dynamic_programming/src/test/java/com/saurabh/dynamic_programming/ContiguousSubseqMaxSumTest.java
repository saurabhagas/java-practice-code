package com.saurabh.dynamic_programming;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContiguousSubseqMaxSumTest {
  @Test
  public void testSimpleSequence() {
    ContiguousSubseqMaxSum maxSum = new ContiguousSubseqMaxSum();
    int[] a = new int[]{5, 15, -30, 10, -5, 40, 10, -10};
    int[] sumArray = maxSum.contiguousSubseqMaxSum(a);
    Assertions.assertThat(sumArray.length).isEqualTo(8);
    Assertions.assertThat(sumArray).containsExactly(new int[]{5, 20, -10, 10, 5, 45, 55, 45});
  }

  @Test
  public void testEmptySequence() {
    ContiguousSubseqMaxSum maxSum = new ContiguousSubseqMaxSum();
    int[] a = new int[]{};
    int[] sumArray = maxSum.contiguousSubseqMaxSum(a);
    Assertions.assertThat(sumArray.length).isEqualTo(0);
    Assertions.assertThat(sumArray).containsExactly(new int[]{});
  }

  @Test
  public void testNullSequence() {
    ContiguousSubseqMaxSum maxSum = new ContiguousSubseqMaxSum();
    int[] sumArray = maxSum.contiguousSubseqMaxSum(null);
    Assertions.assertThat(sumArray).isNull();
  }

  @Test
  public void testSameElementSequence() {
    ContiguousSubseqMaxSum maxSum = new ContiguousSubseqMaxSum();
    int[] a = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
    int[] sumArray = maxSum.contiguousSubseqMaxSum(a);
    Assertions.assertThat(sumArray.length).isEqualTo(8);
    Assertions.assertThat(sumArray).containsExactly(new int[]{0, 0, 0, 0, 0, 0, 0, 0});
  }

  @Test
  public void testPositiveElementSequence() {
    ContiguousSubseqMaxSum maxSum = new ContiguousSubseqMaxSum();
    int[] a = new int[]{5, 4, 3, 2, 1, 0};
    int[] sumArray = maxSum.contiguousSubseqMaxSum(a);
    Assertions.assertThat(sumArray.length).isEqualTo(6);
    Assertions.assertThat(sumArray).containsExactly(new int[]{5, 9, 12, 14, 15, 15});
  }

}
