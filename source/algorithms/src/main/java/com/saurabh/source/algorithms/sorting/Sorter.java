package com.saurabh.source.algorithms.sorting;

import java.util.Comparator;

public interface Sorter<T> {
  T[] sort(T[] items);

  Object[] sort(Object[] items, Comparator comparator);
}
