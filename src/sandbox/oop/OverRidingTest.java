package sandbox.oop;

import java.io.IOException;

class Base {
  String identifier = "Base";
  int doSomething() throws IOException { return 0;}
  private int another() { return 0;}
  static void test() {}
  
  void printName() {
    System.out.println(identifier);
  }

  void overrideMe() {
    System.out.println("In " + identifier);
  }
}
class Child extends Base {
  String identifier = "Child";
  //void test() {} //Doesn't compile
  static void test() {} //Hides test() from parents, doesn't override it
  
  @Override
  int doSomething() { return -1;}

  int another() { return 0;} //OK

  @Override
  void overrideMe() {
    System.out.println("In " + identifier);
  }

  public static void main(String[] args) {
    Base base = new Base();
    base.printName();
    base.overrideMe();

    Child child = new Child();
    child.printName();
    child.overrideMe();

    Base baseChild = new Child();
    baseChild.printName();
    baseChild.overrideMe();
  }
}
