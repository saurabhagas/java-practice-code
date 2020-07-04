package com.saurabh.practice.linked_list;

import com.saurabh.source.common.ListNode;

import java.util.Objects;

/**
 * Problem - Given a singly linked list of size N. The task is to rotate the linked list counter-clockwise by k nodes,
 * where k is a given positive integer smaller than or equal to length of the linked list.
 * Eg: I/p: 1 2 3 4 5 6 7 8 and k = 2 => O/p: 3 4 5 6 7 8 1 2
 *
 * Approach - O(n) time complexity
 * Keep track of the k th element and attach it to the last node
 *
 */
public class RotateList {
  public ListNode rotate(ListNode head, int k) {
    Objects.requireNonNull(head);
    int i = 0;
    ListNode newHead = head;
    ListNode prev = null;
    ListNode orig = head;
    while (head.next() != null) {
      if (i < k) {
        prev = head;
      }
      i++;
      head = head.next();
    }
    if (i + 1 == k) {
      return orig;
    } else if( i < k) {
      throw new RuntimeException("k is bigger than list size");
    }
    newHead = prev.next();
    prev.setNext(null);
    head.setNext(orig);
    return newHead;
  }
}
