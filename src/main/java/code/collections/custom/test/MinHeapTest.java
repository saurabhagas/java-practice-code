package code.collections.custom.test;

import code.collections.custom.impl.Heap;
import code.collections.custom.impl.MinMaxHeap;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class MinHeapTest {
  @Test
  public void testHeapFromArray() {
    Heap<Integer> heap = new MinMaxHeap<>(true, 2, 8, 15, 5, 1, 20);
    assertThat(heap.toString(), is("[1, 2, 15, 5, 8, 20]"));
  }

  @Test
  public void testInsertion() {
    Heap<Integer> heap = new MinMaxHeap<>(true);
    assertThat(heap.toString(), is("[]"));

    heap.insert(2);
    assertThat(heap.toString(), is("[2]"));

    heap.insert(8);
    assertThat(heap.toString(), is("[2, 8]"));

    heap.insert(15);
    assertThat(heap.toString(), is("[2, 8, 15]"));

    heap.insert(1);
    assertThat(heap.toString(), is("[1, 2, 15, 8]"));

    heap.insert(20);
    assertThat(heap.toString(), is("[1, 2, 15, 8, 20]"));

    heap.insert(100);
    assertThat(heap.toString(), is("[1, 2, 15, 8, 20, 100]"));

    heap.insert(0);
    assertThat(heap.toString(), is("[0, 2, 1, 8, 20, 100, 15]"));
  }

  @Test
  public void testContainsElements() {
    Heap<Integer> heap = new MinMaxHeap<>(true, 2, 8, 15);
    assertTrue(heap.contains(2));
    assertTrue(heap.contains(8));
    assertTrue(heap.contains(15));
    assertFalse(heap.contains(1));
    assertFalse(heap.contains(null));
  }

  @Test
  public void testContainsElements_2() {
    Heap<Integer> heap = new MinMaxHeap<>(true);
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
    Heap<Integer> heap = new MinMaxHeap<>(true);
    heap.insert(2);
    heap.insert(8);
    heap.insert(15);
    heap.insert(1);
    heap.insert(20);
    heap.insert(100);
    heap.insert(0);
    assertThat(heap.toString(), is("[0, 2, 1, 8, 20, 100, 15]"));

    assertThat(heap.remove(), is(0));
    assertThat(heap.toString(), is("[1, 2, 15, 8, 20, 100]"));

    assertThat(heap.remove(), is(1));
    assertThat(heap.toString(), is("[2, 8, 15, 100, 20]"));

    assertThat(heap.remove(), is(2));
    assertThat(heap.toString(), is("[8, 20, 15, 100]"));

    assertThat(heap.remove(), is(8));
    assertThat(heap.toString(), is("[15, 20, 100]"));

    assertThat(heap.remove(), is(15));
    assertThat(heap.toString(), is("[20, 100]"));

    assertThat(heap.remove(), is(20));
    assertThat(heap.toString(), is("[100]"));

    assertThat(heap.remove(), is(100));
    assertThat(heap.toString(), is("[]"));

    assertThat(heap.remove(), is(nullValue()));
  }

  @Test
  public void testAscendingSort() {
    Heap<Integer> heap = new MinMaxHeap<>(true);
    heap.insert(2);
    heap.insert(8);
    heap.insert(15);
    heap.insert(1);
    heap.insert(20);
    heap.insert(100);
    heap.insert(0);

    List<Integer> list = new ArrayList<>();
    while (heap.size() != 0) {
      list.add(heap.remove());
    }

    assertThat(list, is(new ArrayList<>(Arrays.asList(0, 1, 2, 8, 15, 20, 100))));
  }
}