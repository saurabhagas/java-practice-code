package com.saurabh.practice.tree;

import com.saurabh.source.common.Node;
import com.saurabh.source.data_structures.BinarySearchTree;

public class DistanceBetweenTwoNodesBST {

  public static void main(String[] args) {
    int[] data = new int[]{7, 5, 6, 10, 11, 9, 2, 1, 3};
    int n1 = 1, n2 = 2;
    BinarySearchTree bst = new BinarySearchTree();
    for (int num : data) {
      bst.insert(num);
    }
    DistanceBetweenTwoNodesBST dist = new DistanceBetweenTwoNodesBST();
    int distBetweenNodes = dist.getDistance(Math.min(n1, n2), Math.max(n1, n2), bst.getRoot());
    System.out.println("distBetweenNodes = " + distBetweenNodes);
  }

  private int getDistance(int n1, int n2, Node root) {
    Node ans = findCommonAncestor(n1, n2, root);
    int dist1 = findDistance(ans, n1);
    int dist2 = findDistance(ans, n2);
    if (dist1 == -1 || dist2 == -1) {
      return -1;
    } else {
      return dist1 + dist2;
    }
  }

  private int findDistance(Node root, int n) {
    if (root == null) {
      return -1;
    }
    if ((Integer) root.getData() == n) {
      return 0;
    } else {
      if ((Integer) root.getData() > n)
        return findDistance(root.getLeftChild(), n) + 1;
      else
        return findDistance(root.getRightChild(), n) + 1;
    }
  }

  private Node findCommonAncestor(int n1, int n2, Node root) {
    if (n1 <= (Integer) root.getData() && n2 >= (Integer) root.getData()) {
      return root;
    } else if (n1 >= (Integer) root.getData() && n2 >= (Integer) root.getData()) {
      return findCommonAncestor(n1, n2, root.getRightChild());
    } else {
      return findCommonAncestor(n1, n2, root.getLeftChild());
    }
  }


}
