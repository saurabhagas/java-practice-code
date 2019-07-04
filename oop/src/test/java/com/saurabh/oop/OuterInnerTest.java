package com.saurabh.oop;

//import static Chapter1.Outer.Inner; //Doesn't work

import org.junit.Test;

public class OuterInnerTest {
  private Outer outer;
  @Test
  public void test() {
    outer = new Outer();
    Outer.Inner inner = outer.new Inner();
    inner.printAll();

    Outer.Inner2 inner2 = outer.new Inner2();
    System.out.println(inner2.increment());

    //This is how to specify an anonymous class implementing an inner interface because Inner interfaces are always static
    Outer.InnerInterface innerInterface = new Outer.InnerInterface() {
      @Override
      public void anotherMethod() {
        System.out.println("Overridden method in inner interface" + outer);
      }
    };
    Outer.InnerInterface innerInterface2 = () -> System.out.println("Overridden method in inner interface"); //Lambda
    innerInterface.printAll();
    innerInterface.anotherMethod();
  }
}
