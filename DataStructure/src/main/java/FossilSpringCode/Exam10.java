package FossilSpringCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
//import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.*;

public class Exam10 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("/Users/bvbang/Downloads/8.in"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/bvbang/Downloads/output.txt"));
		String line = reader.readLine();
		int n = Integer.valueOf(line);
		for (int i = 0; i < n; i++) {
			String date = reader.readLine();
			//DateTimeFormatter f = DateTim.forPattern("dd/MM/yyyy");
			//DateTim dateTime = f.parseDateTime(date);
			Calendar calendar = Calendar.getInstance();
			int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);  
			//System.out.println();
			writer.write("\n");
		}
		// writer.write(resul"\n");
		writer.close();
		reader.close();
	}
}
