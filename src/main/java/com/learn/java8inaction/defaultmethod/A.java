package com.learn.java8inaction.defaultmethod;

public interface A {

  default void sayHello(){
    System.out.println("A says hello!");
  }
}
