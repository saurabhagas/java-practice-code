package com.saurabh.practice.tree;

import com.saurabh.source.algorithms.traversal.Traversals;
import com.saurabh.source.common.Node;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {
  public static void main(String[] args) {
    MorrisTraversal obj = new MorrisTraversal();
    Node<Integer> leftestLeaf = new Node<>(3, null, null);
    Node<Integer> rightLeftLeaf = new Node<>(1, null, null);
    Node<Integer> rightRightLeaf = new Node<>(5, null, null);
    Node<Integer> left = new Node<>(1, leftestLeaf, null);
    Node<Integer> right = new Node<>(4, rightLeftLeaf, rightRightLeaf);
    Node<Integer> root = new Node<>(3, left, right);

    // Do normal inorder traversal
    List<Integer> inorderList = new ArrayList<>();
    Traversals.inorder(root, inorderList);
    System.out.println("Inorder traversal: " + inorderList);

    // Do Morris inorder traversal - should be the same as inorder traversal
    Node<Integer> root1 = root;
    List<Integer> morrisList = new ArrayList<>();
    obj.traverse(root, morrisList);
    Node<Integer> root2 = root;
    System.out.println("Morris traversal: " + inorderList);
    System.out.println("obj.sameBst(root1, root2) = " + obj.sameBst(root1, root2));

    // Do inorder traversal again - should be the same as the earlier inorder traversal
    List<Integer> postMorrisInorderList = new ArrayList<>();
    Traversals.inorder(root, postMorrisInorderList);
    System.out.println("Inorder traversal: " + postMorrisInorderList);
  }

  // Inorder traversal of the tree without recursion and stack
  public void traverse(Node<Integer> root, List<Integer> morrisList) {
    Node<Integer> current = root;
    while (current != null) {
      if (current.lChild() == null) {
        morrisList.add(current.data());
        current = current.rChild();
      } else {
        Node<Integer> rightMostNode = getRightMostNode(current);
        if (rightMostNode.rChild() == null) {
          // Make the inorder predecessor point to self so that we can traverse the tree in one loop
          rightMostNode.rChild(current);
          current = current.lChild();
        } else {
          // Atoning for our sins - revert modifications to the tree
          rightMostNode.rChild(null);
          morrisList.add(current.data());
          current = current.rChild();
        }
      }
    }
  }

  private Node<Integer> getRightMostNode(Node<Integer> root) {
    Node<Integer> current = root.lChild();
    while (current != null && current.rChild() != null && current.rChild() != root) {
      current = current.rChild();
    }
    return current;
  }

  private boolean sameBst(Node<Integer> root1, Node<Integer> root2) {
    if (root1 == null && root2 != null) return false;
    if (root1 != null && root2 == null) return false;
    if (root1 == null && root2 == null) return true;

    return root1.data().equals(root2.data()) && sameBst(root1.lChild(), root2.lChild()) && sameBst(root1.rChild(), root2.rChild());
  }
}
