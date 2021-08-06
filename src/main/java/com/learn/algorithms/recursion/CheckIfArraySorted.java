package com.learn.algorithms.recursion;

public class CheckIfArraySorted {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 8, 10 , 10};
        System.out.println(isArraySorted(arr, arr.length));
    }

    static boolean isArraySorted(int[] arr, int index) {
        if (index == 1)
            return true;
        return arr[index - 1] < arr[index - 2] ? false : isArraySorted(arr, index - 1);
    }
}
