package com.learn.java8inaction;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAlgo {
  public static void main(String[] args) {
    //Pythagorean triples

    IntStream.rangeClosed(1, 100)
        .boxed()
        .flatMap(n1 -> IntStream.rangeClosed(n1, 100)
            .filter(n2 -> Math.sqrt(n1 * n1 + n2 * n2) % 1 == 0)
            .mapToObj(n2 -> new int[] {n1, n2, (int) Math.sqrt(n1 * n1 + n2 * n2)}))
        .forEach(arr -> System.out.println("(" + arr[0] + "," + arr[1] + "," + arr[2] + ")"));


    Stream.iterate(0, n -> n + 2)
        .limit(10)
        .forEach(System.out::println);

    Stream.iterate(new int[]{0,1}, t-> new int[]{t[1], t[0]+ t[1]})
        .limit(10)
        .mapToInt(value -> value[0])
        .forEach(t-> System.out.println(t));

    IntSupplier fib = new IntSupplier() {
      private int previous = 0;
      private int next = 1;
      @Override
      public int getAsInt() {
        int oldPrevious = this.previous;
        int current = this.previous + this.next;
        this.previous = this.next;
        this.next = current;
        return oldPrevious;
      }
    };
    IntStream.generate(fib)
        .limit(10)
        .forEach(System.out::println);
  }
}
