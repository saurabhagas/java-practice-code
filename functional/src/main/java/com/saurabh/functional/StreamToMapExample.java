package com.saurabh.functional;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamToMapExample {
  public static void main(String[] args) {
    Stream<String> s = Stream.empty();
    Stream<String> s2 = Stream.empty();

    Predicate<String> pred = string -> string.startsWith("blah");
    Map<Boolean, List<String>> p = s.collect(Collectors.partitioningBy(pred));
//    Map<Boolean, List<String>> g = s2.collect(Collectors.groupingBy(pred)); //Doesn't compile
    Map<Boolean, List<String>> g = s2.collect(Collectors.groupingBy(string -> string.startsWith("blah"))); //Compiles because it's interpreted as a function
    System.out.println(p + " " + g);
  }
}
