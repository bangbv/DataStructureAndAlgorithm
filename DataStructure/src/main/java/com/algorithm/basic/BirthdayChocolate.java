package com.algorithm.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;

public class BirthdayChocolate {
	
	static int solve(int n, int[] s,int d, int m) {
		int result = 0;
		int i;
		int j;
		int tempd;
		for(i=0;i<=(n-m);i++) {
			tempd = 0;
			for(j=i;j<(i+m);j++) {
				tempd += s[j];
			}
			if(tempd == d) {
				result++;
			}
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		URL url = CompareFiles.class.getResource("input.txt");
		String filename = java.net.URLDecoder.decode(url.getPath(),"UTF-8");
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		int n = Integer.valueOf(reader.readLine());
		int i = 0;
		int[] s = new int[n];
		String[] sequence = reader.readLine().split(" ");
		for (i = 0; i < sequence.length; i++) {
			s[i] = Integer.valueOf(sequence[i]);
		}
		String[] cd = reader.readLine().split(" ");
		reader.close();
		int d = Integer.valueOf(cd[0]);
		int m = Integer.valueOf(cd[1]);
		int result = solve(n,s,d,m);
		System.out.println(result);
		
	}

}
