package com.competitive.FossilSpringCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Exam20 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("/Users/bvbang/Downloads/20.in"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/bvbang/Downloads/output.txt"));
		String line = reader.readLine();
		while (((line = reader.readLine()) != null)) {
			String[] result = line.split(" ");
			String str = result[1];
		    String findStr = result[0];
		       int lastIndex = 0;
		       int count = 0;
		       while(lastIndex != -1){

		           lastIndex = str.indexOf(findStr,lastIndex);

		           if(lastIndex != -1){
		               count ++;
		               lastIndex += findStr.length();
		           }
		       }
		       		System.out.println(count);
		       		writer.write(String.valueOf(count)+"\n");
		       }
		//writer.write(resul"\n");
		writer.close();
		reader.close();
	}
}
