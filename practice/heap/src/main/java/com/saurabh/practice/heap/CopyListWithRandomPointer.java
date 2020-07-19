package com.saurabh.practice.heap;


import com.saurabh.source.common.ListNode;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
  public static void main(String[] args) {
    CopyListWithRandomPointer copyListWithRandomPointer = new CopyListWithRandomPointer();
    CopyListNode seven = new CopyListNode(7);
    CopyListNode thirteen = new CopyListNode(13);
    CopyListNode eleven = new CopyListNode(11);
    CopyListNode ten = new CopyListNode(10);
    CopyListNode one = new CopyListNode(1);

    seven.setNext(thirteen);
    seven.setRandom(null);

    thirteen.setNext(eleven);
    thirteen.setRandom(seven);

    eleven.setNext(ten);
    eleven.setRandom(one);

    ten.setNext(one);
    ten.setRandom(seven);

    one.setNext(null);
    one.setRandom(seven);

    CopyListNode newHead = copyListWithRandomPointer.copyList(seven);
    System.out.println("newHead = " + newHead);
  }

  private CopyListNode copyList(CopyListNode head) {
    CopyListNode newNode = null;
    CopyListNode newHead = new CopyListNode(head.getData());
    newNode = newHead;
    Map<CopyListNode, CopyListNode> mapNodes = new HashMap<CopyListNode, CopyListNode>();
    CopyListNode origNode = head;
    mapNodes.put(origNode, newNode);
    while (origNode != null) {
      origNode = origNode.next();
      if (origNode == null)
        break;
      CopyListNode newNext = new CopyListNode(origNode.getData());
      newNode.setNext(newNext);
      newNode = newNext;
      mapNodes.put(origNode, newNode);
    }

    CopyListNode node = head;
    newNode = newHead;
    while (node != null) {
      CopyListNode random = node.getRandom();
      CopyListNode newRandom = mapNodes.get(random);
      newNode.setRandom(newRandom);
      node = node.next();
      newNode = newNode.next();
    }
    return newHead;
  }
}

class CopyListNode extends ListNode<Integer> {
  private CopyListNode random;


  public CopyListNode(Integer data) {
    super(data);
  }

  public CopyListNode(ListNode<Integer> next) {
    super(next);
  }

  public void setRandom(CopyListNode random) {
    this.random = random;
  }

  public CopyListNode getRandom() {
    return random;
  }

  public CopyListNode next() {
    return (CopyListNode) this.next;
  }

}
