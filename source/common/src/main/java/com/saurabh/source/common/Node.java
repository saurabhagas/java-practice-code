package com.saurabh.source.common;

import static java.util.Objects.requireNonNull;

public class Node<T> {
  private T data;
  private Node<T> lChild;
  private Node<T> rChild;

  public Node(T data, Node<T> lChild, Node<T> rChild) {
    this.data = requireNonNull(data);
    this.lChild = lChild;
    this.rChild = rChild;
  }

  public T data() {
    return data;
  }

  public Node<T> lChild() {
    return lChild;
  }

  public Node<T> rChild() {
    return rChild;
  }

  public void data(T data) {
    this.data = requireNonNull(data);
  }

  public void lChild(Node<T> lChild) {
    this.lChild = lChild;
  }

  public void rChild(Node<T> rChild) {
    this.rChild = rChild;
  }

  @Override
  public String toString() {
    return data.toString();
  }
}