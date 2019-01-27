package com.algorithm.brute_force;

/*
 Given 6 < k < 13
integers, enumerate all possible subsets of size 6 of these integers in sorted order.
Since the size of the required subset is always 6 
and the output has to be sorted lexicographically (the input is already sorted), 
the easiest solution is to use six nested loops as shown below. 
Note that even in the largest test case when k = 12, 
these six nested loops will only produce 12C6 = 924 lines of output. 
This is small.
 */
public class Lotto {
	public void gen() {
		int[] S = { 0, 1, 2, 3, 4, 5,6 };
		int k = 7;
		for (int a = 0; a < k - 5; a++) { // six nested loops!
			for (int b = a + 1; b < k - 4; b++) {
				for (int c = b + 1; c < k - 3; c++) {
					for (int d = c + 1; d < k - 2; d++) {
						for (int e = d + 1; e < k - 1; e++) {
							for (int f = e + 1; f < k; f++) {
								System.out.println(S[a] + "," + S[b] + "," + S[c] + "," + S[d] + "," + S[e] + "," + S[f]);
							}
						}
					}
				}
			}
		}
	}
}
