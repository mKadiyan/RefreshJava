package com.learn.java8inaction.newdatetime;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

public class Example {
  public static void main(String[] args) {
//    LocalDate localDate = LocalDate.of(2020, 12, 10);
    LocalDate localDate = LocalDate.parse("2020-12-20");
    System.out.println("Year = "+localDate.getYear());
    System.out.println("Month = "+localDate.getMonth());
    System.out.println("Day = "+localDate.getDayOfMonth());
    System.out.println("Length of Month = "+localDate.lengthOfMonth());
    System.out.println("Length of Year = "+localDate.lengthOfYear());
    System.out.println("Leap Year = "+localDate.isLeapYear());
    int  year = localDate.get(ChronoField.YEAR);
    System.out.println(year);
  }
}
