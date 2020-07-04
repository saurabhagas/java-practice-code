package com.saurabh.practice.linked_list;

import com.saurabh.source.common.ListNode;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class ReverseListTest {
  @Test
  public void testOddList() {
    ReverseList reverseList = new ReverseList();
    ListNode head = new ListNode(1);
    head.append(new ListNode(2));
    head.append(new ListNode(3));
    head.append(new ListNode(4));
    head.append(new ListNode(5));
    ListNode newHead = reverseList.getReverse(head);
    int i = 5;
    while (newHead != null) {
      assertThat(newHead).isEqualTo(new ListNode(i));
      i--;
      newHead = newHead.next();
    }
  }

  @Test
  public void testEvenList() {
    ReverseList reverseList = new ReverseList();
    ListNode head = new ListNode(1);
    head.append(new ListNode(2));
    head.append(new ListNode(3));
    head.append(new ListNode(4));
    head.append(new ListNode(5));
    head.append(new ListNode(6));
    ListNode newHead = reverseList.getReverse(head);
    int i = 6;
    while (newHead != null) {
      assertThat(newHead).isEqualTo(new ListNode(i));
      i--;
      newHead = newHead.next();
    }
  }

  @Test
  public void testTwoElementList() {
    ReverseList reverseList = new ReverseList();
    ListNode head = new ListNode(1);
    head.append(new ListNode(2));
    ListNode newHead = reverseList.getReverse(head);
    int i = 2;
    while (newHead != null) {
      assertThat(newHead).isEqualTo(new ListNode(i));
      i--;
      newHead = newHead.next();
    }
  }

  @Test
  public void testOneElementList() {
    ReverseList reverseList = new ReverseList();
    ListNode head = new ListNode(1);
    ListNode newHead = reverseList.getReverse(head);
    int i = 1;
    while (newHead != null) {
      assertThat(newHead).isEqualTo(new ListNode(i));
      i--;
      newHead = newHead.next();
    }
  }

  @Test
  public void testNullList() {
    ReverseList reverseList = new ReverseList();
    ListNode head = null;
    assertThatNullPointerException().isThrownBy(() -> {
      reverseList.getReverse(head);
    });
  }
}
