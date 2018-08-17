package com.algorithm.greedy;

import java.util.Arrays;

public class MinimumAsolutelyDifference {

    static int minimumAbsoluteDifference(int n, int[] arr) {
    		Arrays.sort(arr);
    		for(int j=0;j<n-1;j++) {
    			if(arr[j]>arr[j+1]) {
    				int temp = arr[j];
    				arr[j] = arr[j+1];
    				arr[j+1] = temp;
    			}
    		}
        int min = Math.abs(arr[0]-arr[1]);
        for(int i=0;i<n-1;i++){
            int temp = Math.abs(arr[i]-arr[i+1]);
            if(temp<min){
            		min = temp;
            }
        }
        return min;
    }
	
	public static void main(String[] args) {
		int n = 3;
		int[] input = {3,-7,0};
		System.out.println(minimumAbsoluteDifference(n,input));
	}

	
}
