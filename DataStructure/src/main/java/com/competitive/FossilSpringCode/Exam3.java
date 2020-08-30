package com.competitive.FossilSpringCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Exam3 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
		int result = 0;
		boolean flag;
		String numbers = "0123456789";
		String lower_case = "abcdefghijklmnopqrstuvwxyz";
		String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String special_characters = "!@#$%^&*()-+";
		String line = reader.readLine();
		line = reader.readLine();
		if(line.length() <= 6) {
			result = 6-line.length();
		}
		flag =false;
		for(int i=0;i<line.length();i++) {
			if(numbers.contains(String.valueOf(line.charAt(i)))) {
				flag = true;
				break;
			}
		}
		if(!flag) {
			result++;
		}
		flag =false;
		for(int i=0;i<line.length();i++) {
			if(lower_case.contains(String.valueOf(line.charAt(i)))) {
				flag = true;
				break;
			}
		}
		if(!flag) {
			result++;
		}
		flag =false;
		for(int i=0;i<line.length();i++) {
			if(upper_case.contains(String.valueOf(line.charAt(i)))) {
				flag = true;
				break;
			}
		}
		if(!flag) {
			result++;
		}
		flag =false;
		for(int i=0;i<line.length();i++) {
			if(special_characters.contains(String.valueOf(line.charAt(i)))) {
				flag = true;
				break;
			}
		}
		if(!flag) {
			result++;
		}
		System.out.println(result);
		writer.close();
		reader.close();
	}
}
