package com.algorithm.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ReplaceString {

	public static void main(String[] args) throws Exception {
		int count = 0;
		String filename = "C:\\Users\\RC46FW\\Documents\\data\\data_table_01.csv";
		String new_filename = "C:\\Users\\RC46FW\\Documents\\data\\data_table_01_new.csv";
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		BufferedWriter writer = new BufferedWriter(new FileWriter(new_filename));
		String delimiter = ",";
		String line = null;
		StringBuilder new_line = new StringBuilder();
		String path = null;
		String building = null;
		String floor = null;
		String[] temp_str;
		while (((line = reader.readLine()) != null)) {
			temp_str = line.split("BLD");
			path = temp_str[1];
			new_line.append(temp_str[0]+"BLD");
			new_line.append(temp_str[1].split(",")[0]+",");
			if (path.contains("tianqiao") || path.contains("shiwai")) {
				building = "";
				floor = "";
			} else {
				building = path.split("/")[0].split("-")[1];
				floor = path.split("/")[1].split(" ")[1].split(",")[0].replaceAll("\"", "");
			}
			new_line.append("\"");
			new_line.append(building);
			new_line.append("\"");
			new_line.append(delimiter);
			new_line.append(floor);
			new_line.append(delimiter);
			new_line.append(temp_str[1].split(",")[1]);
			
			writer.write(new_line.toString()+"\r\n");
			new_line = new StringBuilder();
			count++;
		}

		writer.close();
		reader.close();
		System.out.println(count);
	}
}
