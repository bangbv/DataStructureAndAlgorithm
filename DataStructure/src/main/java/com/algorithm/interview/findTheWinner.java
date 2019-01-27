package com.algorithm.interview;

import java.util.ArrayList;
import java.util.List;

public class findTheWinner {

	public static void main(String[] args) {
		List<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(1);
		// a.add(3);
		List<Integer> m = new ArrayList<Integer>();
		a.add(1);
		a.add(1);
		// a.add(3);

		String result = winner(a, m, "Even");
		System.out.println(result);
	}

	public static String winner(List<Integer> andrea, List<Integer> maria, String s) {
		int i;
		int a = 0;
		int m = 0;
		if (s.equalsIgnoreCase("Even")) {
			i = 0;
			while (i < andrea.size() && i < maria.size()) {
				a = a + (andrea.get(i) - maria.get(i));
				m = m + (maria.get(i) - andrea.get(i));
				i = i + 2;
			}
		}
		if (s.equalsIgnoreCase("Even")) {
			i = 1;
			while (i < andrea.size() && i < maria.size()) {
				a = a + (andrea.get(i) - maria.get(i));
				m = m + (maria.get(i) - andrea.get(i));
				i = i + 2;
			}
		}

		if (a > m) {
			return "Andrea";
		} else if (a < m) {
			return "Maria";
		}else {
			return "Tie";
		}
	}
}
