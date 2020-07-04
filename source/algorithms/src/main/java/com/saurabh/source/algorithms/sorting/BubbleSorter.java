package com.saurabh.source.algorithms.sorting;

import java.util.Comparator;
import java.util.Objects;

/**
 * Bubble Sorter Algorithm
 * Compares adjacent elements and swaps if first element is greater
 * Time Complexity -
 * Worst Case: O(n^2)     => All elements in reverse order
 * Average Case: O(n^2)
 * Best Case: O(n)        => All elements in proper order
 */

public class BubbleSorter<T extends Comparable> implements Sorter<T> {
  public T[] sort(T[] items) {
    Objects.requireNonNull(items);
    for (int i = 0; i < items.length - 1; i++) {
      for (int j = 0; j < items.length - 1 - i; j++) {
        if (items[j].compareTo(items[j + 1]) >= 0) {
          T temp = items[j];
          items[j] = items[j + 1];
          items[j + 1] = temp;
        }
      }
    }
    return items;
  }

  public Object[] sort(Object[] items, Comparator comparator) {
    Objects.requireNonNull(items);
    for (int i = 0; i < items.length - 1; i++) {
      for (int j = 0; j < items.length - 1 - i; j++) {
        if (comparator.compare(items[j], items[j + 1]) >= 0) {
          Object temp = items[j];
          items[j] = items[j + 1];
          items[j + 1] = temp;
        }
      }
    }
    return items;
  }
}
