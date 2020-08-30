package com.competitive.FossilSpringCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exam8 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("/Users/bvbang/Downloads/8.in"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/bvbang/Downloads/output.txt"));
		String line = reader.readLine();
		int n = Integer.valueOf(line);
		for (int i = 0; i < n; i++) {
			int x = Integer.valueOf(reader.readLine());
			String[] order = reader.readLine().split(" ");
			List<Integer> result = new ArrayList<>();
			for(int y=0;y<order.length;y++) {
				result.add(Integer.valueOf(order[y]));
			}
			Collections.sort(result);
			Collections.reverse(result);
			int bo = 1;
			Map<String,Integer> map = new HashMap<>();
			for(int y=0;y<order.length;y++) {
				System.out.println(result.get(y));
				
				if(y>0) {
					if(result.get(y) != result.get(y-1)) {
						bo = y+1;
					}
				}
				map.put(result.get(y).toString(), bo);
				
			}
			for(int y=0;y<order.length;y++) {
				if(y<order.length-1) {
				writer.write(map.get(order[y]).toString()+" ");
				}else {
					writer.write(map.get(order[y]).toString());
				}
			}
			//System.out.println();
			writer.write("\n");
		}
		// writer.write(resul"\n");
		writer.close();
		reader.close();
	}
}
