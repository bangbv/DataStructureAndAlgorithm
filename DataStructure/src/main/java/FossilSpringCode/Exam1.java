package FossilSpringCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Exam1 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
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
