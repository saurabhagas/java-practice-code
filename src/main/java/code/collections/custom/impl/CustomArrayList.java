package code.collections.custom.impl;

import java.util.Collection;

public interface CustomArrayList<T> extends Collection<T> {
  T remove(int index);

  T get(int index);

  void set(int index, T item);

  int getCapacity();
}
