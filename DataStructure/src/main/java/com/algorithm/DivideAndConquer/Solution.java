package com.algorithm.DivideAndConquer;

public class Solution {
	public static void main(String[] args) {
		int[] a = { 10, 7, 3, 5, 8, 2, 9 };
		SelectionProblem sp = new SelectionProblem();
		int rs = sp.randomizedSelection(a, 0, a.length - 1, 2);
		System.out.println("result:"+a[rs]);
	}
}
