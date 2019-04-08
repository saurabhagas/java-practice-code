package code.collections.custom.impl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class BST {
  private Node root;

  public static void main(String[] args) {
    System.out.println("Enter space-separated node integers to construct BST:");
    Scanner scanner = new Scanner(System.in);
    BST bst = new BST();
    Arrays.stream(scanner.nextLine().split(" ")).map(Integer::valueOf).forEach(bst::insert);
    System.out.println("Tree construction successful");

    int userInput;
    while (true) {
      System.out.println();
      System.out.println("Choose next action:");
      System.out.println("  1: Add node");
      System.out.println("  2: Remove node");
      System.out.println("  3: Search node");
      System.out.println("  4: Balance tree");
      System.out.println("  5: Equals check");
      System.out.println("  6: Print tree");
      System.out.println("  7: Exit");
      userInput = scanner.nextInt();
      switch (userInput) {
        case 1:
          insertAction(scanner, bst);
          break;
        case 2:
          removeAction(scanner, bst);
          break;
        case 3:
          searchAction(scanner, bst);
          break;
        case 4:
          balanceAction(bst);
          break;
        case 5:
          equalsAction(scanner, bst);
          break;
        case 6:
          printAction(scanner, bst);
          break;
        case 7:
          System.exit(0);
        default:
          System.out.println("Invalid input.");
      }
    }
  }

  private static void equalsAction(Scanner scanner, BST bst) {
    while (true) {
      System.out.println();
      System.out.println("Choose next action:");
      System.out.println("  1: Equals check with another BST");
      System.out.println("  2: Return to previous menu");
      System.out.println("  3: Exit program");

      int subInput = scanner.nextInt();
      switch (subInput) {
        case 1:
          BST otherBst = new BST();
          scanner.nextLine();
          Arrays.stream(scanner.nextLine().split(" ")).map(Integer::valueOf).forEach(otherBst::insert);
          final boolean areEqual = bst.equals(otherBst);
          System.out.println("Trees equal? " + areEqual);
          break;
        case 2:
          break;
        case 3:
          System.exit(0);
        default:
          System.out.println("Invalid input.");
      }

      if (subInput == 2) {
        break;
      }
    }

  }

  private static void balanceAction(BST bst) {
    bst.balance();
  }

  private static void searchAction(Scanner scanner, BST bst) {
    while (true) {
      System.out.println();
      System.out.println("Choose next action:");
      System.out.println("  1: Search node");
      System.out.println("  2: Return to previous menu");
      System.out.println("  3: Exit program");

      int subInput = scanner.nextInt();
      switch (subInput) {
        case 1:
          Node foundLocation = bst.find(scanner.nextInt());
          System.out.println("Node found? " + (foundLocation != null));
          break;
        case 2:
          break;
        case 3:
          System.exit(0);
        default:
          System.out.println("Invalid input.");
      }

      if (subInput == 2) {
        break;
      }
    }
  }

  private static void removeAction(Scanner scanner, BST bst) {
    while (true) {
      System.out.println();
      System.out.println("Choose next action:");
      System.out.println("  1: Remove node");
      System.out.println("  2: Return to previous menu");
      System.out.println("  3: Exit program");
      int subInput = scanner.nextInt();
      switch (subInput) {
        case 1:
          boolean removed = bst.remove(scanner.nextInt());
          System.out.println("Node removed? " + removed);
          break;
        case 2:
          break;
        case 3:
          System.exit(0);
        default:
          System.out.println("Invalid input.");
      }

      if (subInput == 2) {
        break;
      }
    }
  }

  private static void insertAction(Scanner scanner, BST bst) {
    while (true) {
      System.out.println();
      System.out.println("Choose next action:");
      System.out.println("  1: Enter node data");
      System.out.println("  2: Return to previous menu");
      System.out.println("  3: Exit program");
      int subInput = scanner.nextInt();
      switch (subInput) {
        case 1:
          boolean added = bst.insert(scanner.nextInt());
          System.out.println("Node added? " + added);
          break;
        case 2:
          break;
        case 3:
          System.exit(0);
        default:
          System.out.println("Invalid input.");
      }

      if (subInput == 2) {
        break;
      }
    }
  }

  private static void printAction(Scanner scanner, BST bst) {
    while (true) {
      System.out.println();
      System.out.println("Pick print mode:");
      System.out.println("    1. Level order traversal (Breadth-first search)");
      System.out.println("    2. Preorder traversal (Depth-first search)");
      System.out.println("    3. Inorder traversal (Depth-first search)");
      System.out.println("    4. Postorder traversal (Depth-first search)");
      System.out.println("    5. toString() (Depth-first search, equivalent to preorder)");
      System.out.println("    6. Return to previous menu");
      System.out.println("    7. Exit program");
      int subInput = scanner.nextInt();
      switch (subInput) {
        case 1:
          bst.levelOrder();
          break;
        case 2:
          bst.preOrder(bst.root);
          break;
        case 3:
          bst.inOrder(bst.root);
          break;
        case 4:
          bst.postOrder(bst.root);
          break;
        case 5:
          System.out.println(bst.toString());
          break;
        case 6:
          break;
        case 7:
          System.exit(0);
        default:
          System.out.println("Invalid input.");
      }

      if (subInput == 6) {
        break;
      }
    }
  }

  public boolean remove(int data) {
    Node current = root;
    Node foundLocationParent = null;
    Node foundLocation = null;
    while (current != null) {
      if ((current.leftChild != null && current.leftChild.data == data) || (current.rightChild != null && current.rightChild.data == data)) {
        foundLocationParent = current;
      }
      if (data < current.data) {
        current = current.leftChild;
      } else if (data > current.data) {
        current = current.rightChild;
      } else {
        foundLocation = current;
        break;
      }
    }
    if (foundLocation == null) {
      return false; // Node to be deleted not present
    } else {
      if (foundLocation.leftChild == null && foundLocation.rightChild == null) {
        if (foundLocationParent.leftChild == foundLocation) {
          foundLocationParent.leftChild = null;
        } else {
          foundLocationParent.rightChild = null;
        }
      } else if (foundLocation.leftChild == null && foundLocation.rightChild != null) {
        foundLocation.data = foundLocation.rightChild.data;
        foundLocation.rightChild = null;
      } else if (foundLocation.leftChild != null && foundLocation.rightChild == null) {
        foundLocation.data = foundLocation.leftChild.data;
        foundLocation.leftChild = null;
      } else {
        // Both children present, swap node with inorder successor
        current = foundLocation.rightChild; // start from the right subtree
        Node inorderSuccessorParent = null;
        Node inorderSuccessor;
        while (current != null && current.leftChild != null) {
          if (current.leftChild.leftChild == null) {
            inorderSuccessorParent = current;
          }
          current = current.leftChild;
        }
        inorderSuccessor = current;

        if (inorderSuccessor.rightChild == null) {
          foundLocation.data = inorderSuccessor.data;
          inorderSuccessorParent.leftChild = null;
        } else {
          foundLocation.data = inorderSuccessor.data;
          inorderSuccessor.data = inorderSuccessor.rightChild.data;
          inorderSuccessor.rightChild = null;
        }
      }
      return true;
    }
  }

  public Node find(int data) {
    Node current = root;
    while (current != null) {
      if (data < current.data) {
        current = current.leftChild;
      } else if (data > current.data) {
        current = current.rightChild;
      } else {
        return current;
      }
    }
    return null;
  }

  public boolean insert(int data) {
    Node temp = new Node(data, null, null);
    Node current = root;
    while (current != null) {
      if (data < current.data) {
        if (current.leftChild == null) {
          current.leftChild = temp;
          break;
        }
        current = current.leftChild;
      } else if (data > current.data) {
        if (current.rightChild == null) {
          current.rightChild = temp;
          break;
        }
        current = current.rightChild;
      } else {
        return false;
      }
    }

    if (root == null) {
      root = temp;
    }
    return true;
  }

  public void levelOrder() {
    Deque<Node> deque = new ArrayDeque<>();
    offerNonNull(deque, root);

    while (!deque.isEmpty()) {
      final Node current = deque.poll();
      System.out.println(current.data);
      offerNonNull(deque, current.leftChild);
      offerNonNull(deque, current.rightChild);
    }
  }

  private void offerNonNull(Deque<Node> deque, Node node) {
    if (node != null) {
      deque.offer(node);
    }
  }

  private void pushNonNull(Deque<Node> deque, Node node) {
    if (node != null) {
      deque.push(node);
    }
  }

  public void preOrder(Node root) {
    if (root != null) {
      System.out.println(root.data);
      preOrder(root.leftChild);
      preOrder(root.rightChild);
    }
  }

  public void inOrder(Node root) {
    if (root != null) {
      inOrder(root.leftChild);
      System.out.println(root.data);
      inOrder(root.rightChild);
    }
  }

  public void inOrder(Node root, List<Integer> inorderTraversal) {
    if (root != null) {
      inOrder(root.leftChild, inorderTraversal);
      inorderTraversal.add(root.data);
      inOrder(root.rightChild, inorderTraversal);
    }
  }

  public void postOrder(Node root) {
    if (root != null) {
      postOrder(root.leftChild);
      postOrder(root.rightChild);
      System.out.println(root.data);
    }
  }

  /**
   * One time balancing of the BST. Saves the inorder (i.e. sorted data) traversal of the original tree, nullifies the tree,
   * and constructs a new tree recursively from this sorted list. Works on O(n) time and O(n) space.
   */
  public void balance() {
    final ArrayList<Integer> list = new ArrayList<>();
    inOrder(root, list);
    root = null; // Nullify root, making the entire tree eligible for GC
    insertRecurse(list, 0, list.size());
    System.out.println("Tree balancing done");
  }

  private void insertRecurse(List<Integer> list, int low, int high) {
    if (low < high) {
      int mid = (low + high) / 2;
      insert(list.get(mid));
      insertRecurse(list, low, mid);
      insertRecurse(list, mid + 1, high);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    BST other = (BST) o;

    Deque<Node> thisDeque = new ArrayDeque<>();
    Deque<Node> otherDeque = new ArrayDeque<>();
    offerNonNull(thisDeque, this.root);
    offerNonNull(otherDeque, other.root);

    while (!thisDeque.isEmpty() && !otherDeque.isEmpty()) {
      final Node thisCurrent = thisDeque.poll();
      final Node otherCurrent = otherDeque.poll();
      if (thisCurrent.data != otherCurrent.data) {
        return false;
      }

      offerNonNull(thisDeque, thisCurrent.leftChild);
      offerNonNull(thisDeque, thisCurrent.rightChild);
      offerNonNull(otherDeque, otherCurrent.leftChild);
      offerNonNull(otherDeque, otherCurrent.rightChild);
    }

    if ((!thisDeque.isEmpty() && otherDeque.isEmpty()) || (thisDeque.isEmpty() && !otherDeque.isEmpty())) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    List<Node> allElements = new ArrayList<>();
    Deque<Node> deque = new ArrayDeque<>();
    offerNonNull(deque, root);

    while (!deque.isEmpty()) {
      final Node current = deque.poll();
      allElements.add(current);
      System.out.println(current.data);
      offerNonNull(deque, current.leftChild);
      offerNonNull(deque, current.rightChild);
    }

    return Objects.hash(allElements.toArray());
  }

  /**
   * Prints preorder traversal using stacks
   *
   * @return nodes as a String
   */
  @Override
  public String toString() {
    final StringBuilder nodesAsString = new StringBuilder();
    Deque<Node> deque = new ArrayDeque<>();
    pushNonNull(deque, root);

    while (!deque.isEmpty()) {
      final Node current = deque.pop();
      nodesAsString.append(current.data).append(" ");
      pushNonNull(deque, current.rightChild);
      pushNonNull(deque, current.leftChild);
    }

    return nodesAsString.toString().trim();
  }

  private class Node {
    private int data;
    private Node leftChild;
    private Node rightChild;

    Node(int data, Node leftChild, Node rightChild) {
      this.data = data;
      this.leftChild = leftChild;
      this.rightChild = rightChild;
    }
  }
}
