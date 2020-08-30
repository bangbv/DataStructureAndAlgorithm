package com.algorithm.searching;

import com.algorithm.sort.MergeSort;

public class RadioTransmitters {

    public static void main(String[] args) {
        //int[] input = {7, 2, 4, 5, 9, 12, 11};
        int[] input = {9, 5, 4, 2, 6, 15, 12}; // test case 2
        //int[] input = { 6, 15};
        //int[] input = {5};
        int k = 2;
        System.out.println(hackerlandRadioTransmitters(input, k));
    }

    static int hackerlandRadioTransmitters(int[] x, int k) {
        MergeSort ms = new MergeSort();
        ms.mergeSort(x, 0, x.length - 1);
        int n = x.length;
        int numOfTransmitters = 0;
        int i = 0;
        while (i < n) {
            numOfTransmitters++;
            int loc = x[i] + k;
            while (i < n && x[i] <= loc) i++;
            loc = x[--i] + k;
            while (i < n && x[i] <= loc) i++;
        }
        return numOfTransmitters;
    }
}
