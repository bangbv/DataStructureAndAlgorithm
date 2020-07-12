package com.algorithm.sort;

public class Main {

    public static void main(String[] args) {
        System.out.println("QuickSort");
        int[] input = {1, 4, 5, 3, 8, 9};
		myPrint(input);
        QuickSort qs = new QuickSort();
        qs.quicksort(input, 0, input.length - 1);
		myPrint(input);
    }

    private static void myPrint(int[] arr) {
        for (int value : arr) {
            System.out.print(value + "	");
        }
        System.out.println();
    }


}
