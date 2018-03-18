package code.collections;

import code.algorithms.SortingAlgorithm;

import org.junit.Test;

/**
 * Single Linked List implementation
 */
public class SinglyLinkedList<T> implements LinkedList<T> {
  private Node<T> head;

  @Override
  public void insert(T data) {
    Node<T> newNode = new Node<>(data);

    if (head == null) {
      head = newNode;
    } else {
      newNode.next = head;
      head = newNode;
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
      while (current != null && current.next != null) {
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
    Node current = head;
    boolean first = false;
    while (current != null) {
      if (!first) {
        System.out.print("[ ");
        first = true;
      }

      System.out.print(current.data);
      if (current.next == null) {
        System.out.println(" ]");
      } else {
        System.out.print(" --> ");
      }
      current = current.next;
    }
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

    Node<T> current = head;
    Node<T> next = head.next;
    while (next != null) {
      Node<T> temp = next.next;
      next.next = current;
      current = next;
      next = temp;
    }

    //Set the next of current head to null, as this will become the last element in the list
    head.next = null;
    //Change the head to the current position of the iterator
    head = current;
  }

  public void reverseRecursively(Node<T> current, Node<T> previous) {
    /* If last node mark it head*/
    if (current.next == null) {
      head = current;
      /* Update next to previous node */
      current.next = previous;
      return;
    }

    Node<T> temp = current.next;
    /* and update next ..*/
    current.next = previous;

    reverseRecursively(temp, current);
  }

  private class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
      this.data = data;
      next = null;
    }
  }

  @Test
  public void testIntegerList() {
    /*SinglyLinkedList of Integers*/
    SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
    linkedList.insert(5);
    linkedList.insert(50);
    linkedList.insert(500);
    linkedList.insert(5000);
//      linkedList.insert(-500);
//      linkedList.insert(15);
//      linkedList.insert(25);

//      linkedList.delete(25); //Delete first element
//      linkedList.delete(5);//Delete last element
//      linkedList.delete(500); //Delete any element
//      linkedList.delete(786); //Non-existent element

    System.out.println("##########");
    linkedList.print();
    linkedList.reverseRecursively(linkedList.head, null);
    linkedList.print();
    System.out.println("##########");
  }

  @Test
  public void testStringList() {
    /*SinglyLinkedList of Strings*/
    SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
    linkedList.insert("Behen");
    linkedList.insert("Amma");
    linkedList.insert("Mayya");

    String delete = "Amma";
    System.out.println("Deleted " + delete + "? " + linkedList.delete(delete)); //Existent element
    delete = "Cool";
    System.out.println("Deleted " + delete + "? " + linkedList.delete(delete)); //Non-existent element

    System.out.println("##########");
    linkedList.print();
    linkedList.reverseRecursively(linkedList.head, null);
    linkedList.print();
    System.out.println("##########");
  }
}
