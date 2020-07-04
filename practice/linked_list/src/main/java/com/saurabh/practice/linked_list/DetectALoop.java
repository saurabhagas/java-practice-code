package com.saurabh.practice.linked_list;

import com.saurabh.source.common.ListNode;

/**
 * Problem - Given a linked list of N nodes. The task is to check if the the linked list has a loop. Linked list can contain self loop.
 *
 * Approach - O(n) time complexity
 *  Create two pointers with one pointer moving one node at a time and second pointer moving two nodes at a time.
 *  If both pointers meet then, there exists a loop in the linked list
 **/
public class DetectALoop {

  int detectLoop(ListNode head) {
    if (head == null || head.next() == null) {
      return 0;
    }
    ListNode singlePtr = head;
    ListNode doublePtr = head.next();
    while (singlePtr != null && doublePtr != null && doublePtr.next() != null) {
      singlePtr = singlePtr.next();
      doublePtr = doublePtr.next().next();
      if (singlePtr == doublePtr) {
        return 1;
      }
    }
    return 0;
  }

}
