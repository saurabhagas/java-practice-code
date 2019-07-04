package com.saurabh.generics;

import java.util.ArrayList;
import java.util.List;

public class BoundedWildcards {
  public static void main(String[] args) {
    List<? extends Feline> felines = new ArrayList<Feline>();
//    List<Cat> felines2 = new ArrayList<Feline>(); //Doesn't compile
//    felines.add(new Feline()); //Doesn't compile - type of object not known at comile time
//    felines.add(new Cat()); //Doesn't compile - type of object not known at comile time
//    felines.add(new Animal()); //Doesn't compile - type of object not known at comile time

    List<? super Feline> catFamily = new ArrayList<Animal>();
    catFamily.add(new Feline());
    catFamily.add(new Cat());
//    catFamily.add(new Animal()); //Doesn't compile - type of object not known at comile time

    List<? super Integer> list = new ArrayList<Object>();
    list.add(5);
    list.add(new Integer(5));
//    list.add(new Object());
    for (Object integer : list) {
      System.out.println(integer);
    }
    List<? super Integer> list2 = new ArrayList<Number>();
    List<? super Integer> list3 = new ArrayList<Integer>();
  }
}

class Animal {

}

class Feline extends Animal {

}

class Cat extends Feline {

}

class Elephant extends Animal {

}

