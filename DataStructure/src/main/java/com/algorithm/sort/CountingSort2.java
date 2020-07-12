package com.algorithm.sort;

public class CountingSort2 {
    public static void main(String[] args) {
        //int[] input = {63,25,73,1,98,73,56,84,86,57,16,83,8,25,81,56,9,53,98,67,99,12,83,89,80,91,39,86,76,85,74,39,25,90,59,10,94,32,44,3,89,30,27,79,46,96,27,32,18,21,92,69,81,40,40,34,68,78,24,87,42,69,23,41,78,22,6,90,99,89,50,30,20,1,43,3,70,95,33,46,44,9,69,48,33,60,65,16,82,67,61,32,21,79,75,75,13,87,70,33};
        int[] input = {19, 10, 12, 10, 24, 25, 22};
        myPrint(input);
        int[] output = countingSort(input);
        myPrint(output);
    }

    static int[] countingSort(int[] arr) {
        int[] indexs = new int[100];
        int length = arr.length;
        int[] result = new int[length];
        for (int value : arr) {
            indexs[value] = indexs[value] + 1;
        }
        myPrint(indexs);

        int x = 0;
        for (int i = 0; i < 100; i++) {
            int count = indexs[i];
            for (int j = 0; j < count; j++) {
                result[x++] = i;
            }
        }
        return result;
    }

    private static void myPrint(int[] arr) {
        for (int value : arr) {
            System.out.print(value + "	");
        }
        System.out.println();
    }
}
