package com.saurabh.benchmarking;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
public class JvmOptimizationAvoidanceBenchmarking {
  @State(Scope.Benchmark)
  public static class Log {
    public int x = 8;
  }

  public static void main(String[] args) throws RunnerException {
    final Options options = new OptionsBuilder()
        .include(JvmOptimizationAvoidanceBenchmarking.class.getSimpleName())
        .forks(1)
        .warmupIterations(5)
        .measurementIterations(5)
        .build();

    new Runner(options).run();
  }

  @Benchmark
  public double codeFoldingAvoidance(Log input) {
    /*
      The following code would get folded by the compiler:
      int x = 8;
      return Math.log(x);

      To avoid this, we introduce a State class containing

     */
    return Math.log(input.x);
  }

  @Benchmark
  public void deadCodeRemovalAvoidance(Blackhole blackhole) {
    /*
      Without the explicit blackhole.consume() call, the new Object() call
      will be removed by the compiler as dead-code removal.
     */
    blackhole.consume(new Object());
  }
}
