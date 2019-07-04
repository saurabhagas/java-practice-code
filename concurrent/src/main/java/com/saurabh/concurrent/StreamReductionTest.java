package com.saurabh.concurrent;

import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Stream;

public class StreamReductionTest {

  public static void main(String[] args) {
    System.out.println(Stream.of(1, 2, 3, 4, 5, 6)
        .parallel()
        .map(x -> -x) // a-b would not be an associate accumulator, hence do this to use a+b
        .reduce(0, (a, b) -> (a + b)));

    //Identity function decides the type of BiFunction and BinaryOperator
    System.out.println(Stream.of('w', 'o', 'l', 'f', 'r', 'a', 'm')
        .parallel()
        .reduce("", (s1, c) -> s1 + c, (s1, s2) -> s1 + s2));

    Stream<String> stream = Stream.of("w", "o", "l", "f", "f", "e");
//        .parallel();
    SortedSet<String> set = stream.collect(ConcurrentSkipListSet::new, Set::add, Set::addAll);
//    Set<String> set = stream.collect(Collectors.toSet()); //Collecting in default Set (HashSet)
//    ConcurrentSkipListSet<String> set = stream.collect(Collectors.toCollection(ConcurrentSkipListSet::new));
    System.out.println(set);
  }
}
