package com.algorithm.interview;

public class ThrowingAwayCard {

	public static void main(String[] args) {
		int[] a = {19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
		int[] rs = throwing(a);
		System.out.println(rs[0]);
	}
	
	public static int[] throwing(int[] a) {
		int l = a.length-1;
		System.out.print(a[l]+" ");
		if(l<2) {
			System.out.println();
			return a;
		}
		int[] rs = new int[l];
		rs[0] = a[--l];
		int j = 0;
		for(int i = 1;i<rs.length;i++) {
			rs[i] = a[j++];
		}
		return throwing(rs);
	}

}
