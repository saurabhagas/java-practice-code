package com.saurabh.algorithms.sorting;

import java.util.Comparator;
import java.util.Objects;

public class QuickSorter<T extends Comparable> implements Sorter<T> {
  @Override
  public T[] sort(T[] origItems) {
    Objects.requireNonNull(origItems);
    T[] items = origItems.clone();
    quickSort(items, 0, items.length - 1, null);
    return items;
  }

  private int partition(T[] array, int low, int high, Comparator comparator) {
    int piv = high;
    int i = low;
    for (int j = low; j < high; j++) {
      if (compareFunction(array[j], array[piv], comparator) <= 0) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        i++;
      }
    }

    T temp = array[i];
    array[i] = array[piv];
    array[piv] = temp;

    return i;
  }

  private int compareFunction(T element1, T element2, Comparator customComparator) {
    if (customComparator == null) {
      return element1.compareTo(element2);
    } else {
      return customComparator.compare(element1, element2);
    }
  }

  private void quickSort(T[] array, int low, int high, Comparator comparator) {
    if (low < high) {

      int piv = partition(array, low, high, comparator);

      quickSort(array, low, piv - 1, comparator);
      quickSort(array, piv + 1, high, comparator);
    }
  }

  @Override
  public Object[] sort(Object[] items, Comparator comparator) {
    quickSort((T[]) items, 0, items.length - 1, comparator);
    return items;
  }
}
