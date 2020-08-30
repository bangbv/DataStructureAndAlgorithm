package com.algorithm.interview.world_quant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class FunWithAnagrams {
    public static void main(String[] args) throws Exception {
        System.out.println("Question13");
        ClassLoader classLoader = FunWithAnagrams.class.getClassLoader();
        String filename = java.net.URLDecoder.decode(classLoader.getResource("world_quant_q13.txt").getPath(), "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        int n = Integer.parseInt(bufferedReader.readLine());
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();
            arr.add(line);
        }
        printArray(funWithAnagrams(arr));
        bufferedReader.close();
    }

    public static List<String> funWithAnagrams(List<String> text) {
        List<String> result = new ArrayList<>();
        boolean add = true;
        for (String line : text) {
            if (!result.contains(line)) {
                for (String str : result) {
                    if (arePermutation(line, str)) {
                        add = false;
                    }
                }
                if (add) {
                    result.add(line);
                }
            }
        }
        Collections.sort(result);
        return result;
    }

    static boolean arePermutation(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        if (n1 != n2)
            return false;
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        for (int i = 0; i < n1; i++)
            if (ch1[i] != ch2[i])
                return false;
        return true;
    }

    static void printArray(List<String> arr) {
        for (String s : arr) System.out.print(s + " ");
        System.out.println();
    }
}
