package com.saurabh.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Heap implementation which can work as a min or a max depending on the constructor parameter.
 * Does not permit nulls (or holes). Use an ArrayList as the underlying data structure to enable easy contraction and expansion.
 *
 * @param <T>
 */
public class MinMaxHeap<T extends Comparable> implements Heap<T> {
  private Comparator comparator = Comparator.naturalOrder();
  private final List<T> elements = new ArrayList<>();

  public MinMaxHeap(boolean minHeap) {
    if (minHeap) {
      comparator = comparator.reversed();
    }
  }

  public MinMaxHeap(boolean minHeap, T... items) {
    if (minHeap) {
      comparator = comparator.reversed();
    }
    this.elements.addAll(heapFromArray(items));
  }

  @Override
  public void insert(T data) {
    Objects.requireNonNull(data);

    elements.add(data);
    heapifyUp();
  }

  @Override
  public T remove() {
    if (elements.size() == 0) {
      return null;
    }

    T topElement = elements.get(0);
    Collections.swap(elements, 0, elements.size() - 1);
    elements.remove(elements.size() - 1);
    heapifyDown();
    return topElement;
  }

  @Override
  public boolean contains(T data) {
    return elements.contains(data);
  }

  @Override
  public String toString() {
    return elements.toString();
  }

  @Override
  public int size() {
    return elements.size();
  }

  private void heapifyUp() {
    int i = elements.size() - 1;
    while (i > 0) {
      if (parent(i) != null && comparator.compare(parent(i), elements.get(i)) < 0) {
        Collections.swap(elements, parentIndex(i), i);
      }
      i = parentIndex(i);
    }
  }

  private void heapify(List<T> heapArray, int index) {
    int largestOrSmallest = index;
    int heapSize = heapArray.size();
    while (largestOrSmallest < heapSize / 2) {    // check parent nodes only
      int left = leftIndex(index);
      int right = rightIndex(index);

      if (leftIndex(index) < heapSize && comparator.compare(heapArray.get(left), heapArray.get(index)) > 0) {
        largestOrSmallest = left;
      }
      if (rightIndex(index) < heapSize && comparator.compare(heapArray.get(right), heapArray.get(largestOrSmallest)) > 0) {
        largestOrSmallest = right;
      }

      if (largestOrSmallest != index) { // swap parent with largestOrSmallest child
        Collections.swap(heapArray, index, largestOrSmallest);
        index = largestOrSmallest;
      } else {
        break; // if heap property is satisfied
      }
    }
  }

  private List<T> heapFromArray(T[] sourceArray) {
    for (int i = (sourceArray.length - 1) / 2; i >= 0; i--) {
      heapify(Arrays.asList(sourceArray), i);
    }
    return Arrays.asList(sourceArray);
  }

  private void heapifyDown() {
    for (int i = (elements.size() - 1) / 2; i >= 0; i--) {
      heapify(elements, i);
    }
  }

  private T parent(int childIndex) {
    int parentIndex = parentIndex(childIndex);
    if (parentIndex < 0 || parentIndex > elements.size()) {
      return null;
    }
    return elements.get(parentIndex);
  }

  private int leftIndex(int parentIndex) {
    return 2 * parentIndex + 1;
  }

  private int rightIndex(int parentIndex) {
    return 2 * parentIndex + 2;
  }

  private int parentIndex(int childIndex) {
    return (childIndex - 1) / 2;
  }
}
