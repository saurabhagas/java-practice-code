package code.collections.custom;

import code.algorithms.SortingAlgorithm;

import java.util.Iterator;

/**
 * LinkedList interface to define the contract for concrete Linked List implementations
 *
 * @see java.util.LinkedList
 */
public interface LinkedList<T> extends Iterable<T> {
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
   * @param collection the {@link LinkedList} containing the elements to be inserted
   */
  void insertAll(LinkedList<? extends T> collection);

  /**
   * Deleted the given element
   *
   * @param nodeValue the element to be deleted
   * @return true if the element was deleted, false otherwise
   */
  boolean delete(T nodeValue);

  /**
   * Checks if the given element is present in the list
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
   * Sorts the list using one {@link SortingAlgorithm}
   */
  void sort(SortingAlgorithm algorithm);

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

  @Override
  Iterator<T> iterator();
}
