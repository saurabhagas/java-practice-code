package com.saurabh.practice.linked_list;

import com.saurabh.source.common.ListNode;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveALoopTest {
  @Test
  public void testOddList() {
    RemoveALoop detectLoop = new RemoveALoop();
    ListNode head = new ListNode(1);
    head.append(new ListNode(2));
    head.append(new ListNode(3));
    head.append(new ListNode(4));
    ListNode five = new ListNode(5);
    head.append(five);
    five.setNext(head);
    ListNode nextHead = detectLoop.removeTheLoop(head);

    ListNode result = new ListNode(2);
    result.append(new ListNode(3));
    result.append(new ListNode(4));
    result.append(new ListNode(5));
    result.append(new ListNode(1));

    while (nextHead != null) {
      assertThat(result).isEqualTo(nextHead);
      result = result.next();
      nextHead = nextHead.next();
    }
  }

  @Test
  public void testEvenList() {
    RemoveALoop detectLoop = new RemoveALoop();
    ListNode head = new ListNode(1);
    head.append(new ListNode(2));
    head.append(new ListNode(3));
    ListNode four = new ListNode(4);
    head.append(four);
    head.append(new ListNode(5));
    ListNode six = new ListNode(6);
    head.append(six);
    six.setNext(four);

    ListNode nextHead = detectLoop.removeTheLoop(head);

    ListNode result = new ListNode(4);
    result.append(new ListNode(5));
    result.append(new ListNode(6));
    result.append(new ListNode(1));
    result.append(new ListNode(2));
    result.append(new ListNode(3));

    while (nextHead != null) {
      assertThat(result).isEqualTo(nextHead);
      result = result.next();
      nextHead = nextHead.next();
    }
  }

  @Test
  public void testLoopToItselfList() {
    RemoveALoop detectLoop = new RemoveALoop();
    ListNode head = new ListNode(1);
    ListNode two = new ListNode(2);
    head.append(two);
    two.setNext(two);

    ListNode nextHead = detectLoop.removeTheLoop(head);

    ListNode result = new ListNode(2);
    result.append(new ListNode(1));

    while (nextHead != null) {
      assertThat(result).isEqualTo(nextHead);
      result = result.next();
      nextHead = nextHead.next();
    }
  }

  @Test
  public void testNoLoopList() {
    RemoveALoop detectLoop = new RemoveALoop();
    ListNode head = new ListNode(1);
    head.append(new ListNode(3));
    head.append(new ListNode(4));
    head.append(new ListNode(5));
    head.append(new ListNode(6));

    ListNode nextHead = detectLoop.removeTheLoop(head);

    ListNode result = new ListNode(1);
    result.append(new ListNode(3));
    result.append(new ListNode(4));
    result.append(new ListNode(5));
    result.append(new ListNode(6));

    while (nextHead != null) {
      assertThat(result).isEqualTo(nextHead);
      result = result.next();
      nextHead = nextHead.next();
    }
  }

  @Test
  public void testNullList() {
    RemoveALoop detectLoop = new RemoveALoop();
    ListNode head = null;

    ListNode nextHead = detectLoop.removeTheLoop(head);
    assertThat(nextHead).isNull();
  }
}
