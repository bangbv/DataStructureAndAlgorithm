package com.algorithm.array;

public class MinimumSwap2 {
    public static void main(String[] args) {
        int[] input = {7, 1, 3, 2, 4, 5, 6};
        //int[] input = {1, 3, 5, 2, 4, 6, 7};
        System.out.println(minimumSwaps(input));
    }

    static int minimumSwaps(int[] arr) {
        int swap = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 != arr[i]) {
                int t = i;
                while (arr[t] != i + 1) {
                    t++;
                }
                int temp = arr[t];
                arr[t] = arr[i];
                arr[i] = temp;
                swap++;
            }
        }
        return swap;
    }
}
