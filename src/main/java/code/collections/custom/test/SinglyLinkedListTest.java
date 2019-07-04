package code.collections.custom.test;

import code.algorithms.sorting.BubbleSorter;
import code.collections.custom.impl.SinglyLinkedList;
import org.junit.Test;

public class SinglyLinkedListTest {
  @Test
  public void testIntegerList() {
    /*SinglyLinkedList of Integers*/
    SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
    linkedList.insert(5);
    linkedList.insert(50);
    linkedList.insert(500);
    linkedList.insert(5000);
    //      linkedList.insert(-500);
    //      linkedList.insert(15);
    //      linkedList.insert(25);

    //      linkedList.delete(25); //Delete first element
    //      linkedList.delete(5);//Delete last element
    //      linkedList.delete(500); //Delete any element
    //      linkedList.delete(786); //Non-existent element

    linkedList.print();
  }

  @Test
  public void testSort() {
    SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
    linkedList.insert(5);
    linkedList.insert(5000);
    linkedList.insert(50);
    linkedList.insert(500);
    linkedList.print();

    linkedList.sort(new BubbleSorter<>());
    linkedList.print();
  }

  @Test
  public void testStringList() {
    /*SinglyLinkedList of Strings*/
    SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
    linkedList.insert("Behen");
    linkedList.insert("Amma");
    linkedList.insert("Mayya");

    String delete = "Amma";
    System.out.println("Deleted " + delete + "? " + linkedList.delete(delete)); //Existent element
    delete = "Cool";
    System.out.println("Deleted " + delete + "? " + linkedList.delete(delete)); //Non-existent element

    linkedList.print();
  }
}
