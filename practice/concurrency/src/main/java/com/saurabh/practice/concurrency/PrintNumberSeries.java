package com.saurabh.practice.concurrency;

import java.util.concurrent.Semaphore;

// print 010203...0n
public class PrintNumberSeries {
  private static final int MAX = 10;
  private final Semaphore zeroPrintingSem = new Semaphore(1);
  private final Semaphore oddPrintingSem = new Semaphore(0);
  private final Semaphore evenPrintingSem = new Semaphore(0);

  public static void main(String[] args) {
    PrintNumberSeries obj = new PrintNumberSeries();
    Thread zeroThread = new Thread(obj::printZero);
    Thread oddThread = new Thread(obj::printOdd);
    Thread evenThread = new Thread(obj::printEven);

    zeroThread.start();
    oddThread.start();
    evenThread.start();
  }

  public void printZero() {
    for (int i = 0; i < MAX; i++) {
      acquireQuietly(zeroPrintingSem);
      System.out.println("0");
      if (i % 2 == 0) {
        oddPrintingSem.release();
      } else {
        evenPrintingSem.release();
      }
    }
  }

  public void printOdd() {
    for (int i = 1; i <= MAX; i += 2) {
      acquireQuietly(oddPrintingSem);
      System.out.println(i);
      zeroPrintingSem.release();
    }
  }

  public void printEven() {
    for (int i = 2; i <= MAX; i += 2) {
      acquireQuietly(evenPrintingSem);
      System.out.println(i);
      zeroPrintingSem.release();
    }
  }

  private void acquireQuietly(Semaphore evenPrintingSem) {
    try {
      evenPrintingSem.acquire();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new RuntimeException(e);
    }
  }
}
