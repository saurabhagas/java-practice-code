package com.saurabh.source.data_structures;

import org.junit.Test;

import static com.saurabh.source.data_structures.SegmentTree.Operation.of;
import static java.lang.Integer.MAX_VALUE;
import static org.assertj.core.api.Assertions.assertThat;

public class SegmentTreeTest {
  private final int[] array = {1, 3, 5, 7, 9, 11};

  @Test
  public void testSumStartToEnd() {
    SegmentTree segmentTree = new SegmentTree(array, of(Integer::sum, 0));
    int result = segmentTree.rangeQuery(0, 5);
    int expected = sum(0, 5);
    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void testSumStartToMid() {
    SegmentTree segmentTree = new SegmentTree(array, of(Integer::sum, 0));
    int result = segmentTree.rangeQuery(0, 2);
    int expected = sum(0, 2);
    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void testSumMidToEnd() {
    SegmentTree segmentTree = new SegmentTree(array, of(Integer::sum, 0));
    int result = segmentTree.rangeQuery(3, 5);
    int expected = sum(3, 5);
    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void testSumSingleElement_start() {
    SegmentTree segmentTree = new SegmentTree(array, of(Integer::sum, 0));
    int result = segmentTree.rangeQuery(0, 0);
    assertThat(result).isEqualTo(array[0]);
  }

  @Test
  public void testSumSingleElement_mid() {
    SegmentTree segmentTree = new SegmentTree(array, of(Integer::sum, 0));
    int result = segmentTree.rangeQuery(2, 2);
    assertThat(result).isEqualTo(array[2]);
  }

  @Test
  public void testSumSingleElement_end() {
    SegmentTree segmentTree = new SegmentTree(array, of(Integer::sum, 0));
    int result = segmentTree.rangeQuery(5, 5);
    assertThat(result).isEqualTo(array[5]);
  }

  @Test
  public void testSumMidRange() {
    SegmentTree segmentTree = new SegmentTree(array, of(Integer::sum, 0));
    int result = segmentTree.rangeQuery(1, 4);
    int expected = sum(1, 4);
    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void testSumUpdate() {
    SegmentTree segmentTree = new SegmentTree(array, of(Integer::sum, 0));
    int result = segmentTree.rangeQuery(1, 4);
    int expected = sum(1, 4);
    assertThat(result).isEqualTo(expected);

    boolean updated = segmentTree.update(7, 10);
    assertThat(updated).isTrue();
    array[3] = 10;

    result = segmentTree.rangeQuery(1, 4);
    expected = sum(1, 4);
    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void testMinStartToEnd() {
    SegmentTree segmentTree = new SegmentTree(array, of(Integer::min, MAX_VALUE));
    int result = segmentTree.rangeQuery(0, 5);
    int expected = min(0, 5);
    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void testMinStartToMid() {
    SegmentTree segmentTree = new SegmentTree(array, of(Integer::min, MAX_VALUE));
    int result = segmentTree.rangeQuery(0, 2);
    int expected = min(0, 2);
    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void testMinMidToEnd() {
    SegmentTree segmentTree = new SegmentTree(array, of(Integer::min, MAX_VALUE));
    int result = segmentTree.rangeQuery(3, 5);
    int expected = min(3, 5);
    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void testMinSingleElement_start() {
    SegmentTree segmentTree = new SegmentTree(array, of(Integer::min, MAX_VALUE));
    int result = segmentTree.rangeQuery(0, 0);
    assertThat(result).isEqualTo(array[0]);
  }

  @Test
  public void testMinSingleElement_mid() {
    SegmentTree segmentTree = new SegmentTree(array, of(Integer::min, MAX_VALUE));
    int result = segmentTree.rangeQuery(2, 2);
    assertThat(result).isEqualTo(array[2]);
  }

  @Test
  public void testMinSingleElement_end() {
    SegmentTree segmentTree = new SegmentTree(array, of(Integer::min, MAX_VALUE));
    int result = segmentTree.rangeQuery(5, 5);
    assertThat(result).isEqualTo(array[5]);
  }

  @Test
  public void testMinMidRange() {
    SegmentTree segmentTree = new SegmentTree(array, of(Integer::min, MAX_VALUE));
    int result = segmentTree.rangeQuery(1, 4);
    int expected = min(1, 4);
    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void testMinUpdate() {
    SegmentTree segmentTree = new SegmentTree(array, of(Integer::min, MAX_VALUE));
    int result = segmentTree.rangeQuery(3, 5);
    int expected = min(3, 5);
    assertThat(result).isEqualTo(expected);


    boolean updated = segmentTree.update(7, 10);
    assertThat(updated).isTrue();
    array[3] = 10;

    result = segmentTree.rangeQuery(3, 5);
    expected = min(3, 5);
    assertThat(result).isEqualTo(expected);

    result = segmentTree.rangeQuery(4, 5);
    expected = min(4, 5);
    assertThat(result).isEqualTo(expected);
  }

  private int sum(int start, int end) {
    int sum = 0;
    for (int i = start; i <= end; i++) {
      sum += array[i];
    }
    return sum;
  }

  private int min(int start, int end) {
    int min = MAX_VALUE;
    for (int i = start; i <= end; i++) {
      if (array[i] < min) min = array[i];
    }
    return min;
  }
}