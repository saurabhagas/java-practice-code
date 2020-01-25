package com.saurabh.interview.linked_list;

import com.saurabh.common.ListNode;

import java.util.Objects;
/**
 * Problem - Given a singly linked list of N nodes. The task is to find middle of the linked list. For example, if given linked list is 1->2->3->4->5 then output should be 3.
 * If there are even nodes, then there would be two middle nodes, we need to print second middle element. For example, if given linked list is 1->2->3->4->5->6 then output should be 4.
 *
 * Approach - O(n) time complexity
 *
 */
public class _2_ReverseList {
    public ListNode getReverse(ListNode head) {
        Objects.requireNonNull(head);
        ListNode prev =null;
        while(head.next() != null) {
            ListNode temp = head.next();
            head.setNext(prev);
            prev = head;
            head = temp;
        }
        head.setNext(prev);
        return head;
    }

    public ListNode getReverseRecursive(ListNode head) {
        if(head.next() == null) {
            return head;
        }
        ListNode newHead = getReverseRecursive(head.next());
        head.next().setNext(head);
        head.setNext(null);
        return newHead;
    }

}
