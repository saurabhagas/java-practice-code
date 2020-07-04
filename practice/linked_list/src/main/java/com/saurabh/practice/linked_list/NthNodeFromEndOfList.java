package com.saurabh.practice.linked_list;

import com.saurabh.source.common.ListNode;

import java.util.Objects;

/**
 * Problem - Given a linked list consisting of L nodes and given a number N. The task is to find the Nth node from the end of the linked list.
 *
 * Approach - O(n) time complexity
 * Start two pointers and proceed using the first pointer only until the count
 * becomes equal to 'n' and then start the second pointer from the head til the first pointer reaches the end.
 * If the count is still less than 'n' it means that the count is more than length of the list so return -1 else return the data at the second pointer.
 */
public class NthNodeFromEndOfList {
  public ListNode getNthNodeFromEnd(ListNode head, int n) {
    Objects.requireNonNull(head);
    ListNode first = head;
    ListNode second = head;
    int count = 1;
    while (first != null) {
      if (count > n) {
        second = second.next();
      } else {
        count++;
      }
      first = first.next();
    }
    return (second == null || count <= n) ? null : second;
  }
}
