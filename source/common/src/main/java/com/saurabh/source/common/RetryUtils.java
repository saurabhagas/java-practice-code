package com.saurabh.source.common;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static java.lang.Math.min;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class RetryUtils {
  public static boolean waitFor(Callable<Boolean> condition, long maxWaitTimeMillis) {
    return waitFor(condition, maxWaitTimeMillis, MILLISECONDS);
  }

  public static boolean waitFor(Callable<Boolean> condition, long maxWaitDuration, TimeUnit timeUnit) {
    TimeBudget timeBudget = new TimeBudget(maxWaitDuration, timeUnit);
    long currRetryTime = min(maxWaitDuration, 100);
    ExecutorService executorService = Executors.newSingleThreadExecutor(Thread::new);
    boolean success = false;

    while (timeBudget.remaining() > 0 && !Thread.currentThread().isInterrupted()) {
      long timeout = min(currRetryTime, timeBudget.remaining()); //Keep track of how much time remains
      Future<Boolean> future = executorService.submit(condition);
      if (getResult(timeout, future)) {
        System.out.println("Condition became true after " + (maxWaitDuration - timeBudget.remaining()) + " " + timeUnit.name().toLowerCase());
        success = true;
        break;
      } else {
        sleep(currRetryTime);
        currRetryTime *= 2; //Double retry timeout on each failure
      }
    }

    cleanup(executorService);
    return success;
  }

  private static void sleep(long currRetryTime) {
    try {
      Thread.sleep(currRetryTime);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  private static Boolean getResult(long timeout, Future<Boolean> future) {
    try {
      return future.get(timeout, MILLISECONDS);
    } catch (InterruptedException | ExecutionException | TimeoutException e) {
      return false;
    }
  }

  private static void cleanup(ExecutorService executorService) {
    try {
      executorService.shutdownNow();
      executorService.awaitTermination(1, MILLISECONDS);
    } catch (InterruptedException e) {
      // Ignore
    }
  }
}
