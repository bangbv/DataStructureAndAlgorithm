package com.algorithm.basic;

public class BetweenTwoSet {

	static int getTotalX(int[] a, int[] b) {
		// Complete this function
		int count = 0;
		boolean check_a = true;
		boolean check_b = true;
		for (int x = 0; x < 100; x++) {
			for (int y = 0; y < a.length; y++) {
				if (x % a[y] != 0) {
					check_a = false;
				}
			}
			for (int z = 0; z < b.length; z++) {
				if (x > 0) {
					if (b[z] % x != 0) {
						check_b = false;
					}
				}
			}
			if (check_a && check_b) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		/*
		 * Scanner in = new Scanner(System.in); int n = in.nextInt(); int m =
		 * in.nextInt(); int[] a = new int[n]; for(int a_i = 0; a_i < n; a_i++){ a[a_i]
		 * = in.nextInt(); } int[] b = new int[m]; for(int b_i = 0; b_i < m; b_i++){
		 * b[b_i] = in.nextInt(); }
		 */
		int n = 2;
		int m = 3;
		int[] a = { 2, 4 };
		int[] b = { 16, 32, 96 };
		int total = getTotalX(a, b);
		System.out.println(total);
		// in.close();
	}

}
