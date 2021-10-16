package com.saurabh.source.common;

public class ListNode<T> {
  public T data;
  public ListNode<T> next;

  public ListNode() {
  }

  public ListNode(ListNode<T> node) {
    this.data = node.getData();
    this.next = node.next();
  }

  public ListNode(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public ListNode<T> next() {
    return next;
  }

  public boolean hasNext() {
    return next != null;
  }

  public void setNext(ListNode<T> next) {
    this.next = next;
  }

  @Override
  public String toString() {
    return data.toString();
  }

  public void append(ListNode<T> second) {
    ListNode<T> temp = this;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = second;
    second.next = null;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof ListNode)) {
      return false;
    }
    ListNode<T> node = (ListNode<T>) obj;
    return this.data == node.data;
  }
}
