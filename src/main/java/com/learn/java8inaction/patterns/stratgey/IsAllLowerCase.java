package com.learn.java8inaction.patterns.stratgey;

public class IsAllLowerCase implements ValidateStrategy{
  @Override
  public boolean execute(String s) {
    return s.matches("[a-z]+");
  }
}
