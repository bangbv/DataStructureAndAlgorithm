package algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;

public class ArrayManipulation {

	public static void main(String[] args) throws Exception {
		URL url = ArrayManipulation.class.getResource("test.txt");
		String filename = java.net.URLDecoder.decode(url.getPath(),"UTF-8");
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String line = reader.readLine();
		String[] lineSplit = line.split(" ");
        int n = Integer.valueOf(lineSplit[0]);
        int m = Integer.valueOf(lineSplit[1]);
        long[] update_array = new long[n];
        long max = 0;
        long temp = 0;
        for(int a0 = 0; a0 < m; a0++){
        		line = reader.readLine();
        		lineSplit = line.split(" ");
            int a = Integer.valueOf(lineSplit[0]);
            int b = Integer.valueOf(lineSplit[1]);
            int k = Integer.valueOf(lineSplit[2]);
            update_array[a-1] +=k;
            if(b<n){
                update_array[b] -= k;
            }
        }
        reader.close();
        for(int i=0;i<n;i++){
            temp += update_array[i];
            if(temp>max){
                max = temp;
            }
        }
        System.out.println(max);
	}


	
}
