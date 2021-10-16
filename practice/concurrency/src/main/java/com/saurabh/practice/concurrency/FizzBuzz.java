package com.saurabh.practice.concurrency;

public class FizzBuzz {
  public static void main(String[] args) {
    Printer printer = new Printer();
    Thread one = new Thread(printer::printFizz);
    Thread two = new Thread(printer::printBuzz);
    Thread three = new Thread(printer::printFizzBuzz);
    Thread four = new Thread(printer::printNum);

    one.start();
    two.start();
    three.start();
    four.start();
  }

  private static class Printer {
    private static final int MAX = 20;
    int counter = 1;

    private synchronized void printFizz() {
      while (counter <= MAX) {
        if (counter % 3 == 0 && counter % 5 != 0) {
          System.out.println("Fizz");
          counter++;
          notifyAll();
        } else {
          waitNoException();
        }
      }
    }

    private synchronized void printBuzz() {
      while (counter <= MAX) {
        if (counter % 3 != 0 && counter % 5 == 0) {
          System.out.println("Buzz");
          counter++;
          notifyAll();
        } else {
          waitNoException();
        }
      }
    }

    private synchronized void printFizzBuzz() {
      while (counter <= MAX) {
        if (counter % 3 == 0 && counter % 5 == 0) {
          System.out.println("FizzBuzz");
          counter++;
          notifyAll();
        } else {
          waitNoException();
        }
      }
    }

    private synchronized void printNum() {
      while (counter <= MAX) {
        if (counter % 3 != 0 && counter % 5 != 0) {
          System.out.println(counter);
          counter++;
          notifyAll();
        } else {
          waitNoException();
        }
      }
    }

    private void waitNoException() {
      try {
        wait();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new RuntimeException(e);
      }
    }
  }
}
