package com.saurabh.practice.linked_list;

import com.saurabh.source.common.ListNode;

/**
 * Question: https://leetcode.com/problems/merge-k-sorted-lists/submissions/
 * Approach: Merge lists pair-wise (Divide and Conquer). O(nlogk) time, O(1) space
 */
public class MergeKSortedLinkedLists {
  public ListNode<Integer> mergeKLists(ListNode<Integer>[] lists) {
    if (lists == null || lists.length == 0) return null;
    int length = lists.length;
    while (length != 1) {
      int i = 0;
      int finalIndex = 0;
      if ((length & 1) == 1) {
        finalIndex++;
        i++;
      }
      for (; i <= length - 1; i += 2) {
        lists[finalIndex++] = mergeTwoLists(lists[i], lists[i + 1]);
      }
      length = (int) Math.ceil(length / 2.0);
    }
    return lists[0];
  }

  private ListNode<Integer> mergeTwoLists(ListNode<Integer> l1, ListNode<Integer> l2) {
    ListNode<Integer> newList = new ListNode<>();
    ListNode<Integer> head = newList;
    while (l1 != null && l2 != null) {
      if (l1.data <= l2.data) {
        newList.next = l1;
        l1 = l1.next;
      } else {
        newList.next = l2;
        l2 = l2.next;
      }
      newList = newList.next;
    }

    if (l1 != null) {
      newList.next = l1;
    } else if (l2 != null) {
      newList.next = l2;
    }
    return head.next;
  }
}