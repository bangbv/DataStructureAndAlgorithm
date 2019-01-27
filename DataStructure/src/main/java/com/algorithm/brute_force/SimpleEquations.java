package com.algorithm.brute_force;

/*
Given three integers A, B, and C (1 ≤ A, B, C ≤ 10000),
find three other distinct integers x, y, and z such that x + y + z = A, x × y × z = B, and
x2 + y2 + z2 = C.
The third equation x2 + y2 + z2 = C is a good starting point. Assuming that C has
the largest value of 10000 and y and z are one and two (x, y, z have to be distinct), then
the possible range of values for x is [−100 . . . 100]. We can use the same reasoning to get a
similar range for y and z. We can then write the following triply-nested iterative solution
below that requires 201 × 201 × 201 ≈ 8M operations per test case. 
 */
public class SimpleEquations {
	public static void main(String[] args) {
		
	}
	
	static void simpleEquations(int A,int B,int C) {
		boolean sol = false;
		for(int x = -100;x<=100;x++) {
			for(int y = -100;y<=100;y++) {
				for(int z = -100;z<=100;z++) {
					if(x!=y && x!=z && y!=z && x+y+z==A && x*y*z==B && x*x+y*y+z*z==C) {
						if(!sol) {
							System.out.println();
							sol = true;
						}
					}
				}				
			}			
		}
	}
}
