package com.algorithm.DP;

import java.util.ArrayList;

public class Fibonaci {
	static int[] fibMem = new int[5];

	public static void main(String[] args) {
		System.out.println(fibonacci(5));
		printFibonacci();

	}

	static int fibonacci(int n) {
		int r = 1;
		if (fibMem[n - 1] != 0) {
			r = fibMem[n - 1];
		} else {
			if (n > 2) {
				r = fibonacci(n - 1) + fibonacci(n - 2);
			}
			fibMem[n - 1] = r;
		}
		return r;
	}

	static void printFibonacci() {
		int i;
		for (i = 1; i <= 5; i++) {
			System.out.println("fibonacci "+i+":"+fibMem[i - 1]);
		}
	}
}
