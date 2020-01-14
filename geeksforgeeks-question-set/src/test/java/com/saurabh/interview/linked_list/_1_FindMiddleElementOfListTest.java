package com.saurabh.interview.linked_list;

import com.saurabh.common.ListNode;
import com.saurabh.common.Node;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class _1_FindMiddleElementOfListTest {
    @Test
    public void testOddList() {
        _1_FindMiddleElementOfList findMiddleElementOfList = new _1_FindMiddleElementOfList();
        ListNode head = new ListNode(1);
        head.append(new ListNode(2));
        head.append(new ListNode(3));
        head.append(new ListNode(4));
        head.append(new ListNode(5));
        int middle = findMiddleElementOfList.findMiddle(head);
        assertThat(middle).isEqualTo(3);
    }

    @Test
    public void testEvenList() {
        _1_FindMiddleElementOfList findMiddleElementOfList = new _1_FindMiddleElementOfList();
        ListNode head = new ListNode(1);
        head.append(new ListNode(2));
        head.append(new ListNode(3));
        head.append(new ListNode(4));
        head.append(new ListNode(5));
        head.append(new ListNode(6));
        int middle = findMiddleElementOfList.findMiddle(head);
        assertThat(middle).isEqualTo(4);
    }

    @Test
    public void testTwoElementList() {
        _1_FindMiddleElementOfList findMiddleElementOfList = new _1_FindMiddleElementOfList();
        ListNode head = new ListNode(1);
        head.append(new ListNode(2));
        int middle = findMiddleElementOfList.findMiddle(head);
        assertThat(middle).isEqualTo(2);
    }

    @Test
    public void testOneElementList() {
        _1_FindMiddleElementOfList findMiddleElementOfList = new _1_FindMiddleElementOfList();
        ListNode head = new ListNode(1);
        int middle = findMiddleElementOfList.findMiddle(head);
        assertThat(middle).isEqualTo(1);
    }

    @Test
    public void testNullList() {
        _1_FindMiddleElementOfList findMiddleElementOfList = new _1_FindMiddleElementOfList();
        ListNode head = null;
        assertThatNullPointerException().isThrownBy(()->{findMiddleElementOfList.findMiddle(head);});
    }
}
