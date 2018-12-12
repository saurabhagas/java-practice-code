package code.oop;

/**
 * InstanceofTest
 */
public class InstanceofTest {
  static interface Furry {}
  static class Chipmunk {}
  static class FurryChipmunk implements Furry {}

  public static void main(String[] args) {
    Chipmunk chipmunk = new Chipmunk();
    int result = 0;
    if (chipmunk instanceof Furry) {
      result += 1;
    }

    if (chipmunk instanceof Chipmunk) {
      result += 2;
    }

    if (null instanceof Chipmunk) {
      result += 3;
    }

    System.out.println(result);
  }
}
