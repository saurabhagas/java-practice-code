package com.saurabh.practice.concurrency;

class Demo {
  public static void main(String[] args) throws InterruptedException {
    InterruptExample.example();
  }
}

class InterruptExample {
  static public void example() throws InterruptedException {
    final Thread sleepyThread = new Thread(() -> {
      try {
        System.out.println("I am too sleepy... Let me sleep for an hour.");
        Thread.sleep(1000 * 60 * 60);
      } catch (InterruptedException ie) {
        System.out.println("The interrupt flag is cleared: " + Thread.currentThread().isInterrupted());
        Thread.currentThread().interrupt();
        System.out.println("Oh someone woke me up ! ");
        System.out.println("The interrupt flag is set now: " + Thread.currentThread().isInterrupted());
      }
    });

    sleepyThread.start();

    System.out.println("About to wake up the sleepy thread ...");
    sleepyThread.interrupt();
    System.out.println("Woke up sleepy thread ...");

    sleepyThread.join();
  }
}
