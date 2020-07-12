package com.algorithm.sort;

public class InsertionSort2 {

    public static void main(String args[]) {
        int arr[] = {3, 4, 7, 5, 6, 2, 1};
        InsertionSort2 ob = new InsertionSort2();
        ob.insertionSort2(arr.length, arr);
    }

    static void insertionSort2(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
            for (int value : arr) System.out.print(value + " ");
            System.out.println();
        }
    }

    static void printArray(int[] arr) {
        for (int value : arr) System.out.print(value + " ");
        System.out.println();
    }
}
