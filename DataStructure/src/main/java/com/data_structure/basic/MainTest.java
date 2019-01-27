package com.data_structure.basic;

public class MainTest {

	public static void main(String[] args) {
		int x = -1;
		for (int i = 0; i < 48; i++) {
			int j = i % 6;
			if (j == 0) {
				System.out.println();
				x++;
			}
			System.out.print(x);
		}
	}

}
