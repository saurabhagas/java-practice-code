package com.saurabh.source.data_structures;

import com.saurabh.source.algorithms.sorting.InsertionSorter;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DoublyLinkedListTest {
  @Test
  public void insert_one_element() {
    final CustomList<String> list = new DoublyLinkedList<>();
    list.insert("Saurabh");

    assertThat(list.toString(), is("[Saurabh<-->null]"));
    assertThat(list.size(), is(1));
  }

  @Test
  public void insert_two_elements() {
    final CustomList<String> list = new DoublyLinkedList<>();
    list.insert("Saurabh");
    list.insert("Agarwal");
    assertThat(list.toString(), is("[Agarwal<-->Saurabh<-->null]"));
    assertThat(list.size(), is(2));
  }

  @Test
  public void insertAtTail_one_element() {
    final CustomList<String> list = new DoublyLinkedList<>();
    list.insertAtTail("Saurabh");

    assertThat(list.toString(), is("[Saurabh<-->null]"));
    assertThat(list.size(), is(1));
  }

  @Test
  public void insertAtTail_two_elements() {
    final CustomList<String> list = new DoublyLinkedList<>();
    list.insertAtTail("Saurabh");
    list.insertAtTail("Agarwal");
    assertThat(list.toString(), is("[Saurabh<-->Agarwal<-->null]"));
    assertThat(list.size(), is(2));
  }

  @Test
  public void insertAll() {
    final CustomList<? super Comparable> singlyLinkedList = new SinglyLinkedList<>();
    singlyLinkedList.insert("Hello");
    singlyLinkedList.insert(123);

    final CustomList<? super Comparable> doublyLinkedList = new DoublyLinkedList<>();
    assertThat(doublyLinkedList.size(), is(0));

    doublyLinkedList.insertAll(singlyLinkedList);
    assertThat(doublyLinkedList.size(), is(2));
    assertThat(doublyLinkedList.toString(), is("[Hello<-->123<-->null]"));
  }

  @Test
  public void delete_single_node() {
    final CustomList<String> list = new DoublyLinkedList<>();

    // Deleting non-existent element should return false
    assertThat(list.delete("blah"), is(false));

    list.insert("Saurabh");

    assertThat(list.delete("Saurabh"), is(true));
    assertThat(list.size(), is(0));

    //Ensure that head was changed properly
    final Iterator<String> iterator = list.iterator();
    assertThat(iterator.hasNext(), is(false));

    //Ensure that tail was changed properly
    final Iterator<String> reverseIterator = ((DoublyLinkedList<String>) list).reverseIterator();
    assertThat(reverseIterator.hasNext(), is(false));
  }

  @Test
  public void delete_at_head() {
    final CustomList<String> list = new DoublyLinkedList<>();

    list.insert("Saurabh");
    list.insert("Agarwal");

    assertThat(list.delete("Saurabh"), is(true));
    assertThat(list.size(), is(1));

    //Ensure that head was changed properly
    final Iterator<String> iterator = list.iterator();
    assertThat(iterator.next(), is("Agarwal"));
    assertThat(iterator.hasNext(), is(false));

    //Ensure that tail was changed properly
    final Iterator<String> reverseIterator = ((DoublyLinkedList<String>) list).reverseIterator();
    assertThat(reverseIterator.next(), is("Agarwal"));
    assertThat(reverseIterator.hasNext(), is(false));
  }

  @Test
  public void delete_at_tail() {
    final CustomList<String> list = new DoublyLinkedList<>();

    list.insert("Saurabh");
    list.insert("Agarwal");

    assertThat(list.delete("Agarwal"), is(true));
    assertThat(list.size(), is(1));

    //Ensure that head was changed properly
    final Iterator<String> iterator = list.iterator();
    assertThat(iterator.next(), is("Saurabh"));
    assertThat(iterator.hasNext(), is(false));

    //Ensure that tail was changed properly
    final Iterator<String> reverseIterator = ((DoublyLinkedList<String>) list).reverseIterator();
    assertThat(reverseIterator.next(), is("Saurabh"));
    assertThat(reverseIterator.hasNext(), is(false));
  }

  @Test
  public void delete_all_elements() {
    final CustomList<? super Comparable> list = new DoublyLinkedList<>();

    list.insert("Saurabh");
    list.insert("Agarwal");

    assertThat(list.delete("Agarwal"), is(true));
    assertThat(list.size(), is(1));

    assertThat(list.delete("Saurabh"), is(true));
    assertThat(list.size(), is(0));
    assertThat(list.toString(), is("[null]"));
  }

  @Test
  public void contains() {
    final CustomList<? super Comparable> list = new DoublyLinkedList<>();
    list.insert("Saurabh");

    assertThat(list.contains("blah"), is(false));
    assertThat(list.contains("Saurabh"), is(true));
  }

  @Test
  public void reverse_empty_list() {
    final CustomList<? super Comparable> list = new DoublyLinkedList<>();
    list.reverse();

    assertThat(list.toString(), is("[null]"));
  }

  @Test
  public void reverse_one_element() {
    final CustomList<? super Comparable> list = new DoublyLinkedList<>();
    list.insert("Saurabh");
    list.reverse();

    assertThat(list.size(), is(1));
    assertThat(list.toString(), is("[Saurabh<-->null]"));
  }

  @Test
  public void reverse_two_elements() {
    final CustomList<String> list = new DoublyLinkedList<>();
    list.insert("Saurabh");
    list.insert("Agarwal");
    list.reverse();

    //Ensure that size didn't change
    assertThat(list.size(), is(2));

    //Ensure that head was changed properly
    final Iterator<String> iterator = list.iterator();
    assertThat(iterator.next(), is("Saurabh"));
    assertThat(iterator.next(), is("Agarwal"));
    assertThat(iterator.hasNext(), is(false));

    //Ensure that tail was changed properly
    final Iterator<String> reverseIterator = ((DoublyLinkedList<String>) list).reverseIterator();
    assertThat(reverseIterator.next(), is("Agarwal"));
    assertThat(reverseIterator.next(), is("Saurabh"));
    assertThat(reverseIterator.hasNext(), is(false));
  }

  @Test
  public void reverseIterator() {
    final CustomList<String> list = new DoublyLinkedList<>();
    list.insert("Saurabh");
    list.insert("Agarwal");

    final Iterator<String> reverseIterator = ((DoublyLinkedList<String>) list).reverseIterator();
    assertThat(reverseIterator.next(), is("Saurabh"));
    assertThat(reverseIterator.next(), is("Agarwal"));
    assertThat(reverseIterator.hasNext(), is(false));
  }

  @Test
  public void testAllOperations() {
    final CustomList<String> list = new DoublyLinkedList<>();
    list.insert("Saurabh");
    list.insert("Agarwal");

    list.delete("Agarwal");
    assertThat(list.contains("Agarwal"), is(false));

    list.insertAtTail("Agarwal");
    assertThat(list.contains("Agarwal"), is(true));

    list.reverse();
    assertThat(list.size(), is(2));
    assertThat(list.toString(), is("[Agarwal<-->Saurabh<-->null]"));
  }


  @Test
  public void testSort() {
    CustomList<Integer> linkedList = new DoublyLinkedList<>();
    linkedList.insert(5);
    linkedList.insert(5000);
    linkedList.insert(50);
    linkedList.insert(500);
    linkedList.print();

    linkedList.sort(new InsertionSorter<>());
    linkedList.print();
  }
}