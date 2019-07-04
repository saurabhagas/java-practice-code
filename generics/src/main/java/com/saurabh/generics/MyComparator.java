package com.saurabh.generics;

import java.util.Comparator;
import java.util.TreeSet;

//Comparable is present in java.lang package, whereas Comparator in java.util
//Comparable is not a FunctionalInterface, whereas Comparator is
/* Comparable has the method called compareTo(T other), whereas Comparator has compare(T first, T second).
 * Comparator also has other method that allow compare logic to be chained.
 */
public class MyComparator implements Comparable<MyComparator>, Comparator<MyComparator> {
  private int num;
  private String text;

  public MyComparator(int num, String text) {
    this.num = num;
    this.text = text;
  }

  @Override
  public String toString() {
    return "" + num;
  }

  @Override
  public int compareTo(MyComparator other) {
    return text.compareTo(other.text);
  }

  @Override
  public int compare(MyComparator first, MyComparator second) {
    return first.num - second.num;
  }

  public static <T> T genericMethod(T t) {
    return t;
  }

  public static void main(String[] args) {
    MyComparator obj1 = new MyComparator(88, "a");
    MyComparator obj2 = new MyComparator(55, "b");

    TreeSet<MyComparator> treeSet = new TreeSet<>();
    treeSet.add(obj1);
    treeSet.add(obj2);
    
    TreeSet<MyComparator> treeSetWithComparator = new TreeSet<>(obj1);
    treeSetWithComparator.add(obj1);
    treeSetWithComparator.add(obj2);

    System.out.println(treeSet + " " + treeSetWithComparator);

    genericMethod("String");
    MyComparator.genericMethod(new Object());
    MyComparator.<String>genericMethod("String");
    MyComparator.<Object>genericMethod("String");
//    MyComparator.<Integer>genericMethod("String"); // Doesn't compile
  }
}
