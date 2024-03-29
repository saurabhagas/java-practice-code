package com.saurabh.practice.linked_list;

import com.saurabh.source.common.ListNode;

/**
 * Problem - You are given a linked list of N nodes. The task is to remove the loop from the linked list, if present.
 *
 * Approach - O(n) time complexity
 *
 * Detect the loop using the earlier single and double pointer (hare and tortoise) method
 * Move one pointer to the head of the list at this point of equality of both pointers.
 * Then move both pointers ahead and check if their next node are equal.
 * If they are equal then remove the next pointer of one node.
 *
 **/
public class RemoveALoop {
    public ListNode removeTheLoop(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode singlePtr = head;
        ListNode doublePtr = head;
        boolean flag = false;
        while (doublePtr != null && doublePtr.next() != null) {
            singlePtr = singlePtr.next();
            doublePtr = doublePtr.next().next();
            if (singlePtr == doublePtr) {
                flag = true;
                break;
            }
        }

        if (flag) {
            singlePtr = head;
            while (singlePtr.next() != doublePtr.next()) {
                singlePtr = singlePtr.next();
                doublePtr = doublePtr.next();
            }
            ListNode nextHead = doublePtr.next();
            doublePtr.setNext(null);
            return nextHead;
        } else {
            return head;
        }

    }
}
