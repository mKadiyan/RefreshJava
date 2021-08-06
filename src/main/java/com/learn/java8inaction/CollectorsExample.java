package com.learn.java8inaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectorsExample {
  public static void main(String[] args) {
    List<Dish> menu = Arrays.asList(
        new Dish("pork", false, 800, Dish.Type.MEAT),
        new Dish("beef", false, 700, Dish.Type.MEAT),
        new Dish("chicken", false, 400, Dish.Type.MEAT),
        new Dish("french fries", true, 530, Dish.Type.OTHER),
        new Dish("rice", true, 350, Dish.Type.OTHER),
        new Dish("season fruit", true, 120, Dish.Type.OTHER),
        new Dish("pizza", true, 550, Dish.Type.OTHER),
        new Dish("prawns", false, 300, Dish.Type.FISH),
        new Dish("salmon", false, 450, Dish.Type.FISH)
    );

    System.out.println(menu.stream().collect(Collectors.counting()));
    System.out.println(menu.stream().count());
    System.out.println(
        menu.stream().collect(Collectors.maxBy(Comparator.comparingInt(Dish::getCalorie))));
    System.out.println(
        menu.stream().collect(Collectors.minBy(Comparator.comparingInt(Dish::getCalorie))));
    System.out.println(menu.stream().collect(Collectors.summingInt(Dish::getCalorie)));
    System.out.println(menu.stream().map(Dish::getCalorie).reduce(0, (i, j) -> i + j));
    System.out.println(menu.stream().collect(Collectors.averagingInt(Dish::getCalorie)));
    System.out.println(menu.stream().collect(Collectors.summarizingInt(Dish::getCalorie)));
    System.out
        .println(menu.stream().collect(Collectors.reducing(0, Dish::getCalorie, Integer::sum)));
//    System.out.println(menu.stream().collect(Collectors.joining()));
    System.out.println(menu.stream().map(Dish::getName).collect(Collectors.joining()));
    System.out.println(menu.stream().map(Dish::getName).collect(Collectors.joining(",")));
    System.out.println(menu.stream().collect(Collectors.groupingBy(Dish::getType)));
    System.out.println(menu.stream().collect(Collectors.groupingBy(dish -> {
      if (dish.getCalorie() < 400) {
        return CaloricLevel.DIET;
      } else if (dish.getCalorie() < 700) {
        return CaloricLevel.NORMAL;
      }
      return CaloricLevel.FAT;
    })));

    System.out.println(menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(dish -> {
      if (dish.getCalorie() < 400) {
        return CaloricLevel.DIET;
      } else if (dish.getCalorie() < 700) {
        return CaloricLevel.NORMAL;
      }
      return CaloricLevel.FAT;
    }))));

    System.out.println(menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting())));
    System.out.println(menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparing(Dish::getCalorie)))));
    System.out.println(menu.stream()
                           .collect(Collectors.groupingBy(Dish::getType, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Dish::getCalorie)), Optional::get))));

    System.out.println(menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(dish -> {
      if (dish.getCalorie() < 400) {
        return CaloricLevel.DIET;
      } else if (dish.getCalorie() < 700) {
        return CaloricLevel.NORMAL;
      }
      return CaloricLevel.FAT;
    }, Collectors.toSet()))));

    System.out.println(menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian)));
    System.out.println(menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.maxBy(Comparator.comparing(Dish::getCalorie)))));

    System.out.println(IntStream.rangeClosed(0,100)
        .boxed()
        .collect(Collectors.partitioningBy(n -> n % 2 == 0 )));
  }
}
