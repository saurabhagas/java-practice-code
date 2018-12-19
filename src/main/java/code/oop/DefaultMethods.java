package code.oop;

public class DefaultMethods {
  interface PI1 {
    static void staticShow() {
      System.out.println("Static PI1");
    }

    default void show() {
      System.out.println("Default PI1");
    }
  }

  interface PI2 {
    default void show() {
      System.out.println("Default PI2");
    }
  }

  static class TestClass implements PI1, PI2 {
    // default method needs to be overridden in order for this class to compile
    public void show() {
      PI1.super.show();
      PI2.super.show();
    }

    public static void main(String[] args) throws Exception {
      TestClass d = TestClass.class.newInstance(); //Reflective way of instantiation
      d.show();
      PI1.staticShow(); //PI1::staticShow cannot be accessed via object reference
    }
  }
}
