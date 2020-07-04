package com.saurabh.conceptual.oop;

public class Outer {
  private int INT = 50;
  private static int INTEGER = 50;
  static enum Properties {//static is redundant, because nested enums are always static since the constants they define are static final
    A, B, C;

    Properties() {
    }
  }

  public static void main(String[] args) {
    System.out.println(new Outer().new Inner().number);
  }
  static interface InnerInterface { //static is redundant, because nested interfaces are always static since the constants they define are static final
    default void printAll() {
//      System.out.println(INT); Doesn't compile - can't refer non-static field from static context
      System.out.println(INTEGER);
    }

    static void doMe() {
      System.out.println("Did me");
    }
    void anotherMethod();
  }
  
  class Inner implements InnerInterface {
    @Override
    public void anotherMethod() {

    }

//    @Override
    public void doMe() {
      System.out.println("Did something in child");
    }

    private int number = 5;
    public static final int staticNumber = 5; //Compile time constants are allowed
//    public static int staticNumber = 5; //This is not allowed
    
//    static void doSomething() {} //Not allowed either
    public void printAll() {
      number--;
      System.out.println(number);
      INT++; //Can access private members of the outer class directly
      Outer outer = Outer.this;
      System.out.println(outer.new Inner2().increment());
      System.out.println(outer.INT); //This syntax when there's a identifier collision
    }
  }
  
  class Inner2 {
    int number = 500;
    
    int increment() {
      return ++number;
    }
  }
}
