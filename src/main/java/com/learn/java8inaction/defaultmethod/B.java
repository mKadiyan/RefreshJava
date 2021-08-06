package com.learn.java8inaction.defaultmethod;

public interface B extends A{

  default void sayHello(){
    System.out.println("B says hello!");
  }
}
