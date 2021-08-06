package com.learn.java8inaction.future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class Tester {
  public static void main(String[] args) {
//    test1();
    List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
                                     new Shop("LetsSaveBig"),
                                     new Shop("MyFavouriteShop"),
                                     new Shop("BuyItAll"));
    long start = System.nanoTime();
    System.out.println(findPrices1(shops, "some product"));
    System.out.println("Done in  "+((System.nanoTime() - start)/1_000_000)+" msec.");

  }

  private static List<String> findPrices(List<Shop> shops, String product){
    return shops.parallelStream()
        .map((shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product))))
        .collect(Collectors.toList());
  }

  private static List<String> findPrices1(List<Shop> shops, String product){
    List<CompletableFuture<String>> completableFutures = shops.parallelStream()
        .map((shop -> CompletableFuture.supplyAsync(
            () -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))))
        .collect(Collectors.toList());
    return completableFutures.stream()
        .map(CompletableFuture::join)
        .collect(Collectors.toList());
  }

  private static void test1() {
    Shop shop = new Shop("My Best Shop");
    long start = System.nanoTime();
    Future<Double> futurePrice = shop.getPriceAsync("my favourite product");

    long invocationTime = ((System.nanoTime() - start)/1_000_000);

    System.out.println("Invocation returned after "+ invocationTime + " msecs.");

    doSomethingElse();

    try{
      Double price = futurePrice.get();
      System.out.printf("Price is %.2f%n", price);
    }catch (Exception e){
      throw new RuntimeException(e);
    }

    long retrievalTime = ((System.nanoTime() - start)/1_000_000);
    System.out.println("Price returned after "+retrievalTime+" msec.");
  }

  private static void doSomethingElse() {
    try {
      Thread.sleep(1000L);
    } catch (InterruptedException interruptedException) {
      throw new RuntimeException(interruptedException);
    }
  }
}
