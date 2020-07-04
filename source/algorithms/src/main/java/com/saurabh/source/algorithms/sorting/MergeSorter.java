package com.saurabh.source.algorithms.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class MergeSorter<T extends Comparable> implements Sorter<T> {

  @Override
  public T[] sort(T[] origItems) {
    Objects.requireNonNull(origItems);
    T[] items = origItems.clone();
    mergeSort(items, 0, items.length - 1, null);
    return items;
  }

  private void merge(T[] array, int start, int mid, int end, Comparator customComparator) {

    int leftPtr = mid - start + 1;
    int rightPtr = end - mid;

    T[] L = Arrays.copyOf(array, mid - start + 1);
    T[] R = Arrays.copyOf(array, end - mid);

    for (int i = 0; i < leftPtr; ++i)
      L[i] = array[start + i];
    for (int j = 0; j < rightPtr; ++j)
      R[j] = array[mid + 1 + j];

    int i = 0, j = 0, k = start;

    while (i < leftPtr && j < rightPtr) {
      if (compareFunction(L[i], R[j], customComparator) <= 0) {
        array[k] = L[i];
        i++;
      } else {
        array[k] = R[j];
        j++;
      }
      k++;
    }
    while (i < leftPtr) {
      array[k] = L[i];
      k++;
      i++;
    }
    while (j < rightPtr) {
      array[k] = R[j];
      k++;
      j++;
    }
  }

  private int compareFunction(T element1, T element2, Comparator customComparator) {
    if (customComparator == null) {
      return element1.compareTo(element2);
    } else {
      return customComparator.compare(element1, element2);
    }
  }

  private void mergeSort(T[] array, int start, int end, Comparator customComparator) {
    if (start < end) {
      int mid = (start + end) / 2;
      mergeSort(array, start, mid, customComparator);
      mergeSort(array, mid + 1, end, customComparator);
      merge(array, start, mid, end, customComparator);
    }
  }

  @Override
  public Object[] sort(Object[] items, Comparator comparator) {
    mergeSort((T[]) items, 0, items.length - 1, comparator);
    return items;
  }
}
