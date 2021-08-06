package com.learn.java8inaction;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeExample {
  public static void main(String[] args) {
    System.out.println(partitionPrime(10));
  }

  private static Map<Boolean, List<Integer>> partitionPrime(int number){
    return IntStream.rangeClosed(2, number)
        .boxed()
        .collect(Collectors.partitioningBy(PrimeExample::isPrime));

  }
  private static boolean isPrime(int candidate){
    int candidateRoot = (int) Math.sqrt(candidate);
    return IntStream.rangeClosed(2, candidateRoot)
        .noneMatch(value -> candidate % value == 0);
  }
}
