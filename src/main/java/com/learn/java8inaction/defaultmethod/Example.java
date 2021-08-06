package com.learn.java8inaction.defaultmethod;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Example {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1,4,6,2,3,8);
    numbers.sort(Comparator.naturalOrder());
    System.out.println(numbers);
  }
}
