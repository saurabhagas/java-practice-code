package com.saurabh.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class CustomArrayListImpl<T> implements CustomArrayList<T> {
  private Object[] items;
  private static final int INITIAL_SIZE = 10;
  private int size = 0;
  private static final int LENGTH_INCREMENT = INITIAL_SIZE;

  public CustomArrayListImpl() {
    items = new Object[INITIAL_SIZE];
  }

  @Override
  public boolean add(T newItem) {
    Objects.requireNonNull(newItem);
    if (size >= items.length) {
      expandArray();
    }
    items[size] = newItem;
    size++;
    return true;
  }

  @Override
  @SuppressWarnings("unchecked")
  public T remove(int index) {
    T item;
    checkIndexBounds(index);
    item = (T) items[index];
    shiftArrayElements(index);
    size--;
    if (size <= items.length - LENGTH_INCREMENT) {
      shrinkArray();
    }
    return item;
  }

  @Override
  public boolean remove(Object removeItem) {
    for (int i = 0; i < size; i++) {
      if (items[i].equals(removeItem)) {
        items[i] = items[i + 1];
        shiftArrayElements(i);
        size--;
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    Objects.requireNonNull(c);
    final boolean[] containsAll = {true};
    c.forEach(element -> containsAll[0] = containsAll[0] && contains(element));
    return containsAll[0];
  }

  @Override
  public void clear() {
    Arrays.fill(items, null);
    size = 0;
  }

  @Override
  public boolean addAll(Collection<? extends T> addList) {
    Objects.requireNonNull(addList);
    addList.forEach(this::add);
    return true;
  }

  @Override
  public boolean removeAll(Collection<?> list) {
    final boolean[] changed = {false};
    list.forEach(element -> {
      if (contains(element)) {
        remove(element);
        changed[0] = true;
      }
    });
    return changed[0];
  }

  @Override
  public boolean retainAll(Collection<?> list) {
    final boolean[] changed = {false};
    for (Object o : Arrays.copyOf(items, items.length)) {
      if (!list.contains(o)) {
        remove(o);
        changed[0] = true;
      }
    }
    return changed[0];
  }

  @Override
  @SuppressWarnings("unchecked")
  public T get(int index) {
    checkIndexBounds(index);
    return (T) items[index];
  }

  @Override
  public void set(int index, T item) {
    checkIndexBounds(index);
    Objects.requireNonNull(item);
    items[index] = item;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private int pointer = 0;

      @Override
      public boolean hasNext() {
        return size > pointer;
      }

      @Override
      @SuppressWarnings("unchecked")
      public T next() {
        if (!hasNext()) {
          throw new NullPointerException("There is no element in the List at this position");
        }
        return (T) items[pointer++];
      }
    };
  }

  @Override
  public Object[] toArray() {
    return Arrays.copyOf(items, size);
  }

  @Override
  @SuppressWarnings("unchecked")
  public <U> U[] toArray(U[] a) {
    Objects.requireNonNull(a);
    if (a.length < size) {
      return (U[]) Arrays.copyOf(items, size, a.getClass());
    }

    System.arraycopy(items, 0, a, 0, size);
    if (a.length > size) {
      a[size] = null;
    }
    return a;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean contains(Object o) {
    for (int i = 0; i < size; i++) {
      if (items[i].equals(o)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("[");
    for (int i = 0; i < size; i++) {
      s.append(items[i]);
      if (i + 1 < size) {
        s.append(", ");
      }
    }
    s.append("]");
    return s.toString();
  }

  @Override
  public int getCapacity() {
    return items.length;
  }

  private void checkIndexBounds(int index) {
    if (index >= size || size < 0) {
      throw new IndexOutOfBoundsException("Specified index " + index + " is out of bounds of the size " + size + " of the list");
    }
  }

  private void shrinkArray() {
    Object[] tempArray = new Object[items.length - LENGTH_INCREMENT];
    System.arraycopy(items, 0, tempArray, 0, size);
    items = tempArray;
  }

  private void shiftArrayElements(int index) {
    System.arraycopy(items, index + 1, items, index, size - 1 - index);
  }

  private void expandArray() {
    Object[] tempArray = new Object[items.length + LENGTH_INCREMENT];
    System.arraycopy(items, 0, tempArray, 0, items.length);
    items = tempArray;
  }
}
