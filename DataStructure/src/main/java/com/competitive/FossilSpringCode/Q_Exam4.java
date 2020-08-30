package com.competitive.FossilSpringCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Q_Exam4 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("/Users/bvbang/Documents/workspace/DataStructureAndAlgorithm/DataStructure/src/main/resources/input.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/bvbang/Documents/workspace/DataStructureAndAlgorithm/DataStructure/src/main/resources/output.txt"));
		String line = null;
		while (((line = reader.readLine()) != null)) {
			line = line.replaceAll("\\s+","");
			System.out.println(line);
			writer.write(line+"\n");
		}
		//writer.write(result);
		writer.close();
		reader.close();
	}
	

}
