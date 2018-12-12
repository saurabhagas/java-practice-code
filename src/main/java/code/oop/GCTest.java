package code.oop;

/**
 * GCTest
 */
public class GCTest {
  static GCTest t = new GCTest();
  static int count = 0;

  public static void main(String[] args) throws InterruptedException {
    GCTest t1 = new GCTest();

    // making t1 eligible for garbage collection
    t1 = null; // line 12

    // calling garbage collector
    System.gc(); // line 15

    // waiting for gc to complete
    Thread.sleep(1000);

    // making t eligible for garbage collection. Otherwise, it will only be done when the class is unloaded
    t = null; // line 21

    // calling garbage collector
    System.gc(); // line 24

    // waiting for gc to complete
    Thread.sleep(4000);

    System.out.println("finalize method called " + count + " times");
  }

  @Override
  protected void finalize() {
    count++;
//    t = this; //Doing this will prevent t from being garbage collected
  }
}
