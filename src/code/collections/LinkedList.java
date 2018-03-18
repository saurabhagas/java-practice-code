package code.collections;

import code.algorithms.SortingAlgorithm;

/**
 * LinkedList interface to define the contract for concrete Linked List implementations
 *
 * @see java.util.LinkedList
 */
public interface LinkedList<T> {
  /**
   * Inserts the given element at the head
   *
   * @param t the element to be inserted
   */
  void insert(T t);

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
}
