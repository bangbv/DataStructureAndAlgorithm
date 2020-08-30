package com.algorithm.interview.world_quant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CounterfeitCurrency {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = CounterfeitCurrency.class.getClassLoader();
        String filename = java.net.URLDecoder.decode(classLoader.getResource("world_quant_q32.txt").getPath(), "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        int n = Integer.parseInt(bufferedReader.readLine());
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(bufferedReader.readLine().trim());
        }
        System.out.println(countCounterfeit(arr));
        bufferedReader.close();
    }

    public static int countCounterfeit(List<String> serialNumber) {
        int billWorth = 0;
        int value = 0;
        int lv = 0;
        boolean isCounterfeit = true;
        String[] values = {"1000", "500", "200", "100", "50", "20", "10"};
        for (String s : serialNumber) {
            int length = s.length();
            if (length >= 10 && length <= 12) {
                String eLetters = s.substring(0, 3);
                boolean hasLowercase = !eLetters.equals(eLetters.toUpperCase());
                if (hasLowercase || !uniqueCharacters(eLetters)) {
                    isCounterfeit = false;
                }
                if (s.substring(3, 7).matches("[0-9]*")) {
                    int year = Integer.parseInt(s.substring(3, 7));
                    if (year < 1900 || year > 2019) {
                        isCounterfeit = false;
                    }
                } else {
                    isCounterfeit = false;
                }

                String nextCh = s.substring(7, length - 1);
                boolean check_number = nextCh.matches("[0-9]*");
                for (String v : values) {
                    if (nextCh.contains(v) && check_number) {
                        value = Integer.parseInt(v);
                        lv = v.length();
                        break;
                    }
                }
                String lastLetter = s.substring(7 + lv, length);
                if (lastLetter.equals(lastLetter.toLowerCase())) {
                    isCounterfeit = false;
                }
            }
            if (isCounterfeit) {
                billWorth = billWorth + value;
            }
            value = 0;
            lv = 0;
            isCounterfeit = true;
        }
        return billWorth;
    }

    static boolean uniqueCharacters(String str) {
        for (int i = 0; i < str.length(); i++)
            for (int j = i + 1; j < str.length(); j++)
                if (str.charAt(i) == str.charAt(j))
                    return false;
        return true;
    }

}
