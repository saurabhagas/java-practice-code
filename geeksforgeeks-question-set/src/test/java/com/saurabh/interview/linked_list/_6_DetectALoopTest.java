package com.saurabh.interview.linked_list;

import com.saurabh.common.ListNode;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class _6_DetectALoopTest {
    @Test
    public void testOddList() {
        _6_DetectALoop detectLoop = new _6_DetectALoop();
        ListNode head = new ListNode(1);
        head.append(new ListNode(2));
        head.append(new ListNode(3));
        head.append(new ListNode(4));
        ListNode five = new ListNode(5);
        head.append(five);
        five.setNext(head);
        int result = detectLoop.detectLoop(head);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void testEvenList() {
        _6_DetectALoop detectLoop = new _6_DetectALoop();
        ListNode head = new ListNode(1);
        head.append(new ListNode(2));
        head.append(new ListNode(3));
        ListNode four = new ListNode(4);
        head.append(four);
        head.append(new ListNode(5));
        ListNode six = new ListNode(6);
        head.append(six);
        six.setNext(four);
        int result = detectLoop.detectLoop(head);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void testLoopToItselfList() {
        _6_DetectALoop detectLoop = new _6_DetectALoop();
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        head.append(two);
        two.setNext(two);
        int result = detectLoop.detectLoop(head);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void testNoLoopList() {
        _6_DetectALoop detectLoop = new _6_DetectALoop();
        ListNode head = new ListNode(1);
        head.append(new ListNode(3));
        head.append(new ListNode(4));
        head.append(new ListNode(5));
        head.append(new ListNode(6));
        int result = detectLoop.detectLoop(head);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void testNullList() {
        _6_DetectALoop detectLoop = new _6_DetectALoop();
        ListNode head = null;
        int result = detectLoop.detectLoop(head);
        assertThat(result).isEqualTo(0);
    }
}
