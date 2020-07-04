package com.saurabh.design_patterns.singleton;

public class SingletonDemo {
  private static class Singleton {
    //    private static Singleton singleton; // Implementation 1
    private static volatile Singleton singleton; // Implementation 2

    private Singleton() {
      // prevent direct instantiation
    }

//    static Singleton getInstance() { // Implementation 1
//      synchronized (singleton) {
//        if (singleton == null) {
//          singleton = new Singleton();
//        }
//        return singleton;
//      }
//    }

    static Singleton getInstance() { // Double-check synchronization
      if (singleton == null) {
        synchronized (Singleton.class) {
          if (singleton == null) {
            singleton = new Singleton();
          }
        }
      }
      return singleton;
    }
  }
}
