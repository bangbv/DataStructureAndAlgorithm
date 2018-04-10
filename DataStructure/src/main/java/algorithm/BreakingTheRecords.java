package algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;

public class BreakingTheRecords {
	
	static int[] breakingRecords(int[] score) {
		// Complete this function
		int[] result = new int[2];
		int max = score[0];
		int worse = score[0];
		int h = 0;
		int w = 0;
		int temp = 0;
		for (int i = 0; i < score.length; i++) {
			temp = score[i];
			if (temp > max) {
				h++;
				max = temp;
			}
			if (temp < worse) {
				w++;
				worse = temp;
			}
		}
		result[0] = h;
		result[1] = w;
		return result;
	}

	public static void main(String[] args) throws Exception {
		URL url = CompareFiles.class.getResource("input.txt");
		String filename = java.net.URLDecoder.decode(url.getPath(),"UTF-8");
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		int n = Integer.valueOf(reader.readLine());
		int[] score = new int[n];
		String[] sequence = reader.readLine().split(" ");
		for (int score_i = 0; score_i < sequence.length; score_i++) {
			score[score_i] = Integer.valueOf(sequence[score_i]);
		}
		int[] result = breakingRecords(score);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
		}
		System.out.println("");

		reader.close();
	}

}
