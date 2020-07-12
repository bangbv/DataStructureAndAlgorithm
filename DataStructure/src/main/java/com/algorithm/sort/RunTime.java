package com.algorithm.sort;

public class RunTime {
    public static void main(String args[]) {
        int arr[] = {2, 1, 3, 1, 2};
        RunTime rt = new RunTime();
        System.out.println(rt.runningTime(arr));
    }

    static int runningTime(int[] arr) {
        int shift = 0;
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                shift++;
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return shift;
    }
}
