package com.saurabh.practice.concurrency;

class PrintFooBar {
  private final int max = 50;
  private volatile boolean turn = true;

  public static void main(String[] args) {
    PrintFooBar obj = new PrintFooBar();
    new Thread(obj::printFoo).start();
    new Thread(obj::printBar).start();
  }

  public void printFoo() {
    for (int i = 1; i <= max; i++) {
      while (!turn) ;
      System.out.println();
      System.out.print("Foo");
      turn = false;
    }
  }

  public void printBar() {
    for (int i = 1; i <= max; i++) {
      while (turn) ;
      System.out.print("Bar");
      turn = true;
    }
  }
}