package com.saurabh.practice.linked_list;

import java.util.HashMap;
import java.util.Map;

class Node {
  int val;
  Node next;
  Node random;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }
}

public class CopyWithRandomPointer {
  public Node copyRandomList(Node head) {
    Node current = head;
    Node newHead = null, newCurrent = null;
    Map<Node, Node> oldToNewMap = new HashMap<>();
    while (current != null) {
      Node node = new Node(current.val);
      oldToNewMap.put(current, node);
      if (newHead == null) {
        newHead = node;
      } else {
        newCurrent.next = node;
      }
      newCurrent = node;
      current = current.next;
    }

    current = head;
    newCurrent = newHead;
    while (current != null) {
      Node next = oldToNewMap.get(current.next);
      Node random = oldToNewMap.get(current.random);
      newCurrent.next = next;
      newCurrent.random = random;
      current = current.next;
      newCurrent = newCurrent.next;
    }
    return newHead;
  }
}