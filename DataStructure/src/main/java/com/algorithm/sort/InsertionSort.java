package com.algorithm.sort;

public class InsertionSort {
    static int swap = 0;
    // Driver method
    public static void main(String args[]) {
        int arr[] = {2, 1, 3, 1, 2};
        printArray(arr);
        InsertionSort ob = new InsertionSort();
        ob.sort(arr);
        printArray(arr);
        System.out.println("swap number:"+swap);
    }

    /*Function to sort array using insertion sort*/
    void sort(int arr[]) {

        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
			/* Move elements of arr[0..i-1], that are
			greater than key, to one position ahead
			of their current position */
            while (j >= 0 && arr[j] > key) {
                swap++;
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    /* A utility function to print array of size n*/
    static void printArray(int[] arr) {
        for (int value : arr) System.out.print(value + " ");
        System.out.println();
    }


}
