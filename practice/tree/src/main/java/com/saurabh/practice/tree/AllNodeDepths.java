package com.saurabh.practice.tree;

import com.saurabh.source.algorithms.traversal.Traversals;
import com.saurabh.source.common.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AllNodeDepths {
  public static void main(String[] args) {
    AllNodeDepths obj = new AllNodeDepths();
    Node<Integer> eight =  new Node<>(8, null, null);
    Node<Integer> nine =  new Node<>(9, null, null);
    Node<Integer> leftestLeaf = new Node<>(4, eight, nine);
    Node<Integer> rightLeftLeaf = new Node<>(6, null, null);
    Node<Integer> rightRightLeaf = new Node<>(7, null, null);
    Node<Integer> five = new Node<>(5, null, null);
    Node<Integer> left = new Node<>(2, leftestLeaf, five);
    Node<Integer> right = new Node<>(3, rightLeftLeaf, rightRightLeaf);
    Node<Integer> root = new Node<>(1, left, right);

    // Do normal inorder traversal
    List<Integer> inorderList = new ArrayList<>();
    Traversals.inorder(root, inorderList);
    System.out.println("Inorder traversal: " + inorderList);

    System.out.println("Sum of all depths: " + obj.sumOfAllDepths(root));
  }

  public int sumOfAllDepths(Node<Integer> root) {
    if (root == null) return 0;
    HashMap<Node<Integer>, Integer> nodeToDepth = new HashMap<>();
    return getCurrentSum(root, nodeToDepth) + sumOfAllDepths(root.lChild()) + sumOfAllDepths(root.rChild());
  }

  public int getCurrentSum(Node<Integer> root, HashMap<Node<Integer>, Integer> nodeToDepth) {
    if (root == null) return 0;

    if (nodeToDepth.get(root) != null) return nodeToDepth.get(root);
    int allLeftSum = getCurrentSum(root.lChild(), nodeToDepth);
    int allRightSum = getCurrentSum(root.rChild(), nodeToDepth);
    int allSum = allLeftSum + countNodes(root.lChild()) + allRightSum + countNodes(root.rChild());
    nodeToDepth.put(root, allSum);
    return allSum;
  }

  private int countNodes(Node<Integer> root) {
    if (root == null) return 0;
    return countNodes(root.lChild()) + countNodes(root.rChild()) + 1;
  }
}
