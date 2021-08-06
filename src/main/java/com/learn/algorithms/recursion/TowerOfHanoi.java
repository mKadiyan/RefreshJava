package com.learn.algorithms.recursion;

public class TowerOfHanoi {

    public static void main(String[] args) {
        move(1, "A", "C", "B");
        System.out.println("=========================");
        move(2, "A", "C", "B");
        System.out.println("=========================");
        move(3, "A", "C", "B");
        System.out.println("=========================");
        move(4, "A", "C", "B");

    }
    static void move(int n, String from, String to, String aux) {
        if (n == 1){
            System.out.println("Move from " + from + " to " + to + ".");
            return;
        }

        move(n - 1, from, aux, to);
        System.out.println("Move from " + from + " to " + to + ".");
        move(n - 1, aux, to, from);
    }
}
