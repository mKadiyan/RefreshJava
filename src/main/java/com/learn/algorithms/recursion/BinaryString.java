package com.learn.algorithms.recursion;

import java.util.Arrays;

public class BinaryString {
    private static int[] arr = new int[3];

    public static void main(String[] args) {
        binaryString(arr.length);
    }

    static void binaryString(int n){
        if(n < 1){
            System.out.println(Arrays.toString(arr));
            return;
        }
        arr[n-1] = 0;
        binaryString(n-1);
        arr[n-1] = 1;
        binaryString(n-1);
    }
}
