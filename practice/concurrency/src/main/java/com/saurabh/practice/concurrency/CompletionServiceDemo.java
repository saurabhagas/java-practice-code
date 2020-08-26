package com.saurabh.practice.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletionServiceDemo {
  private static final Random random = new Random(System.currentTimeMillis());

  public static void main(String[] args) throws Exception {
    completionServiceExample();
  }

  static void completionServiceExample() throws Exception {

    class TrivialTask implements Runnable {
      private final int n;

      public TrivialTask(int n) {
        this.n = n;
      }

      public void run() {
        try {
          // sleep for one second
          Thread.sleep(random.nextInt(101));
          System.out.println(n * n);
        } catch (InterruptedException ie) {
          // swallow exception
        }
      }
    }

    ExecutorService executorService = Executors.newFixedThreadPool(3);
    ExecutorCompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);

    // Submit 10 trivial tasks.
    for (int i = 0; i < 10; i++) {
      completionService.submit(new TrivialTask(i), i);
    }

    // wait for all tasks to get done
    int count = 10;
    while (count != 0) {
      Future<Integer> f = completionService.poll();
      if (f != null) {
        System.out.println("Thread" + f.get() + " got done.");
        count--;
      }
    }

    executorService.shutdown();
  }
}