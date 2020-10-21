package com.saurabh.conceptual.oop;

import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
  public static void main(String[] args) {
    completedFuture();
    runAsync();
  }

  private static void runAsync() {
    CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
      System.out.println("From inside the completable future. " +
          "Thread: " + Thread.currentThread().getName() + ", is daemon: " + Thread.currentThread().isDaemon());
      System.out.println("CF Sleeping for 5 seconds at: " + LocalTime.now());
      sleep(5000);
      System.out.println("CF woke up at: " + LocalTime.now());
    });
    System.out.println("Completable future is done? " + cf.isDone()); // should be false

    System.out.println("Main thread Sleeping for 10 seconds at: " + LocalTime.now());
    sleep(10000);
    System.out.println("Main thread woke up at: " + LocalTime.now());

    System.out.println("Completable future is done? " + cf.isDone()); // should be true now
  }

  private static void completedFuture() {
    CompletableFuture<String> completableFuture = CompletableFuture.completedFuture("done");
    System.out.println(completableFuture.isDone()); // should be true
    System.out.println(completableFuture.getNow("default-for-absent-case")); // should be true
  }

  private static void sleep(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
