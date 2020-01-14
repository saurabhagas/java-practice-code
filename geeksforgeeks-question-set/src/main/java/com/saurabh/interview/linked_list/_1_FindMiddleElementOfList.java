package com.saurabh.interview.linked_list;

import com.saurabh.common.ListNode;

import java.util.Objects;

public class _1_FindMiddleElementOfList {
    public int findMiddle(ListNode head) {
        Objects.requireNonNull(head);
        ListNode middle = head;
        ListNode temp= head;
        while(temp != null && temp.next() != null) {
            middle = middle.next();
            temp = temp.next().next();
        }
        return (int) middle.getData();
    }
}
