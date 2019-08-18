package com.saurabh.common;

public class Node<T> {
  private T data;
  private Node<T> leftChild;
  private Node<T> rightChild;

  public Node(T data, Node<T> leftChild, Node<T> rightChild) {
    this.data = data;
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }

  public T getData() {
    return data;
  }

  public Node<T> getLeftChild() {
    return leftChild;
  }

  public Node<T> getRightChild() {
    return rightChild;
  }

  public void setData(T data) {
    this.data = data;
  }

  public void setLeftChild(Node<T> leftChild) {
    this.leftChild = leftChild;
  }

  public void setRightChild(Node<T> rightChild) {
    this.rightChild = rightChild;
  }
}