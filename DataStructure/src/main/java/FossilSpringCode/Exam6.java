package FossilSpringCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Exam6 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("/Users/bvbang/Downloads/14.in"));
	    BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/bvbang/Downloads/output.txt"));
	    String line = reader.readLine();
	    
	       while (((line = reader.readLine()) != null)) {
	           int x = 0;
	           int i = 0;
	           while ( i < line.length()) {
	                 x += Character.getNumericValue(line.charAt(i));
	                 i++;
	                 if ( i == line.length() && x != 0  && x >= 10) {
	                   line = String.valueOf(x);
	                   x = 0;
	                   i = 0;
	               }    
	           }
	           writer.write(String.valueOf(x));
	           writer.write("\n");
	       }
	               
	       writer.close();
	       reader.close();
	}
}
