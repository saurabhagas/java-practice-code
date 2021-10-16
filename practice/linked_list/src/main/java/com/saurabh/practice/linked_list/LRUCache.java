package com.saurabh.practice.linked_list;

import java.util.LinkedHashMap;

public class LRUCache {
  private final int capacity;
  private final LinkedHashMap<Integer, Integer> map;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.map = new LinkedHashMap<>(capacity);
  }

  public int get(int key) {
    if (!map.containsKey(key)) return -1;
    int recentlyUsedValue = map.remove(key);
    map.put(key, recentlyUsedValue);
    return recentlyUsedValue;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      map.remove(key); // remove it as we need to put it again
    }
    if (map.size() == this.capacity) {
      int oldestKey = map.keySet().iterator().next();
      map.remove(oldestKey);
    }

    map.put(key, value);
  }
}
