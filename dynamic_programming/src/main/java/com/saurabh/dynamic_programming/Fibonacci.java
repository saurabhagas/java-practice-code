package com.saurabh.dynamic_programming;

/**
 * Dynamic Programming implementations for Fibonacci
 */
public class Fibonacci {
  public static void main(String[] args) {
    Fibonacci fibonacci = new Fibonacci();
    long startTime = System.nanoTime();
    long fibonacciSum = fibonacci.fibonacciSum(10);
    long endTime = System.nanoTime();
    System.out.println("Result recursion: " + fibonacciSum + ". Time taken: " + (endTime - startTime));

    startTime = System.nanoTime();
    fibonacciSum = fibonacci.fibonacciSumMemoized(10);
    endTime = System.nanoTime();

    System.out.println("Result Memoization: " + fibonacciSum + ". Time taken: " + (endTime - startTime));

    startTime = System.nanoTime();
    fibonacciSum = fibonacci.fibonacciSumTabulized(10);
    endTime = System.nanoTime();

    System.out.println("Result Tabulized: " + fibonacciSum + ". Time taken: " + (endTime - startTime));
  }

  private long fibonacciTerm(int position) {
    if (position == 0) return 0;
    if (position == 1) return 1;

    return fibonacciTerm(position - 1) + fibonacciTerm(position - 2);
  }

  private long fibonacciTermMemoized(int position, long[] memoizedResult) {
    if (position == 0) return 0;
    if (position == 1) return 1;

    if (memoizedResult[position] != 0) {
      return memoizedResult[position];
    }

    memoizedResult[position] = fibonacciTermMemoized(position - 1, memoizedResult) + fibonacciTermMemoized(position - 2, memoizedResult);
    return memoizedResult[position];
  }

  private long fibonacciSum(int number) {
    if (number <= 1) {
      return number;
    }

    return fibonacciTerm(number) + fibonacciSum(number - 1);
  }

  private long fibonacciSumMemoized(int number) {
    if (number <= 1) {
      return number;
    }

    return fibonacciTermMemoized(number, new long[number + 1]) + fibonacciSumMemoized(number - 1);
  }

  private long fibonacciSumTabulized(int number) {
    if (number <= 1) {
      return number;
    }

    long[] table = new long[number + 1];
    table[0] = 0;
    table[1] = 1;
    for (int i = 2; i <= number; i++) {
      table[i] = table[i - 1] + table[i - 2];
    }

    int sum = 0;
    for (int i = 0; i <= number; i++) {
      sum += table[i];
    }
    return sum;
  }
}
