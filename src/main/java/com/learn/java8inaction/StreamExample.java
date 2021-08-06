package com.learn.java8inaction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 10, 11, 12, 13, 14, 15, 9, 8, 7);
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
    System.out.println("=================================");
    List<String> dishesName = menu.stream()
        .map(Dish::getName)
        .collect(Collectors.toList());
    System.out.println("dishesName == " + dishesName);
    System.out.println("=================================");
    List<String> threeHighCalorieDishesName = menu.stream()
        .filter(dish -> dish.getCalorie() > 300)
        .map(Dish::getName)
        .limit(3)
        .collect(Collectors.toList());
    System.out.println("threeHighCalorieDishesName" + threeHighCalorieDishesName);

    System.out.println("=================================");
    List<String> title = Arrays.asList("Java8", "In", "Action");
    Stream<String> stream = title.stream();
    try {
      stream.forEach(System.out::println);
      stream.forEach(System.out::println);
    } catch (Exception e) {
      System.out.println(e);
    }

    System.out.println("=================================");

    menu.stream()
        .filter(Dish::isVegetarian)
        .skip(2)
        .forEach(System.out::println);

    System.out.println("=================================");

    Arrays.asList(1, 3, 5, 6, 3, 4, 7, 8).stream()
        .filter(i -> i % 2 == 0)
        .sorted()
        .forEach(System.out::println);

    System.out.println("=================================");
    List<Integer> lengthOfWords =
        Arrays.asList("Hello", "There", "How", "Many", "Ravinder").stream()
            .map(String::length)
            .collect(Collectors.toList());
    System.out.println("lengthOfWords" + lengthOfWords);

    System.out.println("=================================");

    List<String> uniqueCharacters =
        Arrays.asList("Hello", "There", "How", "Many", "Ravinder").stream()
            .flatMap(s -> Arrays.stream(s.split("")))
            .distinct()
            .collect(Collectors.toList());
    System.out.println("uniqueCharacters" + uniqueCharacters);

    System.out.println("=================================");

    List<Integer> numberList1 = Arrays.asList(1, 2, 3);
    List<Integer> numberList2 = Arrays.asList(3, 4);
    numberList1.stream()
        .flatMap(n1 -> numberList2.stream().map(n2 -> new int[] {n1, n2}))
        .filter(arr -> (arr[0] + arr[1]) % 3 == 0)
        .forEach(arr -> System.out.println("(" + arr[0] + "," + arr[1] + ")"));

    System.out.println("=================================");

    List<Integer> values = Arrays.asList(2);
    System.out.println(
        values.stream()
            .noneMatch(integer -> integer % 2 == 0)
    );


    System.out.println("=================================");
    System.out.println(
        menu.stream()
            .filter(Dish::isVegetarian)
            .findAny()
    );
    System.out.println("=================================");

    System.out.println(
        numbers.stream()
            .filter(number -> number % 5 == 0)
            .reduce(10, (a, b) -> a + b)
    );
    System.out.println("=================================");

    System.out.println(menu.stream()
        .mapToInt(Dish::getCalorie)
        .summaryStatistics());
    System.out.println("=================================");
    System.out.println("=================================");
    System.out.println("=================================");


  }

}
