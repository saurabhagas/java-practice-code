package com.saurabh.benchmarking;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class BenchmarkingWithIterations {
  @State(Scope.Benchmark)
  public static class ExecutionPlan {
    @Param({"100", "200", "300", "500", "1000"})
    public String valueToCheck;

    private static final int SET_SIZE = 10000;

    // If there's a class marked @State defining test parameters, all test-related
    // constructs should be inside this class
    private final Set<String> hashSet = new HashSet<>(SET_SIZE);
    private final Set<String> treeSet = new TreeSet<>();

    @Setup
    public void setupCollections() {
      for (int i = 0; i < SET_SIZE; i++) {
        final String value = String.valueOf(i);
        hashSet.add(value);
        treeSet.add(value);
      }
    }
  }

  public static void main(String[] args) throws RunnerException {
    final Options options = new OptionsBuilder()
        .include(BenchmarkingWithIterations.class.getSimpleName())
        .forks(1)
        .warmupIterations(1)
        .measurementIterations(1)
        .build();

    new Runner(options).run();
  }

  @Benchmark
  public void testHashSet(ExecutionPlan plan) {
    plan.hashSet.contains(plan.valueToCheck);
  }

  @Benchmark
  public void testTreeSet(ExecutionPlan plan) {
    plan.treeSet.contains(plan.valueToCheck);
  }
}
