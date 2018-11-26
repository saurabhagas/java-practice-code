package sandbox.oop;

import java.io.IOException;

class Parent {
  String identifier = "Parent";

  int doSomething() throws IOException {
    return 0;
  }

  private int another() {
    return 0;
  }

  static void test() {
  }

  void printName() {
    System.out.println(identifier);
  }

  void overrideMe() {
    System.out.println("In " + identifier);
  }
}

class Child extends Parent {
  String identifier = "Child";

//  void test() {} //Doesn't compile

  static void test() {
    //Hides test() from parents, doesn't override it
  }

  @Override
  int doSomething() {
    // Works despite this method not throwing any exception
    return -1;
  }

  int another() {
    return 0; //Isn't overriding another() of Parent
  }

  @Override
  void overrideMe() throws RuntimeException {
    // Works because overridden methods can throw runtime exceptions
    System.out.println("In " + identifier);
  }

  public static void main(String[] args) {
    System.out.println("Parent parent = new Parent()");
    Parent parent = new Parent();
    parent.printName();
    parent.overrideMe();

    System.out.println("\nChild child = new Child()");
    Child child = new Child();
    child.printName();
    child.overrideMe();

    System.out.println("\nParent parentChild = new Child()");
    Parent parentChild = new Child();
    System.out.println(parentChild.identifier); //Prints 'Parent'
    parentChild.printName();
    parentChild.overrideMe();
  }
}
