package com.learn.java8inaction.patterns.stratgey;

import java.util.stream.StreamSupport;

public interface ValidateStrategy {
  boolean execute(String s);
}
