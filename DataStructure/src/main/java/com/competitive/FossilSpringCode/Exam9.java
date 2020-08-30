package com.competitive.FossilSpringCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Exam9 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
		String line = null;
		while (((line = reader.readLine()) != null)) {
			System.out.println(line);
			writer.write(line+"\n");
		}
		writer.close();
		reader.close();
	}
}
