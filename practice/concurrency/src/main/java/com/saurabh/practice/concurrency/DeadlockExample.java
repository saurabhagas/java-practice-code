package com.saurabh.practice.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Taken from https://docs.oracle.com/javase/tutorial/essential/concurrency/deadlock.html
public class DeadlockExample {
  private final Lock lock1 = new ReentrantLock();
  private final Lock lock2 = new ReentrantLock();

  public static void main(String[] args) {
    DeadlockExample example = new DeadlockExample();
    // starts and acquires lock 1
    Thread thread1 = new Thread(example.new Acquirer(example.lock1, example.lock2), "thread-1");
    thread1.start();
    // starts and acquires lock 2
    Thread thread2 = new Thread(example.new Acquirer(example.lock2, example.lock1), "thread-2");
    thread2.start();
  }

  private final class Acquirer implements Runnable {
    private final Lock lock1;
    private final Lock lock2;

    public Acquirer(Lock lock1, Lock lock2) {
      this.lock1 = lock1;
      this.lock2 = lock2;
    }

    @Override
    public void run() {
      System.out.println("Acquiring lock: " + lock1 + " in thread: " + Thread.currentThread().getName());
      lock1.lock();

      System.out.println("Acquiring lock: " + lock2 + " in thread: " + Thread.currentThread().getName());
      lock2.lock();
    }
  }
}