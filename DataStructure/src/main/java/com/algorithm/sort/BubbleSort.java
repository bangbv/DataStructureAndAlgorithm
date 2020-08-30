package com.algorithm.sort;

public class BubbleSort {
    public static void main(String[] args) {
        //int[] input = {1,2,3};
        int[] input = {3,2,1};
        //myPrint(input);
        countSwaps(input);
        myPrint(input);
    }

    static void countSwaps(int[] a) {
        int swap = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j+1]) {
                    swap++;
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        System.out.println("Array is sorted in " + swap + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);
    }

    static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[i]) {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
    }

    private static void myPrint(int[] arr) {
        for (int value : arr) {
            System.out.print(value + "	");
        }
        System.out.println();
    }
}
