package com.saurabh.practice.linked_list;

import com.saurabh.source.common.ListNode;

/**
 * Problem - There are two singly linked lists of size N and M in a system. But, due to some programming error the end node of one of the linked list got linked into one of the node of second list, forming a inverted Y shaped list.
 *           Write a program to get the point where two linked lists intersect each other.
 * Approach - O(n) time complexity
 *  Find the length of both linked lists, subtract greater from smaller. Traverse the greater one by the difference then traverse both simultaneously until both nodes are equal.
 **/
public class IntersectionPointInYShapedLinkedList {
  public ListNode getIntersectionPoint(ListNode headA, ListNode headB) {
    int l1 = 1;
    int l2 = 1;
    ListNode hA = headA;
    ListNode hB = headB;

    if (headA == null || headB == null) {
      return null;
    }
    while (hA != null) {
      hA = hA.next();
      l1++;
    }
    while (hB != null) {
      hB = hB.next();
      l2++;
    }
    hA = headA;
    hB = headB;
    if (l1 > l2) {
      int diff = l1 - l2;
      int count = 0;
      while (count < diff) {
        hA = hA.next();
        count++;
      }
    } else {
      int diff = l2 - l1;
      int count = 0;
      while (count < diff) {
        hB = hB.next();
        count++;
      }
    }

    boolean intersection = false;
    while (hA.next() != null && hB.next() != null) {
      if (hA == hB) {
        intersection = true;
        break;
      }
      hA = hA.next();
      hB = hB.next();
    }
    return intersection ? hA : null;
  }
}
