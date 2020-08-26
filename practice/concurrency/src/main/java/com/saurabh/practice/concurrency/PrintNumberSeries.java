package com.saurabh.practice.concurrency;

import java.util.concurrent.Semaphore;

// print 010203...0n
public class PrintNumberSeries {
  private final int n;
  private final Semaphore zerosTurn = new Semaphore(1);
  private final Semaphore oddTurn = new Semaphore(0);
  private final Semaphore evenTurn = new Semaphore(0);

  public PrintNumberSeries(int n) {
    this.n = n;
  }

  public void printZero() {
    for (int i = 1; i <= n; ++i) {
      safeAcquire(zerosTurn);
      System.out.print(0);

      if (i % 2 == 0) {
        evenTurn.release();
      } else {
        oddTurn.release();
      }
    }
  }

  public void printOdd() {
    for (int i = 1; i <= n; i += 2) {
      safeAcquire(oddTurn);
      System.out.print(i);
      zerosTurn.release();
    }
  }

  public void printEven() {
    for (int i = 2; i <= n; i += 2) {
      safeAcquire(evenTurn);
      System.out.print(i);
      zerosTurn.release();
    }
  }

  private void safeAcquire(Semaphore semaphore) {
    try {
      semaphore.acquire();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) {
    final int n = 39;
    PrintNumberSeries obj = new PrintNumberSeries(n);
    new Thread(obj::printEven).start();
    new Thread(obj::printZero).start();
    new Thread(obj::printOdd).start();
  }
}
