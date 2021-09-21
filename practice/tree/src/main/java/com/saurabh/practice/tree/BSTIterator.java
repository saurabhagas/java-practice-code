package com.saurabh.practice.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

public class BSTIterator implements Iterator<Integer> {
  private final Deque<TreeNode> s;

  public BSTIterator(TreeNode root) {
    this.s = new ArrayDeque<>();
    goToLeft(root);
  }

  @Override
  public Integer next() {
    TreeNode curr = s.pop();
    int data = curr.val;
    if (curr.right != null) {
      goToLeft(curr.right);
    }
    return data;
  }

  @Override
  public boolean hasNext() {
    return !s.isEmpty();
  }

  private void goToLeft(TreeNode root) {
    TreeNode curr = root;
    while (curr != null) {
      s.push(curr);
      curr = curr.left;
    }
  }
}