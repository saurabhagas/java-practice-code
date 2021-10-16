package com.saurabh.practice.linked_list;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import com.saurabh.source.common.Tuple;

/**
 * Problem at: https://leetcode.com/problems/time-based-key-value-store/
 */
public class TimeMap {
  Map<String, PriorityQueue<Tuple<Integer, String>>> map = new HashMap<>();

  public static void main(String[] args) {
    TimeMap obj = new TimeMap();
    obj.set("foo", "bar", 1);
    System.out.println(obj.get("foo", 1));
    System.out.println(obj.get("foo", 3));
    obj.set("foo", "bar2", 4);
    System.out.println(obj.get("foo", 4));
    System.out.println(obj.get("foo", 5));
    System.out.println(obj.get("foo", 3));
  }

  public void set(String key, String value, int timestamp) {
    Tuple<Integer, String> tuple = Tuple.of(timestamp, value);
    PriorityQueue<Tuple<Integer, String>> heap = map.getOrDefault(key, new PriorityQueue<>((o1, o2) -> o2.getT1().compareTo(o1.getT1())));
    heap.offer(tuple);
    map.put(key, heap);
  }

  public String get(String key, int timestamp) {
    PriorityQueue<Tuple<Integer, String>> heap = map.get(key);
    if (heap == null) return "";

    for (Tuple<Integer, String> peek : heap) {
      if (peek == null) return null;
      Integer latestTimestamp = peek.getT1();
      if (latestTimestamp <= timestamp) {
        return peek.getT2();
      }
    }
    return "";
  }
}