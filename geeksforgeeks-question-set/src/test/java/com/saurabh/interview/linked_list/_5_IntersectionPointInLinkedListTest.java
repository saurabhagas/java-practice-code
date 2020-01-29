package com.saurabh.interview.linked_list;

import com.saurabh.common.ListNode;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _5_IntersectionPointInLinkedListTest {
    @Test
    public void testEqualLists() {
        _5_IntersectionPointInLinkedList intersectionList = new _5_IntersectionPointInLinkedList();
        ListNode list1 = new ListNode(1);
        list1.append(new ListNode(2));
        list1.append(new ListNode(3));
        ListNode intersection = new ListNode(4);
        list1.append(intersection);

        ListNode list2 = new ListNode(3);
        list2.append(new ListNode(5));
        list2.append(new ListNode(6));
        list2.append(new ListNode(7));
        list2.append(intersection);
        intersection.append(new ListNode(8));
        intersection.append(new ListNode(9));

        ListNode result = intersectionList.getIntersectionPoint(list1, list2);
        assertThat(result).isEqualTo(intersection);
    }

    @Test
    public void testFirstListLarger() {
        _5_IntersectionPointInLinkedList intersectionList = new _5_IntersectionPointInLinkedList();
        ListNode list1 = new ListNode(1);
        list1.append(new ListNode(2));
        list1.append(new ListNode(3));
        ListNode intersection = new ListNode(4);
        list1.append(intersection);

        ListNode list2 = new ListNode(3);
        list2.append(new ListNode(5));
        list2.append(new ListNode(6));
        list2.append(intersection);
        intersection.append(new ListNode(8));
        intersection.append(new ListNode(9));

        ListNode result = intersectionList.getIntersectionPoint(list1, list2);
        assertThat(result).isEqualTo(intersection);
    }

    @Test
    public void testSecondListLarger() {
        _5_IntersectionPointInLinkedList intersectionList = new _5_IntersectionPointInLinkedList();
        ListNode list1 = new ListNode(1);
        list1.append(new ListNode(2));
        ListNode intersection = new ListNode(4);
        list1.append(intersection);

        ListNode list2 = new ListNode(3);
        list2.append(new ListNode(5));
        list2.append(new ListNode(6));
        list2.append(new ListNode(7));
        list2.append(intersection);
        intersection.append(new ListNode(8));
        intersection.append(new ListNode(9));

        ListNode result = intersectionList.getIntersectionPoint(list1, list2);
        assertThat(result).isEqualTo(intersection);
    }

    @Test
    public void testNoIntersection() {
        _5_IntersectionPointInLinkedList intersectionList = new _5_IntersectionPointInLinkedList();
        ListNode list1 = new ListNode(1);
        list1.append(new ListNode(2));
        list1.append(new ListNode(3));

        ListNode list2 = new ListNode(4);
        list2.append(new ListNode(5));
        list2.append(new ListNode(6));

        ListNode result = intersectionList.getIntersectionPoint(list1, list2);
        assertThat(result).isNull();
    }

    @Test
    public void testBothNullList() {
        _5_IntersectionPointInLinkedList reverseList = new _5_IntersectionPointInLinkedList();

        ListNode result = reverseList.getIntersectionPoint(null, null);
        assertThat(result).isNull();
    }

    @Test
    public void testFirstNullList() {
        _5_IntersectionPointInLinkedList reverseList = new _5_IntersectionPointInLinkedList();
        ListNode list1 = new ListNode(1);
        list1.append(new ListNode(2));
        list1.append(new ListNode(3));

        ListNode newHead = reverseList.getIntersectionPoint(list1, null);
        assertThat(newHead).isNull();
    }

    @Test
    public void testSecondNullList() {
        _5_IntersectionPointInLinkedList reverseList = new _5_IntersectionPointInLinkedList();
        ListNode list1 = new ListNode(1);
        list1.append(new ListNode(2));
        list1.append(new ListNode(3));
        ListNode newHead = reverseList.getIntersectionPoint(null, list1);
        assertThat(newHead).isNull();
    }
}
