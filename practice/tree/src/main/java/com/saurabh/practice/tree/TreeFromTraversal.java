package com.saurabh.practice.tree;

import com.saurabh.source.algorithms.traversal.Traversals;
import com.saurabh.source.common.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TreeFromTraversal {
  private final HashMap<Integer, Integer> indices = new HashMap<>();
  private final int[] preOrder = {3, 9, 20, 15, 7};
  private final int[] postOrder = {9, 15, 7, 20, 3};
  private final int[] inOrder = {9, 3, 15, 20, 7};
  private int postOrderCurrent = postOrder.length - 1;

  public static void main(String[] args) {
    TreeFromTraversal obj = new TreeFromTraversal();
    for (int i = 0; i < obj.inOrder.length; i++) {
      obj.indices.put(obj.inOrder[i], i);
    }

    Node<Integer> root = obj.treeFromPreorderAndInorder(obj.preOrder, new AtomicInteger(0), obj.inOrder, 0, obj.inOrder.length - 1);
    List<Integer> list = new ArrayList<>();
    Traversals.inorder(root, list);
    System.out.println(list); // should be the same as inOrder

    root = obj.treeFromPostorderAndInorder(obj.postOrder, obj.inOrder, 0, obj.inOrder.length - 1);
    list = new ArrayList<>();
    Traversals.inorder(root, list);
    System.out.println(list); // should be the same as inOrder
  }

  public Node<Integer> treeFromPreorderAndInorder(int[] preOrder, AtomicInteger preOrderCurrent, int[] inOrder, int left, int right) {
    if (preOrderCurrent.get() == preOrder.length || left > right || left < 0 || right >= inOrder.length) return null;

    int data = preOrder[preOrderCurrent.getAndIncrement()];
    Node<Integer> node = new Node<>(data, null, null);
    int foundAt = indices.get(data);
    node.lChild(treeFromPreorderAndInorder(preOrder, preOrderCurrent, inOrder, left, foundAt - 1));
    node.rChild(treeFromPreorderAndInorder(preOrder, preOrderCurrent, inOrder, foundAt + 1, right));
    return node;
  }

  public Node<Integer> treeFromPostorderAndInorder(int[] postOrder, int[] inOrder, int left, int right) {
    if (postOrderCurrent < 0 || left > right || left < 0 || right >= inOrder.length) return null;

    int data = postOrder[postOrderCurrent--];
    Node<Integer> node = new Node<>(data, null, null);
    int foundAt = indices.get(data);

    Node<Integer> rightChild = treeFromPostorderAndInorder(postOrder, inOrder, foundAt + 1, right);
    node.rChild(rightChild);

    Node<Integer> leftChild = treeFromPostorderAndInorder(postOrder, inOrder, left, foundAt - 1);
    node.lChild(leftChild);
    return node;
  }
}
