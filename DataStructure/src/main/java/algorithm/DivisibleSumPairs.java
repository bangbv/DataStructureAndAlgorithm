package algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;

public class DivisibleSumPairs {
	
	static int divisibleSumPairs(int n, int k,int[] ar) {
		int result = 0;
		int i;
		int j;
		for(i=0;i<(n-1);i++) {
			for(j=i+1;j<n;j++) {
				if(((ar[i]+ar[j]) % k) == 0) {
					result++;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		URL url = CompareFiles.class.getResource("input.txt");
		String filename = java.net.URLDecoder.decode(url.getPath(),"UTF-8");
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String[] cd = reader.readLine().split(" ");
		int n = Integer.valueOf(cd[0]);
		int k = Integer.valueOf(cd[1]);
		int i = 0;
		int[] ar = new int[n];
		String[] sequence = reader.readLine().split(" ");
		for (i = 0; i < n; i++) {
			ar[i] = Integer.valueOf(sequence[i]);
		}
		reader.close();
		int result = divisibleSumPairs(n,k,ar);
		System.out.println(result);
		
	}

}
