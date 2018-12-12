package code.generics;

public class WeirdGenericClass<C> {
//  C c = new A(); //Doesn't compile
//  C c = new B(); //Doesn't compile
//  C c = new C(); //Doesn't compile - Generic type cannot be instantiated

}

class A {

}

class B extends A {

}

class C extends B {

}