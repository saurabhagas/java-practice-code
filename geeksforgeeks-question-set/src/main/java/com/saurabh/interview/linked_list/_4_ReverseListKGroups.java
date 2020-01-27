package com.saurabh.interview.linked_list;

import com.saurabh.common.ListNode;

/**
 * Problem - Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the linked list.
 * Leaving the last elements not forming a full group as is.
 *
 * Approach - O(n) time complexity
 *
 * Reverse 'k' nodes and set the next of head to the reverse of the next reversed list
 **/
public class _4_ReverseListKGroups {
    public ListNode reverseKElementGroups(ListNode head, int k) {

        if (head == null) return null;
        ListNode curr = head, prev = null;

        for (int i = 0; i < k; i++) {
            if (curr == null) break;
            ListNode tmp = curr.next();
            curr.setNext(prev);
            prev = curr;
            curr = tmp;
        }

        head.setNext(reverseKElementGroups(curr, k));
        return prev;
    }
}
