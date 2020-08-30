package com.competitive.FossilSpringCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Exam2 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
		String line = reader.readLine();
		String lowerLine = line.toLowerCase();
		System.out.println(line);
		for(int i=0;i<line.length();i++) {
			if(line.charAt(i) == lowerLine.charAt(i)) {
				System.out.print(line.charAt(i));
			}else {
				System.out.println();
				System.out.print(line.charAt(i));
			}
		}
		//writer.write(line+"\n");
		writer.close();
		reader.close();
	}
}
