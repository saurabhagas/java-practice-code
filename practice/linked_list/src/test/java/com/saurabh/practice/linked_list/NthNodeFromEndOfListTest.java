package com.saurabh.practice.linked_list;

import com.saurabh.source.common.ListNode;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class NthNodeFromEndOfListTest {
  @Test
  public void testOddList() {
    NthNodeFromEndOfList nthNode = new NthNodeFromEndOfList();
    ListNode head = new ListNode(1);
    ListNode answer = new ListNode(2);
    head.append(answer);
    head.append(new ListNode(3));
    head.append(new ListNode(4));
    head.append(new ListNode(5));
    ListNode result = nthNode.getNthNodeFromEnd(head, 4);
    assertThat(result).isEqualTo(answer);
  }

  @Test
  public void testEvenList() {
    NthNodeFromEndOfList nthNode = new NthNodeFromEndOfList();
    ListNode head = new ListNode(1);
    ListNode answer = new ListNode(2);
    head.append(answer);
    head.append(new ListNode(3));
    head.append(new ListNode(4));
    head.append(new ListNode(5));
    head.append(new ListNode(6));
    ListNode result = nthNode.getNthNodeFromEnd(head, 5);
    assertThat(result).isEqualTo(answer);
  }

  @Test
  public void testNMoreThanLength() {
    NthNodeFromEndOfList nthNode = new NthNodeFromEndOfList();
    ListNode head = new ListNode(1);
    head.append(new ListNode(2));
    head.append(new ListNode(3));
    head.append(new ListNode(4));
    head.append(new ListNode(5));
    head.append(new ListNode(6));
    ListNode result = nthNode.getNthNodeFromEnd(head, 7);
    assertThat(result).isNull();
  }

  @Test
  public void testNAsOneLength() {
    NthNodeFromEndOfList nthNode = new NthNodeFromEndOfList();
    ListNode head = new ListNode(1);
    head.append(new ListNode(2));
    head.append(new ListNode(3));
    head.append(new ListNode(4));
    head.append(new ListNode(5));
    ListNode answer = new ListNode(6);
    head.append(answer);
    ListNode result = nthNode.getNthNodeFromEnd(head, 1);
    assertThat(result).isEqualTo(answer);
  }

  @Test
  public void testNullList() {
    NthNodeFromEndOfList nthNode = new NthNodeFromEndOfList();
    assertThatNullPointerException().isThrownBy(() -> {
      nthNode.getNthNodeFromEnd(null, 1);
    });
  }
}
