package com.learn.java8inaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class AppleExample {


  public static void main(String[] args) {
    List<Apple> apples = Arrays
        .asList(new Apple("green", 100),
                new Apple("green", 200),
                new Apple("yellow", 500),
                new Apple("red", 50),
                new Apple("green", 99),
                new Apple("red", 100),
                new Apple("yellow", 800));

    System.out.println(filterApplesByColor(apples, "green"));
    System.out.println(filterApplesByWeight(apples, 150));
//    System.out.println(filterApples(apples, new HeavyApplePredicate()));
    Predicate<Apple> greenApplePredicate = (apple) -> "green".equals(apple.getColor());
    Predicate<Apple> heavyApplePredicate = (apple) -> apple.getWeight() > 150;
    System.out.println(filterApples(apples, greenApplePredicate));
    System.out.println(filterApples(apples, heavyApplePredicate));
    apples.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
    System.out.println(apples);

    process(System.out::println, "Hello");
    System.out.println(processFunction(Apple::getColor, new Apple("blue", 120)));

    int portNumber  = 1234;

    Runnable runnable = () -> System.out.println(portNumber);

    runnable.run();


    List<String> strings = Arrays.asList("a", "B", "b", "A");
    strings.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
  }
//  public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate applePredicate) {
//    List<Apple> result = new ArrayList<>();
//    for (Apple apple : inventory) {
//      if (applePredicate.test(apple)) {
//        result.add(apple);
//      }
//    }
//    return result;
//  }

  public static void process(Consumer<String> consumer, String s) {
    consumer.accept(s);
  }

  public static String processFunction(Function<Apple, String> function, Apple apple) {
    return function.apply(apple);
  }

  public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
      if (predicate.test(apple)) {
        result.add(apple);
      }
    }
    return result;
  }

  public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
      if (color.equals(apple.getColor())) {
        result.add(apple);
      }
    }
    return result;
  }


  public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
      if (weight < apple.getWeight()) {
        result.add(apple);
      }

    }
    return result;
  }

  static class Apple {
    private String color;
    private int weight;

    public Apple(String color, int weight) {
      this.color = color;
      this.weight = weight;
    }

    public String getColor() {
      return color;
    }

    public int getWeight() {
      return weight;
    }

    @Override
    public String toString() {
      return "Apple{" +
          "color='" + color + '\'' +
          ", weight=" + weight +
          '}';
    }
  }

  static interface ApplePredicate {
    boolean test(Apple apple);
  }

  static class GreenApplePredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
      return "green".equals(apple.getColor());
    }
  }

  static class HeavyApplePredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
      return apple.getWeight() > 150;
    }
  }
}
