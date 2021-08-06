package com.learn.java8inaction.future;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {

  private String name;

  public Shop(String name) {

    this.name = name;
  }

  public double getPrice(String product) {
    return calculatePrice(product);
  }

  public Future<Double> getPriceAsync(String product) {
    return CompletableFuture.supplyAsync(() -> calculatePrice(product));
//    CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//    new Thread(() -> {
//      try{
//        double calculatedPrice = calculatePrice(product);
//        futurePrice.complete(calculatedPrice);
//      }catch (Exception e){
//        futurePrice.completeExceptionally(e);
//      }
//
//    }).start();
//    return futurePrice;
  }

  private double calculatePrice(String product) {
    Utility.delay();
    Random random = new Random();
    return random.nextDouble() * product.charAt(0) + product.charAt(1);
  }

  public String getName() {
    return name;
  }
}
