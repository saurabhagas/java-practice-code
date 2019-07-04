package com.saurabh.collections;

import com.saurabh.algorithms.sorting.Sorter;

public interface CustomList<T extends Comparable> extends Iterable<T> {
  /**
   * Inserts the given element at the head
   *
   * @param t the element to be inserted
   */
  void insert(T t);

  /**
   * Inserts the given element at the tail
   *
   * @param t the element to be inserted
   */
  void insertAtTail(T t);

  /**
   * Inserts the element from the provided LinkedList
   *
   * @param collection the {@link CustomList} containing the elements to be inserted
   */
  void insertAll(CustomList<? extends T> collection);

  /**
   * Deleted the given element
   *
   * @param nodeValue the element to be deleted
   * @return true if the element was deleted, false otherwise
   */
  boolean delete(T nodeValue);

  /**
   * Checks if the given element is present in the list. Returns the first occurence of the nodeValue.
   *
   * @param nodeValue the element to be deleted
   * @return true if the element was found, false otherwise
   */
  boolean contains(T nodeValue);

  /**
   * Prints the list
   */
  void print();

  /**
   * Sorts the list using one {@link Sorter}
   */
  void sort(Sorter<T> sorter);

  /**
   * Reverses the list
   */
  void reverse();

  /**
   * Returns the size of the list
   *
   * @return the size of the list
   */
  int size();

  /**
   * Returns to array representation of the list
   *
   * @return items as an array
   */
  Object[] toArray();
}
