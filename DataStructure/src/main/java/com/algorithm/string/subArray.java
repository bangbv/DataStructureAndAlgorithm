package com.algorithm.string;

// A subbarray is a contiguous part of array.
public class subArray {
    static void subArrays(int[] arr, int start, int end) {
        if (end != arr.length) {
            if (start > end)
                subArrays(arr, 0, end + 1);
            else {
                printArr(arr, start, end);
                subArrays(arr, start + 1, end);
            }
        }
    }

    public static void printArr(int[] arr, int start, int end) {
        for (int i = start; i < end; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        subArrays(arr, 0, 0);
    }
}
