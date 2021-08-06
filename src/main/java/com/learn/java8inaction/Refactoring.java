package com.learn.java8inaction;

public class Refactoring {
  int a  = 10;
  Runnable r1 = () -> {
    int a = 13;
    System.out.println(a);
  };
  public static void main(String[] args) {
    int a  = 10;
    Runnable r1 = () -> {
//      int a = 13;
      System.out.println(a);
    };
    new Thread(r1).start();
  }
}
