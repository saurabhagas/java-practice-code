package sandbox.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ConcurrentSetTest {
  public static void main(String[] args) {
    Set<String> clusterNames = new CopyOnWriteArraySet<>();
    clusterNames.add(null);
    clusterNames.add("hey");
    clusterNames.add("hey");
    clusterNames.add("hello");

    System.out.println(clusterNames);
    System.out.println(clusterNames.size());

    List list = new ArrayList();
    list.add(null);
    String name = (String) null;
    System.out.println(name);

  }
}
