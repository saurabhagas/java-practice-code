package com.saurabh.practice.linked_list;

import com.saurabh.source.common.ListNode;

import java.util.Objects;

/**
 * Problem - Given a singly linked list of N nodes. The task is to find middle of the linked list. For example, if given linked list is 1->2->3->4->5 then output should be 3.
 * If there are even nodes, then there would be two middle nodes, we need to print second middle element. For example, if given linked list is 1->2->3->4->5->6 then output should be 4.
 *
 * Approach - O(n) time complexity
 *
 * Jump two nodes at a time with one pointer and one node at a time with other
 */
public class FindMiddleElementOfList {
  public int findMiddle(ListNode head) {
    Objects.requireNonNull(head);
    ListNode middle = head;
    ListNode temp = head;
    while (temp != null && temp.next() != null) {
      middle = middle.next();
      temp = temp.next().next();
    }
    return (int) middle.getData();
  }
}
