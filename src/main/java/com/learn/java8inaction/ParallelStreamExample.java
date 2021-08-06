package com.learn.java8inaction;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreamExample {

  public static void main(String[] args) {
    System.out.println("Sequential sum done = "+ measureSumPerf(ParallelStreamExample::sequentialSum, 10_000_000) + "msecs");
    System.out.println("Iterative sum done = "+ measureSumPerf(ParallelStreamExample::iterativeSum, 10_000_000) + "msecs");
    System.out.println("Parallel sum done = "+ measureSumPerf(ParallelStreamExample::parallelSum, 10_000_000) + "msecs");
  }

  private static long parallelSum(long limit) {
//    return Stream.iterate(1L, number -> number + 1L)
//        .limit(limit)
//        .parallel()
//        .reduce(0L, Long::sum);

    return LongStream.rangeClosed(1L, limit)
        .parallel()
        .reduce(0L, Long::sum);
  }

  private static long sequentialSum(long limit) {
//    return Stream.iterate(1L, number -> number + 1L)
//        .limit(limit)
//        .reduce(0L, Long::sum);
    return LongStream.rangeClosed(1L, limit)
        .reduce(0L, Long::sum);
  }

  private static long iterativeSum(long limit) {
    long sum = 0;
    for (long n = 1; n <= limit; n++) {
      sum += n;
    }
    return sum;
  }

  private static long measureSumPerf(Function<Long, Long> adder, long n) {
    long fastest = Long.MAX_VALUE;
    for (int i = 0; i < 10; i++) {
      long start = System.nanoTime();
      long sum = adder.apply(n);
      long duration = (System.nanoTime() - start) / 1_000_000;
//      System.out.println("Result : " + sum);
      if (duration < fastest) {
        fastest = duration;
      }
    }
    return fastest;
  }
}
