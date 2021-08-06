package com.learn.java8inaction.future;

public class Utility {
  public static void delay() {
    try {
      Thread.sleep(1000L);
    } catch (InterruptedException interruptedException) {
      throw new RuntimeException(interruptedException);
    }
  }
}
