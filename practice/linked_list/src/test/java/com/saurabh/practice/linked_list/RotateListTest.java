package com.saurabh.practice.linked_list;

import com.saurabh.source.common.ListNode;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class RotateListTest {
  @Test
  public void testOddList() {
    RotateList reverseList = new RotateList();
    ListNode head = new ListNode(1);
    head.append(new ListNode(2));
    head.append(new ListNode(3));
    head.append(new ListNode(4));
    head.append(new ListNode(5));
    ListNode newHead = reverseList.rotate(head, 2);
    int i = 3, count = 0;
    while (newHead != null) {
      assertThat(newHead).isEqualTo(new ListNode(i));
      if (count != 2) {
        i++;
      } else if (count == 2) {
        i = 1;
      }
      count++;
      newHead = newHead.next();
    }
  }

  @Test
  public void testEvenList() {
    RotateList reverseList = new RotateList();
    ListNode head = new ListNode(1);
    head.append(new ListNode(2));
    head.append(new ListNode(3));
    head.append(new ListNode(4));
    head.append(new ListNode(5));
    head.append(new ListNode(6));
    ListNode newHead = reverseList.rotate(head, 2);
    int i = 3, count = 0;
    while (newHead != null) {
      assertThat(newHead).isEqualTo(new ListNode(i));
      if (count != 3) {
        i++;
      } else if (count == 3) {
        i = 1;
      }
      count++;
      newHead = newHead.next();
    }
  }

  @Test
  public void testTwoElementList() {
    RotateList reverseList = new RotateList();
    ListNode head = new ListNode(1);
    head.append(new ListNode(2));
    ListNode newHead = reverseList.rotate(head, 2);
    int i = 1;
    while (newHead != null) {
      assertThat(newHead).isEqualTo(new ListNode(i));
      i++;
      newHead = newHead.next();
    }
  }

  @Test
  public void testOneElementList() {
    RotateList reverseList = new RotateList();
    ListNode head = new ListNode(1);
    ListNode newHead = reverseList.rotate(head, 1);
    int i = 1;
    while (newHead != null) {
      assertThat(newHead).isEqualTo(new ListNode(i));
      i--;
      newHead = newHead.next();
    }
  }

  @Test
  public void testNullList() {
    RotateList reverseList = new RotateList();
    ListNode head = null;
    assertThatNullPointerException().isThrownBy(() -> {
      reverseList.rotate(head, 1);
    });
  }
}
