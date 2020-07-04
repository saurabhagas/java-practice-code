package com.saurabh.source.algorithms.sorting;

import java.util.Comparator;
import java.util.Objects;

public class DualPivotQuickSorter<T extends Comparable> implements Sorter<T> {
  @Override
  public T[] sort(T[] origItems) {
    Objects.requireNonNull(origItems);
    T[] items = origItems.clone();
    Integer[] pivots = new Integer[]{0, items.length - 1};
    quickSort(items, 0, items.length - 1, null, pivots);
    return items;
  }

  private void partition(T[] array, int low, int high, Comparator comparator, Integer[] pivots) {
    if (compareFunction(array[low], array[high], comparator) > 0) {
      T temp = array[low];
      array[low] = array[high];
      array[high] = temp;
    }

    //****************** Fix the Right Pivot first *******************//
    int i = low + 1;

    for (int j = low + 1; j < high; j++) {
      if (compareFunction(array[j], array[high], comparator) <= 0) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        i++;
      }
    }

    T temp = array[i];
    array[i] = array[high];
    array[high] = temp;
    pivots[1] = i;            // pivots[1] has right pivot

    //****************** Fix the Left Pivot afterwards *******************//

    i = low + 1;

    for (int j = low + 1; j < pivots[1]; j++) {
      if (compareFunction(array[j], array[low], comparator) <= 0) {
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        i++;
      }
    }

    temp = array[i - 1];
    array[i - 1] = array[low];
    array[low] = temp;
    pivots[0] = i - 1;          // pivots[0] has left pivot

  }

  private int compareFunction(T element1, T element2, Comparator customComparator) {
    if (customComparator == null) {
      return element1.compareTo(element2);
    } else {
      return customComparator.compare(element1, element2);
    }
  }

  private void quickSort(T[] array, int low, int high, Comparator comparator, Integer[] pivots) {
    if (low < high) {

      partition(array, low, high, comparator, pivots);

      quickSort(array, low, pivots[0] - 1, comparator, pivots);
      quickSort(array, pivots[0] + 1, pivots[1] - 1, comparator, pivots);
      quickSort(array, pivots[1] + 1, high, comparator, pivots);
    }
  }

  @Override
  public Object[] sort(Object[] items, Comparator comparator) {
    Integer[] pivots = new Integer[]{0, items.length - 1};
    quickSort((T[]) items, 0, items.length - 1, comparator, pivots);
    return items;
  }
}
