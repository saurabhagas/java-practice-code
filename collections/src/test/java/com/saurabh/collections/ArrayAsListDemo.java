package com.saurabh.collections;

import java.util.Arrays;
import java.util.List;

/**
* Demo of {@code Arrays.asList}
*/
public class ArrayAsListDemo {
  public static void main(String[] args) {
    String[] array = { "gerbil", "mouse" }; // [gerbil, mouse]
    List<String> list = Arrays.asList(array); // returns fixed size list
    list.set(1, "test"); // [gerbil, test]
//    list.remove(1); // Throws UnsupportedException
    System.out.println(list);

    array[0] = "new"; // [new, test]
    System.out.println(array[0] + array[1]);

    String[] array2 = (String[]) list.toArray(); // [new, test]
    System.out.println(array2[0] + array2[1]);
  }
}
