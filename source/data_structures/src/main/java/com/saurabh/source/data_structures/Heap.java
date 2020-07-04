package com.saurabh.source.data_structures;


public interface Heap<T extends Comparable> {
  void insert(T data);

  T remove();

  boolean contains(T data);

  String toString();

  int size();
}
