package algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CompareFiles {

	public static void main(String[] args) throws Exception{
		URL url1 = CompareFiles.class.getResource("output1.txt");
		String filename1 = java.net.URLDecoder.decode(url1.getPath(),"UTF-8");
		BufferedReader reader1 = new BufferedReader(new FileReader(filename1));
		URL url2 = CompareFiles.class.getResource("output2.txt");
		String filename2 = java.net.URLDecoder.decode(url2.getPath(),"UTF-8");
		BufferedReader reader2 = new BufferedReader(new FileReader(filename2));
		
		ArrayList a2 = new ArrayList();
		String line2;
		while (((line2 = reader2.readLine()) != null)) {
			a2.add(line2);
		}
		
		String line1;
		int count = 0;
		while (((line1 = reader1.readLine()) != null)) {
			if(!a2.contains(line1)) {
				System.out.println(line1);
				count++;
			}
		}
		System.out.println("count:"+count);
		
		Map<Integer,Integer> a = new HashMap();
		//a.con
	}

}
