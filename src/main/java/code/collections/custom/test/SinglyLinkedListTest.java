package code.collections.custom.test;

import code.collections.custom.impl.CustomLinkedList;
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

  @Test
  public void testFlattenMultiLevelList() {
    CustomLinkedList<CustomLinkedList<String>> multilevelList = new SinglyLinkedList<>();

    SinglyLinkedList<String> firstList = new SinglyLinkedList<>();
    firstList.insert("Saurabh");
    firstList.insert("is");
    firstList.insert("an");
    firstList.insert("Adarsh");
    firstList.insert("Balak");
    firstList.print();

    SinglyLinkedList<String> secondList = new SinglyLinkedList<>();
    secondList.insert("And");
    secondList.insert("so");
    secondList.insert("is");
    secondList.insert("Amma");
    secondList.print();

    SinglyLinkedList<String> thirdList = new SinglyLinkedList<>();
    thirdList.insert("But");
    thirdList.insert("who");
    thirdList.insert("has");
    thirdList.insert("an");
    thirdList.insert("X-Ray");
    thirdList.insert("machine?");
    thirdList.print();

    //Add all the lists
    multilevelList.insert(firstList);
    multilevelList.insert(secondList);
    multilevelList.insert(thirdList);
    multilevelList.print();

    SinglyLinkedList<String> flattenedList = new SinglyLinkedList<>();
    flattenedList.insertAll(firstList);
    flattenedList.insertAll(secondList);
    flattenedList.insertAll(thirdList);
    flattenedList.print();
  }
}
