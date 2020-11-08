package com.saurabh.benchmarking;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class SetPerfBenchmarking {
  private static final int SET_SIZE = 10000;

  private final Set<String> hashSet = new HashSet<>(SET_SIZE);
  private final Set<String> treeSet = new TreeSet<>();
  private String stringToFind;

  public static void main(String[] args) throws RunnerException {
    final Options options = new OptionsBuilder()
        .include(SetPerfBenchmarking.class.getSimpleName())
        .forks(1)
        .warmupIterations(10)
        .build();

    new Runner(options).run();
  }

  @Setup
  public void setupCollections() {
    for (int i = 0; i < SET_SIZE; i++) {
      final String value = String.valueOf(i);
      hashSet.add(value);
      treeSet.add(value);
    }

    stringToFind = String.valueOf(SET_SIZE / 4);
  }

  @Benchmark
  public void testHashSet() {
    hashSet.contains(stringToFind);
  }

  @Benchmark
  public void testTreeSet() {
    treeSet.contains(stringToFind);
  }
}