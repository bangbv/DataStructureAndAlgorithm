package com.algorithm.string;

public class StringCompare {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        System.out.println(stringCompare(a, b));
    }

    public static int stringCompare(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);
        for (int i = 0; i < lmin; i++) {
            int str1_ch = str1.charAt(i);
            int str2_ch = str2.charAt(i);
            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }
        if (l1 != l2) {
            return l1 - l2;
        } else {
            return 0;
        }
    }
}
