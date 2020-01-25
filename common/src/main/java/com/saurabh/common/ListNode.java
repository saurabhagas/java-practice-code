package com.saurabh.common;

public class ListNode<T> {
    private T data;
    private ListNode<T> next;

    public ListNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public ListNode<T> next() {
        return next;
    }

    public boolean hasNext() { return next!=null;}

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    public void append(ListNode second) {
        ListNode temp = this;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = second;
        second.next = null;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ListNode)) {
            return false;
        }
        ListNode node = (ListNode) obj;
        return this.data == node.data;
    }
}
