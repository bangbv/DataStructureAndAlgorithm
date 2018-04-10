package google.code.jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

public class CountSheep {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws Exception {
		//BufferedReader reader = new BufferedReader(new FileReader("/Users/bvbang/Downloads/A-large-practice.in"));
		BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/bvbang/Downloads/output.txt"));
		String line = null;
		int N = Integer.valueOf(reader.readLine());
		long x = -1;
		int lol = 0;
		for (int i = 1; i <= N; i++) {
			Set rsSet = new HashSet();
			long result = 0;
			line = reader.readLine();
			x = Integer.valueOf(line);
			if (x != 0) {
				long next = x;
				while (rsSet.size() != 10) {
					String temp = String.valueOf(next);
					lol = temp.length();
					for (int j = 0; j < lol; j++) {
						rsSet.add(temp.charAt(j));
					}
					if (rsSet.size() == 10) {
						break;
					}
					result = result + 1;
					next = result * x;
				}
				writer.write("Case #" + i + ": " + next + "\n");
			} else {
				writer.write("Case #" + i + ": INSOMNIA\n");
			}
		}
		writer.close();
		reader.close();
	}

}
