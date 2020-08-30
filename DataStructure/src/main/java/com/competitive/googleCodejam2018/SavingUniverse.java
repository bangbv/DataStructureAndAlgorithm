package com.competitive.googleCodejam2018;

import java.util.Scanner;

public class SavingUniverse {
	
	static boolean swap;

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		String line = null;
		swap = false;
		int N = Integer.valueOf(in.nextLine());
		for (int i = 1; i <= N; i++) {
			line = in.nextLine();
			String[] lSplit = line.split(" ");
			int totalDamage = Integer.valueOf(lSplit[0]);
			int result = 0;
			String program = lSplit[1];
			long ntd = totalDamage(program);
			if (ntd <= totalDamage) {
				System.out.println("Case #" + i + ": " + result + "\n");
			}
			while ((totalDamage < ntd)) {
				program = hack(program);
				ntd = totalDamage(program);
				if (swap) {
					result = result + 1;
					swap = false;
					if (ntd <= totalDamage) {
						System.out.println("Case #" + i + ": " + result + "\n");
						break;
					}
				} else {
					if (ntd > totalDamage) {
						System.out.println("Case #" + i + ": IMPOSSIBLE\n");
						break;
					} else {
						System.out.println("Case #" + i + ": " + result + "\n");
						break;
					}
				}
			}
		}
		in.close();
	}

	static String hack(String line) {
		StringBuilder newString = new StringBuilder();
		int i = line.length() - 1;
		while (i > 0) {
			if ((line.charAt(i) == 'S') && (line.charAt(i - 1) == 'C') && !swap) {
				newString.append(line.charAt(i - 1));
				newString.append(line.charAt(i));
				swap = true;
				i--;
				i--;
				break;
			} else {
				newString.append(line.charAt(i));
				i--;
			}
		}
		if (i == 0 && !swap) {
			newString.append(line.charAt(i));
		}
		while (swap && i >= 0) {
			newString.append(line.charAt(i));
			i--;
		}
		return newString.reverse().toString();
	}

	static long totalDamage(String line) {
		long result = 0;
		long currentDamage = 1;
		int j = 1;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == 'S') {
				result = result + currentDamage;
			} else {
				currentDamage = (long) Math.pow(2, j++);
			}
		}
		return result;
	}
}
