package com.learn.java8inaction.patterns.stratgey;

public class IsNumeric implements ValidateStrategy{
  @Override
  public boolean execute(String s) {
    return s.matches("\\d+");
  }
}
