package com.saurabh.practice.concurrency;

import java.util.HashSet;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Barber shop simulator with one chair and MAX_SEATS sized waiting queue.
 */
public class BarberShop {
  private static final int MAX_SEATS = 3;
  private Thread barberThread;
  private int hairCutsGiven = 0;
  private final AtomicInteger waitingCustomers = new AtomicInteger(-1);
  private final Semaphore customerWaiter = new Semaphore(0);
  private final Semaphore cuttingDone = new Semaphore(0);

  public void customer() {
    try {
      // if wait queue full, leave
      if (waitingCustomers.get() == MAX_SEATS) {
        System.out.println(Thread.currentThread().getName() + ":: Customer walks out, all seats occupied");
        return;
      }
      waitingCustomers.incrementAndGet();
      System.out.println(Thread.currentThread().getName() + ":: Customer waiting in position " + waitingCustomers.get());
      customerWaiter.release();
      cuttingDone.acquire();
      waitingCustomers.decrementAndGet();
    } catch (InterruptedException e) {
      System.out.println(Thread.currentThread().getName() + ":: Customer thread interrupted");
      throw new RuntimeException(e);
    }
  }

  public void barber() {
    try {
      while (true) {
        System.out.println("Barber:: Waiting for customers...");
        customerWaiter.acquire();
        System.out.println("Barber:: Woken up from sleep!");
        hairCutsGiven++;
        System.out.println("Barber:: Cutting hair " + hairCutsGiven + "th time");
        Thread.sleep(50);
        cuttingDone.release();
      }
    } catch (InterruptedException e) {
      System.out.println("Barber:: thread interrupted");
    }
  }

  public static void main(String[] args) throws InterruptedException {
    HashSet<Thread> threads = new HashSet<>();
    final BarberShop barberShop = new BarberShop();

    barberShop.barberThread = new Thread(barberShop::barber);
    barberShop.barberThread.start();

    for (int i = 0; i < 10; i++) {
      Thread t = new Thread(barberShop::customer);
      t.setName("Customer_" + i);
      threads.add(t);
    }
    startAndJoinOnThreads(threads);

    threads.clear();
    Thread.sleep(800);

    for (int i = 10; i < 15; i++) {
      Thread t = new Thread(barberShop::customer);
      t.setName("Customer_" + i);
      threads.add(t);
    }

    startAndJoinOnThreads(threads);
    Thread.sleep(800);
    barberShop.barberThread.interrupt(); //All done, interrupt the barber now
  }

  private static void startAndJoinOnThreads(HashSet<Thread> threads) throws InterruptedException {
    threads.forEach(Thread::start);
    for (Thread t : threads) {
      t.join();
    }
  }
}
