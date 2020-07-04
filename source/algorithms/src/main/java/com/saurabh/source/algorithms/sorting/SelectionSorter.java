package com.saurabh.source.algorithms.sorting;

import java.util.Comparator;
import java.util.Objects;

/**
 * Selection Sorter Algorithm
 * Selects largest element of an array and swaps with the last element of array.
 * Less number of swaps than other popular algos, Cycle Sorter does even lesser swaps than Selection Sorter.
 * Time Complexity -
 * Worst Case: O(n^2)     => All elements in reverse order
 * Average Case: O(n^2)
 * Best Case: O(n)        => All elements in proper order
 */

public class SelectionSorter<T extends Comparable> implements Sorter<T> {
  @Override
  public T[] sort(T[] items) {
    Objects.requireNonNull(items);

    for (int i = 0; i < items.length - 1; i++) {
      int maxIndex = 0;
      for (int j = 0; j < items.length - 1 - i; j++) {
        if (items[maxIndex].compareTo(items[j + 1]) < 0) {
          //Update index of max element
          maxIndex = j + 1;
        }
      }

      //Swap max element with last(last but 'i'th index)
      T temp = items[items.length - 1 - i];
      items[items.length - 1 - i] = items[maxIndex];
      items[maxIndex] = temp;
    }
    return items;
  }

  @Override
  public Object[] sort(Object[] items, Comparator comparator) {
    Objects.requireNonNull(items);

    for (int i = 0; i < items.length - 1; i++) {
      int maxIndex = 0;
      for (int j = 0; j < items.length - 1 - i; j++) {
        if (comparator.compare(items[maxIndex], items[j + 1]) < 0) {
          maxIndex = j + 1;
        }
      }

      Object temp = items[items.length - 1 - i];
      items[items.length - 1 - i] = items[maxIndex];
      items[maxIndex] = temp;
    }
    return items;
  }
}
