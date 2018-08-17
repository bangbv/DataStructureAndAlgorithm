package com.algorithm.basic;

public class GradingStudents {

	static int[] solve(int[] grades) {
		return grades;
	}

	public static void main(String[] args) throws Exception{
/*		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] grades = new int[n];
		for (int grades_i = 0; grades_i < n; grades_i++) {
			grades[grades_i] = in.nextInt();
		}
		int[] result = solve(grades);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
		}
		System.out.println("");
		in.close();*/
		
		for(int i=0;i<6;i++) {
			System.out.println(i%5);
		}
	}
}
