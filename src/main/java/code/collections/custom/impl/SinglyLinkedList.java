package code.collections.custom.impl;

import code.algorithms.SortingAlgorithm;

import java.util.Iterator;

/**
 * Single Linked List implementation of CustomLinkedList
 */
public class SinglyLinkedList<T> implements CustomList<T> {
  private Node head;

  @Override
  public void insert(T data) {
    Node newNode = new Node(data);

    if (head == null) {
      head = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }
  }

  @Override
  public void insertAtTail(T data) {
    Node newNode = new Node(data);

    Node current = head;
    if (current == null) {
      head = newNode;
    } else {
      while (current != null && current.next != null) {
        current = current.next;
      }
      current.next = newNode;
    }
  }

  @Override
  public void insertAll(CustomList<? extends T> collection) {
    for (T item : collection) {
      insertAtTail(item);
    }
  }

  @Override
  public boolean delete(T nodeValue) {
    if (head == null) {
      throw new IllegalStateException("No elements in the list");
    }
    if (head.data.equals(nodeValue)) {
      head = head.next;
      return true;
    } else {
      Node current = head;
      while (current.next != null) {
        if (current.next.data.equals(nodeValue)) {
          current.next = current.next.next;
          return true;
        }
        current = current.next;
      }
    }
    return false;
  }

  @Override
  public boolean contains(T nodeValue) {
    Node current = head;
    while (current != null) {
      if (current.data.equals(nodeValue)) {
        return true;
      }
      current = current.next;
    }
    return false;
  }

  @Override
  public void print() {
    System.out.println(toString());
  }

  @Override
  public void sort(SortingAlgorithm algorithm) {
    throw new UnsupportedOperationException("TODO Implement me!");
  }

  @Override
  public int size() {
    Node current = head;
    int count = 0;
    while (current != null) {
      count++;
      current = current.next;
    }
    return count;
  }

  @Override
  public void reverse() {
    if (head == null) {
      throw new IllegalStateException("List does not contain any elements");
    }

    Node current = head;
    Node next = head.next;
    while (next != null) {
      Node temp = next.next;
      next.next = current;
      current = next;
      next = temp;
    }

    //Set the next of current head to null, as this will become the last element in the list
    head.next = null;
    //Change the head to the current position of the iterator
    head = current;
  }

  @Override
  public Iterator<T> iterator() {
    return new SinglyLinkedListIterator();
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    Node current = head;
    boolean first = false;
    while (current != null) {
      if (!first) {
       builder.append("[ ");
        first = true;
      }

      builder.append(current.data);
      if (current.next == null) {
        builder.append(" ]");
      } else {
        builder.append(" --> ");
      }
      current = current.next;
    }
    return builder.toString();
  }

  private void reverseRecursively(Node current, Node previous) {
    /* If last node mark it head*/
    if (current.next == null) {
      head = current;
      /* Update next to previous node */
      current.next = previous;
      return;
    }

    Node temp = current.next;
    /* and update next ..*/
    current.next = previous;

    reverseRecursively(temp, current);
  }

  private class Node {
    T data;
    Node next;

    Node(T data) {
      this.data = data;
      next = null;
    }
  }

  private class SinglyLinkedListIterator implements Iterator<T> {
    Node current = head;
    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public T next() {
      T item = current.data;
      current = current.next;
      return item;
    }
  }
}
