package com.saurabh.practice.concurrency;

class PrintFooBar {
  private final int max = 50;
  private final Object lock = new Object();
  private boolean firstsTurn = true;

  public static void main(String[] args) {
    PrintFooBar obj = new PrintFooBar();
    new Thread(obj::printFoo).start();
    new Thread(obj::printBar).start();
  }

  public void printFoo() {
    synchronized (lock) {
      for (int i = 1; i <= max; i++) {
        while (!firstsTurn) {
          wait(lock);
        }
        System.out.println("Foo");
        firstsTurn = false;
        lock.notifyAll();
      }
    }
  }

  public void printBar() {
    synchronized (lock) {
      for (int i = 1; i <= max; i++) {
        while (firstsTurn) {
          wait(lock);
        }
        System.out.println("Bar");
        firstsTurn = true;
        lock.notifyAll();
      }
    }
  }

  private void wait(Object lock) {
    try {
      lock.wait();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new RuntimeException(e);
    }
  }
}