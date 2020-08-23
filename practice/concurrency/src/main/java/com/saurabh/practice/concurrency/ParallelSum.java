package com.saurabh.practice.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Demonstrates an example of a large sum being calculated by dividing the number into smaller numbers, such that each
 * executor thread calculate its own sum. The main thread collects those results and prints the final sum.
 */
public class ParallelSum {
  public void testParallelSumUsingMultipleThreads() throws Exception {
    final int numbersToSum = 1000;
    final int numThreads = 10;
    final ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
    AtomicInteger threadId = new AtomicInteger(0);
    List<Future<Integer>> tasks = new ArrayList<>();

    for (int i = 0; i < numThreads; i++) {
      tasks.add(executorService.submit(() -> {
        final int perThreadRange = numbersToSum / numThreads;
        int lowerBoundary = 1 + perThreadRange * threadId.getAndIncrement();
        int upperBoundary = perThreadRange * threadId.get();
        return rangeSum(lowerBoundary, upperBoundary);
      }));
    }

    executorService.shutdown();
    executorService.awaitTermination(2, TimeUnit.MINUTES);

    int sum = 0;
    for (int i = 0; i < numThreads; i++) {
      sum += tasks.get(i).get();
    }
    System.out.println(sum);
  }

  private int rangeSum(int lowerBoundary, int upperBoundary) {
    // Showing off here really - the following code can be replaced by a for loop
    return IntStream.iterate(lowerBoundary, operand -> operand + 1).limit(upperBoundary - lowerBoundary + 1).sum();
  }

  public static void main(String[] args) throws Exception {
    ParallelSum obj = new ParallelSum();
    obj.testParallelSumUsingMultipleThreads();
  }
}
