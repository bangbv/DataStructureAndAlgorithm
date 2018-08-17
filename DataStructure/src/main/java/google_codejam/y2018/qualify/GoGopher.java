package google_codejam.y2018.qualify;

import java.util.Scanner;

public class GoGopher {
	
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		String line = null;
		int N = Integer.valueOf(in.nextLine());
		for (int i = 1; i <= N; i++) {
			int length = Integer.valueOf(in.nextLine());
			line = in.nextLine();
			String[] lSplit = line.split(" ");
			long[] ar = new long[length];
			int j = 0;
			for (String str : lSplit) {
				ar[j++] = Long.valueOf(str);
			}
			long[] nA = troubleSort(ar);
			boolean check = true;
			for (int x = 0; x < nA.length - 1; x++) {
				if (nA[x] > nA[x + 1]) {
					System.out.println("Case #" + i + ": " + x + "\n");
					check = false;
					break;
				}
			}
			if (check) {
				System.out.println("Case #" + i + ": OK\n");
			}
			check = true;
		}
		in.close();
	}

	static long[] troubleSort(long[] ar) {
		boolean done = false;
		while (!done) {
			done = true;
			for (int i = 0; i < ar.length - 2; i++) {
				if (ar[i] > ar[i + 2]) {
					done = false;
					long temp = ar[i];
					ar[i] = ar[i + 2];
					ar[i + 2] = temp;
				}
			}
		}
		return ar;
	}
}
