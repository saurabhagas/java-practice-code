package code.collections.custom.impl;

import code.algorithms.SortingAlgorithm;

import java.util.Iterator;

public class DoublyLinkedList<T> implements CustomList<T> {
  private Node head = null;
  private Node tail = null;
  private int size = 0;

  @Override
  public void insert(T data) {
    Node node = new Node(data);
    if (head == null) {
      // First addition to the list
      tail = node;
    } else {
      head.previous = node;
      node.next = head;
    }
    head = node;
    size++;
  }

  @Override
  public void insertAtTail(T data) {
    Node node = new Node(data);
    if (head == null) {
      head = node;
    } else {
      tail.next = node;
      node.previous = tail;
    }
    tail = node;
    size++;
  }

  @Override
  public void insertAll(CustomList<? extends T> collection) {
    collection.forEach(this::insert);
  }

  @Override
  public boolean delete(T nodeValue) {
    if (head == null) {
      return false;
    }

    if (head.data.equals(nodeValue) && head == tail) {
      head = null;
      tail = null;
      size -= 1;
      return true;
    }

    for (Node current = head; current.next != null; current = current.next) {
      if (current.data.equals(nodeValue)) {
        if (current == head) {
          current.next.previous = null;
          head = current.next;
        } else {
          current.previous.next = current.next;
          current.next.previous = current.previous;
        }
        size -= 1;
        return true;
      }
    }

    if (tail.data.equals(nodeValue)) {
      tail.previous.next = null;
      tail = tail.previous;
      size -= 1;
      return true;
    }
    return false;
  }

  @Override
  public boolean contains(T nodeValue) {
    for (Iterator<T> iterator = iterator(); iterator.hasNext(); ) {
      if (iterator.next().equals(nodeValue)) {
        return true;
      }
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
  public void reverse() {
    if (head == null) {
      return;
    }

    Node current;
    for (current = head; current.next != null; ) {
      Node oldNext = current.next;
      current.next = current.previous;
      current.previous = oldNext;
      current = oldNext;
    }

    tail = head;
    head = current;

    current.next = current.previous;
    current.previous = null;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public Iterator<T> iterator() {
    return new ForwardIterator();
  }

  public Iterator<T> reverseIterator() {
    return new BackwardIterator();
  }

  @Override
  public String toString() {
    final StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");

    for (Iterator<T> iterator = iterator(); iterator.hasNext(); ) {
      stringBuilder.append(iterator.next()).append("<-->");
    }
    return stringBuilder.append("null").append("]").toString();
  }

  private class ForwardIterator implements Iterator<T> {
    Node next = head;

    @Override
    public boolean hasNext() {
      return next != null;
    }

    @Override
    public T next() {
      if (next == null) {
        throw new IllegalStateException("No further elements in the list");
      }
      T data = next.data;
      next = next.next;
      return data;
    }
  }

  private class BackwardIterator implements Iterator<T> {
    Node next = tail;

    @Override
    public boolean hasNext() {
      return next != null;
    }

    @Override
    public T next() {
      if (next == null) {
        throw new IllegalStateException("No further elements in the list");
      }
      T data = next.data;
      next = next.previous;
      return data;
    }
  }

  private class Node {
    private final T data;
    private Node previous;
    private Node next;

    Node(T data) {
      this.data = data;
    }
  }
}
