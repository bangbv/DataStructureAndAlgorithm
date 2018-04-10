package algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;

public class CompareFiles2 {

	@SuppressWarnings({"resource"})
	public static void main(String[] args) throws Exception{
		//String output = "/output_gsp.txt";
		//String output = "";
		String output = "input.txt";
		URL url1 = CompareFiles.class.getResource(output);
		String filename1 = java.net.URLDecoder.decode(url1.getPath(),"UTF-8");
		BufferedReader reader1 = new BufferedReader(new FileReader(filename1));
		//String output2 = "/output_gsp.txt";
		
		String line = reader1.readLine();
		while (((line = reader1.readLine()) != null)) {
			String[] lineSplit = line.split(" ");
			int a = Integer.valueOf(lineSplit[0]);
			int b = Integer.valueOf(lineSplit[1]);
			int result = a % b;
			System.out.println(result);
		}
	}

}
