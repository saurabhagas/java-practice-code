package sandbox.generics;

import java.util.TreeSet;

public class TreeSetDemo {
  public static void main(String[] args) {
    TreeSet<String> treeSet = new TreeSet<>();
    treeSet.add("one");
    treeSet.add("One");
    treeSet.add("ONE");
    // Will be sorted in ascending order as ONE One one
    System.out.println(treeSet.ceiling("One")); //returns the next (or the same, if available) largest element
    System.out.println(treeSet.ceiling("On"));

    System.out.println(treeSet.floor("One"));
    System.out.println(treeSet.floor("On"));
  }
}
