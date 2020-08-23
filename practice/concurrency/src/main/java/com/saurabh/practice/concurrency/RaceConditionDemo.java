package com.saurabh.practice.concurrency;

import java.util.Random;

public class RaceConditionDemo {
  int randInt;
  Random random = new Random(System.currentTimeMillis());

  void printer() {
    for (int i = 0; i < 1000000; i++) {
      if (randInt % 5 == 0) {
        if (randInt % 5 != 0) {
          throw new AssertionError("Should never come here");
        }
      }
    }
  }

  void modifier() {
    for (int i = 0; i < 1000000; i++) {
      randInt = random.nextInt(1000);
    }
  }

  public static void runTest() throws InterruptedException {
    final RaceConditionDemo rc = new RaceConditionDemo();
    Thread printerThread = new Thread(rc::printer);
    Thread modifierThread = new Thread(rc::modifier);

    printerThread.start();
    modifierThread.start();

    printerThread.join();
    modifierThread.join();
  }

  public static void main(String[] args) throws InterruptedException {
    RaceConditionDemo.runTest();
  }
}