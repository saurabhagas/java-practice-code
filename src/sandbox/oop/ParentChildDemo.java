package sandbox.oop;

/**
 * ParentChildDemo
 */
class GoodParent {
  String name;
  GoodParent(String name) {

  }
}

class GoodChild extends GoodParent {
  GoodChild(String name) {
    super(name);
    this.name= name;
  }
}
