package com.saurabh.practice.linked_list;

import com.saurabh.source.common.ListNode;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class FindMiddleElementOfListTest {
  @Test
  public void testOddList() {
    FindMiddleElementOfList findMiddleElementOfList = new FindMiddleElementOfList();
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
    FindMiddleElementOfList findMiddleElementOfList = new FindMiddleElementOfList();
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
    FindMiddleElementOfList findMiddleElementOfList = new FindMiddleElementOfList();
    ListNode head = new ListNode(1);
    head.append(new ListNode(2));
    int middle = findMiddleElementOfList.findMiddle(head);
    assertThat(middle).isEqualTo(2);
  }

  @Test
  public void testOneElementList() {
    FindMiddleElementOfList findMiddleElementOfList = new FindMiddleElementOfList();
    ListNode head = new ListNode(1);
    int middle = findMiddleElementOfList.findMiddle(head);
    assertThat(middle).isEqualTo(1);
  }

  @Test
  public void testNullList() {
    FindMiddleElementOfList findMiddleElementOfList = new FindMiddleElementOfList();
    ListNode head = null;
    assertThatNullPointerException().isThrownBy(() -> {
      findMiddleElementOfList.findMiddle(head);
    });
  }
}
