package com.saurabh.interview.linked_list;

import com.saurabh.common.ListNode;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class _4_ReverseListKGroupsTest {
    @Test
    public void testOddKNotFullyDivisible() {
        _4_ReverseListKGroups reverseList = new _4_ReverseListKGroups();
        ListNode head = new ListNode(1);
        head.append(new ListNode(2));
        head.append(new ListNode(3));
        head.append(new ListNode(4));
        head.append(new ListNode(5));
        head.append(new ListNode(6));
        head.append(new ListNode(7));
        head.append(new ListNode(8));

        ListNode result = new ListNode(3);
        result.append(new ListNode(2));
        result.append(new ListNode(1));
        result.append(new ListNode(6));
        result.append(new ListNode(5));
        result.append(new ListNode(4));
        result.append(new ListNode(8));
        result.append(new ListNode(7));

        ListNode newHead = reverseList.reverseKElementGroups(head, 3);
        while (newHead != null) {
            assertThat(newHead).isEqualTo(result);
            newHead = newHead.next();
            result = result.next();
        }
    }

    @Test
    public void testOddKFullyDivisible() {
        _4_ReverseListKGroups reverseList = new _4_ReverseListKGroups();
        ListNode head = new ListNode(1);
        head.append(new ListNode(2));
        head.append(new ListNode(3));
        head.append(new ListNode(4));
        head.append(new ListNode(5));
        head.append(new ListNode(6));

        ListNode result = new ListNode(3);
        result.append(new ListNode(2));
        result.append(new ListNode(1));
        result.append(new ListNode(6));
        result.append(new ListNode(5));
        result.append(new ListNode(4));

        ListNode newHead = reverseList.reverseKElementGroups(head, 3);
        while (newHead != null) {
            assertThat(newHead).isEqualTo(result);
            newHead = newHead.next();
            result = result.next();
        }
    }

    @Test
    public void testEvenKFullyDivisible() {
        _4_ReverseListKGroups reverseList = new _4_ReverseListKGroups();
        ListNode head = new ListNode(1);
        head.append(new ListNode(2));
        head.append(new ListNode(3));
        head.append(new ListNode(4));
        head.append(new ListNode(5));
        head.append(new ListNode(6));

        ListNode result = new ListNode(2);
        result.append(new ListNode(1));
        result.append(new ListNode(4));
        result.append(new ListNode(3));
        result.append(new ListNode(6));
        result.append(new ListNode(5));

        ListNode newHead = reverseList.reverseKElementGroups(head, 2);
        while (newHead != null) {
            assertThat(newHead).isEqualTo(result);
            newHead = newHead.next();
            result = result.next();
        }
    }

    @Test
    public void testEvenKNotFullyDivisible() {
        _4_ReverseListKGroups reverseList = new _4_ReverseListKGroups();
        ListNode head = new ListNode(1);
        head.append(new ListNode(2));
        head.append(new ListNode(3));
        head.append(new ListNode(4));
        head.append(new ListNode(5));

        ListNode result = new ListNode(2);
        result.append(new ListNode(1));
        result.append(new ListNode(4));
        result.append(new ListNode(3));
        result.append(new ListNode(5));

        ListNode newHead = reverseList.reverseKElementGroups(head, 2);
        while (newHead != null) {
            assertThat(newHead).isEqualTo(result);
            newHead = newHead.next();
            result = result.next();
        }
    }

    @Test
    public void testTwoElementList() {
        _4_ReverseListKGroups reverseList = new _4_ReverseListKGroups();
        ListNode head = new ListNode(1);
        head.append(new ListNode(2));

        ListNode result = new ListNode(1);
        result.append(new ListNode(2));

        ListNode newHead = reverseList.reverseKElementGroups(head, 1);
        while (newHead != null) {
            assertThat(newHead).isEqualTo(result);
            newHead = newHead.next();
            result = result.next();
        }
    }

    @Test
    public void testOneElementListKLarger() {
        _4_ReverseListKGroups reverseList = new _4_ReverseListKGroups();
        ListNode head = new ListNode(1);
        ListNode newHead = reverseList.reverseKElementGroups(head, 3);
        assertThat(newHead).isEqualTo(head);
    }

    @Test
    public void testNullList() {
        _4_ReverseListKGroups reverseList = new _4_ReverseListKGroups();
        ListNode head = null;
        ListNode newHead = reverseList.reverseKElementGroups(head, 3);
        assertThat(newHead).isNull();
    }
}
