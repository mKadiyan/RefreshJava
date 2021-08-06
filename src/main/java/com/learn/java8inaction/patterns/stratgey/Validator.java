package com.learn.java8inaction.patterns.stratgey;

public class Validator {
  private final ValidateStrategy validateStrategy;

  public Validator(ValidateStrategy validateStrategy) {
    this.validateStrategy = validateStrategy;
  }

  public boolean validate(String s){
    return validateStrategy.execute(s);
  }

  public static void main(String[] args) {
    Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
    Validator numberValidator = new Validator(new IsNumeric());

    System.out.println(lowerCaseValidator.validate("abcd"));
    System.out.println(lowerCaseValidator.validate("123"));

    System.out.println(numberValidator.validate("abcd"));
    System.out.println(numberValidator.validate("123"));

    //using lambda expression

    Validator lambdaLowerCaseValidator = new Validator((String s) -> s.matches("[a-z]+"));
    Validator lambdaNumberValidator = new Validator((String s) -> s.matches("\\d+"));

    System.out.println(lambdaLowerCaseValidator.validate("abcd"));
    System.out.println(lambdaLowerCaseValidator.validate("123"));

    System.out.println(lambdaNumberValidator.validate("abcd"));
    System.out.println(lambdaNumberValidator.validate("123"));
  }
}
