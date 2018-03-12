package collections;

import algorithms.SortingAlgorithm;

/**
 * Single Linked List implementation
 */
public class SinglyLinkedList<T> implements LinkedList<T> {
  private Node head;

  @Override
  public void insert(T data) {
    Node newNode = new Node();
    newNode.data = data;
    newNode.next = null;

    if (head == null) {
      head = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }
  }

  @Override
  public boolean delete(T nodeValue) {
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

  private class Node {
    T data;
    Node next;
  }

  public static void main(String[] args) {
    {
      /*SinglyLinkedList of Integers*/
      SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
      linkedList.insert(5);
      linkedList.insert(50);
      linkedList.insert(500);
      linkedList.insert(5000);
      linkedList.insert(-500);
      linkedList.insert(15);
      linkedList.insert(25);

      linkedList.delete(25); //Delete first element
      linkedList.delete(5);//Delete last element
      linkedList.delete(500); //Delete any element
      linkedList.delete(786); //Non-existent element

      System.out.println("##########");
      linkedList.print();
      System.out.println("##########");
    }

    {
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
      System.out.println("##########");
    }
  }
}
