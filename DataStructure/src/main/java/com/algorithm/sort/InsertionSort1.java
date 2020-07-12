package com.algorithm.sort;

public class InsertionSort1 {

    public static void main(String args[]) {
        int arr[] = {2, 4, 6, 8, 3};
        InsertionSort1 ob = new InsertionSort1();
        ob.insertionSort1(arr.length, arr);
    }

    static void insertionSort1(int n, int[] arr) {
        for(int i = n-1;i >= 0 ;i--){
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                for (int value : arr) System.out.print(value + " ");
                System.out.println();
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        for (int value : arr) System.out.print(value + " ");
    }

    static void printArray(int[] arr) {
        for (int value : arr) System.out.print(value + " ");
        System.out.println();
    }
}
