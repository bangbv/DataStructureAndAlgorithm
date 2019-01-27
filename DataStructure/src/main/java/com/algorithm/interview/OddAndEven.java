package com.algorithm.interview;

/**
 * @author bvbang
 */
public class OddAndEven {

	public static void main(String[] args) {
		// given an array.
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		// reorder array
		int[] b = new int[a.length];
		// array before sorting
		print(a);
		b = reOrder(a, b, 0, 1, 0, a.length / 2);
		// array after sorting
		print(b);
	}

	public static int[] reOrder(int[] a, int[] b, int a_o, int a_e, int b_l, int b_r) {
		// check condition for stopping
		if (a_e > a.length) {
			return b;
		}
		b[b_l] = a[a_o];
		b[b_r] = a[a_e];
		a_o = a_o + 2;
		a_e = a_e + 2;
		b_l = b_l + 1;
		b_r = b_r + 1;
		return reOrder(a, b, a_o, a_e, b_l, b_r);
	}

	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
