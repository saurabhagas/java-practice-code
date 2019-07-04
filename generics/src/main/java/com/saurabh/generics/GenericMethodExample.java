package com.saurabh.generics;

import java.io.FileNotFoundException;

/**
 * GenericMethodExample
 */
public class GenericMethodExample {
  public static <U extends Exception> void printException(U u) {
    System.out.println(u.getMessage());
  }

  public static void main(String[] args) {
    GenericMethodExample.printException(new FileNotFoundException("Not found"));
    GenericMethodExample.printException(new Exception("Exception"));
//    GenericMethodExample.printException(new Throwable("Not found")); // Doesn't compile

    GenericMethodExample.<FileNotFoundException>printException(new FileNotFoundException("Not found"));
    GenericMethodExample.<Exception>printException(new Exception("Exception"));
    GenericMethodExample.<Exception>printException(new RuntimeException("RuntimeException"));
//    GenericMethodExample.<Throwable>printException(new RuntimeException("RuntimeException")); //Doesn't compile
//    GenericMethodExample.<Throwable>printException(new Throwable("Not found")); // Doesn't compile
  }
}
