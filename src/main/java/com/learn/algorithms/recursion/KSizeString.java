package com.learn.algorithms.recursion;


import java.util.Arrays;

public class KSizeString {
    //Generate all strings of length n drawn from 0 to k-1
    static int arr[] = new int[10];

    public static void main(String[] args) {
        kSizeString(arr.length, 3);
    }

    static void kSizeString(int n, int k) {
        if (n < 1) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = 0; i < k; i++) {
            arr[n - 1] = i;
            kSizeString(n - 1, k);
        }

    }
}
