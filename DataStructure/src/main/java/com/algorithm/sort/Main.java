package com.algorithm.sort;

public class Main {

	public static void main(String[] args) {
		System.out.println("QuickSort");
		int[] input  = {1,4,5,3,8,9};
		print(input);
		QuickSort qs = new QuickSort();
		qs.quicksort(input,0,input.length-1);
		print(input);
	}
	
	static void print(int[] a) {
		for(int i = 0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
}
