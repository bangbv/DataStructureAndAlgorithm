package FossilSpringCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Exam19 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("/Users/bvbang/Downloads/19.in"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/bvbang/Downloads/output.txt"));
		String line = reader.readLine();
		//int n = Integer.valueOf(line);
		String result = null;
		while (((line = reader.readLine()) != null)) {
			result = super_reduced_string(line);
			writer.write(result+"\n");
		}
		writer.close();
		reader.close();
	}
	
    static String super_reduced_string(String s){
		if(!s.equals("")) {
			for(int i = 0;i<s.length()-1;i++) {
				if(s.charAt(i) == s.charAt(i+1)) {
					StringBuilder tem = new StringBuilder();
					for(int j=0;j<s.length();j++) {
						if(j!=i && j != (i+1)) {
							tem.append(s.charAt(j));
						}
					}
					return super_reduced_string(tem.toString());
				}
			}
		}else{
            return "Empty String";
        }
		return s;
    }
}
