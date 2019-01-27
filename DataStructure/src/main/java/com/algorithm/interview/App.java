package com.algorithm.interview;

public class App {
	public static void main(String[] args) {
		OddAndEven r = new OddAndEven();
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] b = new int[a.length];
		print(a);
		b = r.reOrder(a, b, 0, 1, 0, a.length / 2);
		print(b);
	}

	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
