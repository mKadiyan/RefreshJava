package com.learn.java8inaction;

class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calorie;
    private final Type type;

    public enum Type {MEAT, FISH, OTHER}

    ;

    public Dish(String name, boolean vegetarian, int calorie,
                Type type) {
      this.name = name;
      this.vegetarian = vegetarian;
      this.calorie = calorie;
      this.type = type;
    }

    public String getName() {
      return name;
    }

    public boolean isVegetarian() {
      return vegetarian;
    }

    public int getCalorie() {
      return calorie;
    }

    public Type getType() {
      return type;
    }

    @Override
    public String toString() {
      return name;
    }
  }