package com.saurabh.concurrent;

/**
 * Program to display effects of memory consistency of a non-volatile variable for multiple threads.
 */
public class MemoryVisibilityExample {
  private static int counter = 0;

  public static void main(String[] args) {
    Runnable runnable = () -> {
      for (int i = 0; i < 500; i++) {
        System.out.println("Previous value: " + counter + ", incrementing to: " + (counter + 1));
        counter += 1;
      }
    };

    new Thread(runnable).start();
    while (counter < 100) {
      System.out.println("Main thread saw value of counter as: " + counter);
      System.out.println("Not reached yet");
    }
    System.out.println("Reached!");
  }
}
