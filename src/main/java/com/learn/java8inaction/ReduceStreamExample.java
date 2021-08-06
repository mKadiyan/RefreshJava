package com.learn.java8inaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReduceStreamExample {
  public static void main(String[] args) {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(
        new Transaction(brian, 2011, 300, "INR"),
        new Transaction(raoul, 2012, 10000, "USD"),
        new Transaction(raoul, 2011, 400, "INR"),
        new Transaction(mario, 2012, 710, "EUR"),
        new Transaction(mario, 2012, 700, "INR"),
        new Transaction(alan, 2012, 950, "EUR")
    );

    List<Transaction> all2011TransactionSortByValue = transactions.stream()
        .filter(transaction -> transaction.getYear() == 2011)
        .sorted(Comparator.comparing(Transaction::getValue))
        .collect(Collectors.toList());
    System.out.println(all2011TransactionSortByValue);

    List<String> tradersUniqueCities = transactions.stream()
        .map(transaction -> transaction.getTrader().getCity())
        .distinct()
        .collect(new ToListCollector<>());
    System.out.println("ha=="+tradersUniqueCities);

    List<Trader> allTradersFromCambridgeSortedByName = transactions.stream()
        .map(Transaction::getTrader)
        .filter(trader -> "Cambridge".equalsIgnoreCase(trader.getCity()))
        .distinct()
        .sorted(Comparator.comparing(Trader::getName))
        .collect(Collectors.toList());
    System.out.println(allTradersFromCambridgeSortedByName);

    List<String> allTradersNameSorted1 = transactions.stream()
        .map(Transaction::getTrader)
        .map(Trader::getName)
        .distinct()
        .sorted()
        .collect(Collectors.toList());
    String allTradersNameSorted2 = transactions.stream()
        .map(Transaction::getTrader)
        .map(Trader::getName)
        .distinct()
        .sorted()
        .reduce("", (n1, n2) -> n1 + n2);

    String allTradersNameSorted3 = transactions.stream()
        .map(Transaction::getTrader)
        .map(Trader::getName)
        .distinct()
        .sorted()
        .collect(Collectors.joining(" "));

    System.out.println(allTradersNameSorted1);
    System.out.println(allTradersNameSorted2);
    System.out.println(allTradersNameSorted3);

    boolean anyTraderInMilan = transactions.stream()
        .map(Transaction::getTrader)
        .anyMatch(trader -> "Milan".equalsIgnoreCase(trader.getCity()));
    System.out.println(anyTraderInMilan);

    transactions.stream()
        .filter(transaction -> "Cambridge".equalsIgnoreCase(transaction.getTrader().getCity()))
        .forEach(transaction -> System.out.println(transaction.getValue()));

    Optional<Transaction> maxTransaction1 = transactions.stream()
        .max(Comparator.comparing(Transaction::getValue));
    Optional<Integer> maxTransaction2 = transactions.stream()
        .map(Transaction::getValue)
        .reduce(Integer::max);
    System.out.println(maxTransaction1);
    System.out.println(maxTransaction2);

    Optional<Transaction> minTransaction1 = transactions.stream()
        .min(Comparator.comparing(Transaction::getValue));
    Optional<Integer> minTransaction2 = transactions.stream()
        .map(Transaction::getValue)
        .reduce(Integer::min);
    System.out.println(minTransaction1);
    System.out.println(minTransaction2);

    System.out.println("===========Grouping===============");
    Map<String, List<Transaction>> transactionsGroupByCurrency = transactions.stream()
        .collect(Collectors.groupingBy(Transaction::getCurrency));
    System.out.println(transactionsGroupByCurrency);

  }

}
