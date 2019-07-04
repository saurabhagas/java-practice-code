package com.saurabh.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MaxHeapTest {
  @Test
  public void testHeapFromArray() {
    Heap<Integer> heap = new MinMaxHeap<>(false, 2, 8, 15, 5, 1, 20);
    assertThat(heap.toString(), is("[20, 8, 15, 5, 1, 2]"));
  }

  @Test
  public void testInsertion() {
    Heap<Integer> heap = new MinMaxHeap<>(false);
    assertThat(heap.toString(), is("[]"));

    heap.insert(2);
    assertThat(heap.toString(), is("[2]"));

    heap.insert(8);
    assertThat(heap.toString(), is("[8, 2]"));

    heap.insert(15);
    assertThat(heap.toString(), is("[15, 2, 8]"));

    heap.insert(1);
    assertThat(heap.toString(), is("[15, 2, 8, 1]"));

    heap.insert(20);
    assertThat(heap.toString(), is("[20, 15, 8, 1, 2]"));

    heap.insert(100);
    assertThat(heap.toString(), is("[100, 15, 20, 1, 2, 8]"));

    heap.insert(200);
    assertThat(heap.toString(), is("[200, 15, 100, 1, 2, 8, 20]"));
  }

  @Test
  public void testContainsElements() {
    Heap<Integer> heap = new MinMaxHeap<>(false,2, 8, 15);
    assertTrue(heap.contains(2));
    assertTrue(heap.contains(8));
    assertTrue(heap.contains(15));
    assertFalse(heap.contains(1));
    assertFalse(heap.contains(null));
  }

  @Test
  public void testContainsElements_2() {
    Heap<Integer> heap = new MinMaxHeap<>(false);
    heap.insert(2);
    heap.insert(8);
    heap.insert(15);

    assertTrue(heap.contains(2));
    assertTrue(heap.contains(8));
    assertTrue(heap.contains(15));
    assertFalse(heap.contains(1));
  }

  @Test
  public void testRemoval() {
    Heap<Integer> heap = new MinMaxHeap<>(false);
    heap.insert(2);
    heap.insert(8);
    heap.insert(15);
    heap.insert(1);
    heap.insert(20);
    heap.insert(100);
    heap.insert(200);
    assertThat(heap.toString(), is("[200, 15, 100, 1, 2, 8, 20]"));

    assertThat(heap.remove(), is(200));
    assertThat(heap.toString(), is("[100, 15, 20, 1, 2, 8]"));

    assertThat(heap.remove(), is(100));
    assertThat(heap.toString(), is("[20, 15, 8, 1, 2]"));

    assertThat(heap.remove(), is(20));
    assertThat(heap.toString(), is("[15, 2, 8, 1]"));

    assertThat(heap.remove(), is(15));
    assertThat(heap.toString(), is("[8, 2, 1]"));

    assertThat(heap.remove(), is(8));
    assertThat(heap.toString(), is("[2, 1]"));

    assertThat(heap.remove(), is(2));
    assertThat(heap.toString(), is("[1]"));

    assertThat(heap.remove(), is(1));
    assertThat(heap.toString(), is("[]"));

    assertThat(heap.remove(), is(nullValue()));
  }

  @Test
  public void testDescendingSort() {
    Heap<Integer> heap = new MinMaxHeap<>(false);
    heap.insert(2);
    heap.insert(8);
    heap.insert(15);
    heap.insert(1);
    heap.insert(20);
    heap.insert(100);
    heap.insert(200);

    List<Integer> list = new ArrayList<>();
    while (heap.size() != 0) {
      list.add(heap.remove());
    }

    assertThat(list, is(new ArrayList<>(Arrays.asList(200, 100, 20, 15, 8, 2, 1))));
  }
}