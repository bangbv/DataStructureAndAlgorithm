package com.algorithm.searching;

public class PairSum {

	public static void main(String[] args) {
		int[] input = {-8, 1, 4, 6, 10, 45};
		findPair(input,16);
	}
	
	static void findPair(int[] a, int x) {
		int l = 0;
		int r = a.length-1;
		while(l<r) {
			int sum = a[l]+a[r];
			if(sum>x) {
				r--;
			}else if (sum<x) {
				l++;
			}else {
				System.out.println("result:"+a[l]+"-"+a[r]);
				return;
			}
		}
	}

}
