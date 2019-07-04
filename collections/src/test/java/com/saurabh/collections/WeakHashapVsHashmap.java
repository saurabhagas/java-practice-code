package com.saurabh.collections;

import org.junit.Test;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * WeakHashapVsHashmap
 */
public class WeakHashapVsHashmap {
  @Test
  public void HashMapGCDemo() throws Exception {
    HashMap m = new HashMap();
    Demo d = new Demo();
    m.put(d, " Hi ");
    System.out.println(m);

    d = null;
    // garbage collector is called
    System.gc();
    //Wait for GC to actually run
    Thread.sleep(4000);

    System.out.println(m);
  }

  @Test
  public void WeakHashmapGCDemo() throws Exception {
    WeakHashMap m = new WeakHashMap();
    Demo d = new Demo();
    m.put(d, " Hi ");
    System.out.println(m);

    d = null;
    // garbage collector is called
    System.gc();
    // wait for GC to actually run
    Thread.sleep(4000);

    //Key will be removed because of the GC
    System.out.println(m);
  }
}

class Demo {
  public String toString() {
    return "demo";
  }

  // finalize method
  public void finalize() {
    System.out.println("Finalize method is called");
  }
}
