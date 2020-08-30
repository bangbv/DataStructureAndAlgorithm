package com.algorithm.string;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
public class MakingAnagrams {
    public static void main(String[] args) {
        String a = "fcrxzwscanmligyxyvym";
        String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
        System.out.println(makeAnagram(a, b));
        System.out.println(numberNeeded(a, b));
    }

    public static int numberNeeded(String first, String second) {
        int[] counter = new int[256];
        int common = 0;
        if (first.length() < 1 || second.length() < 1) {
            return 0;
        }
        for (int i = 0; i < first.length(); i++) {
            int x = first.charAt(i) - 'a';
            counter[x]++;
        }
        for (int i = 0; i < second.length(); i++) {
            int x = second.charAt(i) - 'a';
            if (counter[x] > 0) {
                common++;
                counter[x]--;
            }
        }
        return first.length() + second.length() - 2 * common;
    }

    static int makeAnagram(String a, String b) {
        ArrayList<String> subA = new ArrayList<>();
        ArrayList<String> subB = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            for (int j = i + 1; j <= a.length(); j++) {
                subA.add(a.substring(i, j));
            }
        }

        for (int i = 0; i < b.length(); i++) {
            for (int j = i + 1; j <= b.length(); j++) {
                subB.add(b.substring(i, j));
            }
        }

        String result = "";
        for (String sta : subA) {
            for (String stb : subB) {
                if (isAnagram(sta, stb)) {
                    if (sta.length() > result.length()) {
                        result = sta;
                    }
                }
            }
        }
        return ((a.length() - result.length()) + (b.length() - result.length()));
    }

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        } else {
            char[] ca = a.toCharArray();
            char[] cb = b.toCharArray();
            Arrays.sort(ca);
            Arrays.sort(cb);
            for (int i = 0; i < a.length(); i++) {
                if (ca[i] != cb[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
