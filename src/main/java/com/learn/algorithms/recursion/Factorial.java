package com.learn.algorithms.recursion;

public class Factorial {

    public static void main(String[] args) {
        System.out.println("3! = "+ fact(3));
        System.out.println("4! = "+ fact(4));
        System.out.println("5! = "+ fact(5));
        System.out.println("0! = "+ fact(0));
        System.out.println("1! = "+ fact(1));
        System.out.println("2! = "+ fact(2));
    }
    static int fact(int n){
        if(n == 1 || n==0)
            return 1;
        return n*fact(n-1);
    }
}
