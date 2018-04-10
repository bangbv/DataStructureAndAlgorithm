package FossilSpringCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exam5 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("/Users/bvbang/Downloads/input.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/bvbang/Downloads/output.txt"));
		String line = reader.readLine();
		//int n = Integer.valueOf(line);
		
		while (((line = reader.readLine()) != null)) {
			List<Integer> numArr = new ArrayList<>();
			String[] digits = line.split("");
			for (int i = 0; i < digits.length; i++) {
				int num111 = Integer.valueOf(digits[i]);
				numArr.add(num111);
			}
		       Collections.sort(numArr);
		       System.out.println(numArr);
		       if (numArr.get(0) == 0) {
		           for(int i=0;i<numArr.size();i++) {
		        	   	if(i==0) {
		        	   		
		        	   	}else {
		        	   		if(i==1) {
		 		        	   //System.out.println(String.valueOf(numArr.get(i)));
				        	   	writer.write(String.valueOf(numArr.get(1)));
				        	   	writer.write(String.valueOf(numArr.get(0)));
		        	   		}else {
		 		        	   System.out.println(String.valueOf(numArr.get(i)));
				        	   	writer.write(String.valueOf(numArr.get(i)));
		        	   		}
		        	   	}
		        	   	

		           }
		           writer.write("\n");
		       } else {
		           for(int i=0;i<numArr.size();i++) {
		        	   System.out.println(String.valueOf(numArr.get(i)));
		        	   	writer.write(String.valueOf(numArr.get(i)));
		           }
		           writer.write("\n");
		       }
			
		}
		writer.close();
		reader.close();
	}
}
