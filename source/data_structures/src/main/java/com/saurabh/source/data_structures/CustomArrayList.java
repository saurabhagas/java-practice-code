package com.saurabh.source.data_structures;

import java.util.Collection;

public interface CustomArrayList<T> extends Collection<T> {
  T remove(int index);

  T get(int index);

  void set(int index, T item);

  int getCapacity();
}
