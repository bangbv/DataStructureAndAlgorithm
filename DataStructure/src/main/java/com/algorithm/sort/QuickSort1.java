package com.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort1 {
    public static void main(String[] args){
        System.out.println("QuickSort1");
        int[] arr = {4, 5, 3, 7, 2};
        printArray(arr);
        quickSort(arr);
        printArray(arr);
    }

    static int[] quickSort(int[] arr) {
        if(arr.length >1) {
            int p = arr[0];
            List<Integer> leftList = new ArrayList<>();
            List<Integer> rightList = new ArrayList<>();
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < p) {
                    leftList.add(arr[i]);
                } else {
                    rightList.add(arr[i]);
                }
            }
            int[] left = new int[leftList.size()];
            int[] right = new int[rightList.size()];
            for (int i = 0; i < leftList.size(); i++) {
                left[i] = leftList.get(i);
            }
            for (int i = 0; i < rightList.size(); i++) {
                right[i] = rightList.get(i);
            }
            quickSort(left);
            quickSort(right);
            int j =0;
            for (int i = 0; i < left.length; i++) {
                arr[j++] = left[i];
            }
            arr[j++] = p;
            for (int i = 0; i < right.length; i++) {
                arr[j++] = right[i];
            }
        }
        return arr;
    }

    static void printArray(int[] arr) {
        for (int s : arr) System.out.print(s + " ");
        System.out.println();
    }
}
