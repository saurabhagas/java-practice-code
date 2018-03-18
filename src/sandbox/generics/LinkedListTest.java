package sandbox.generics;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LinkedListTest
 */
public class LinkedListTest {
  public static void main(String[] args) {
    List list = new LinkedList();
    list.add(null);
    list.add("1");
    list.add(4);
    list.set(1, "Saurabh");
    Queue queue = (Queue) list;
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
  }
}
