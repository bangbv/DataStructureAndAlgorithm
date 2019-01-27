package com.algorithm.brute_force;

/*
Find and display all pairs of 5-digit numbers that collectively
use the digits 0 through 9 once each, such that the first number divided by the second is
equal to an integer N, where 2 ≤ N ≤ 79. That is, abcde / fghij = N, where each letter
represents a different digit. The first digit of one of the numbers is allowed to be zero, e.g.
for N = 62, we have 79546 / 01283 = 62; 94736 / 01528 = 62. 
 */
public class Division {
	public void division(int N) {
		for(int fghij = 1234; fghij <= 98765/N; fghij++) {
			int abcde = fghij * N;
			// check
			int tmp, used = (fghij < 10000)? 0: 1;
			tmp = abcde;
			if(true) {
				System.out.println();
			}
		}
	}
}
