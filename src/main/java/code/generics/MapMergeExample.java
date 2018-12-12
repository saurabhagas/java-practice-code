package code.generics;

import java.util.HashMap;
import java.util.Map;

public class MapMergeExample {
  public static void main(String[] args) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(1, 10);
    map.put(2, 20);
    map.put(4, null);

    // merge the provided new and the old values using the provided BiFunction.
    map.merge(1, 3, (a, b) -> a + b);
    map.merge(2, 3, (a, b) -> null);//deletes the key is mapping function returns null
    map.merge(3, 3, (a, b) -> a + b);// creates the keys with the specified value if it's null
    map.merge(4, 3, (a, b) -> null);//tricky - mapping function isn't even touched when original value was null, simply the provided key is used

    System.out.println(map);
  }
}
