package com.competitive.FossilSpringCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Exam4 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
		String line = reader.readLine();
		int n = Integer.valueOf(line);
		for(int i=0;i<n;i++) {
			line = reader.readLine();
			String[] ar = line.split(" ");
			System.out.println(Integer.valueOf(ar[0])+Integer.valueOf(ar[1]));
			writer.write(Integer.valueOf(ar[0])+Integer.valueOf(ar[1])+"\n");
		}
		writer.close();
		reader.close();
	}
}
