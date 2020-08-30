package com.algorithm.string;

public class ValidPalindromeII {
    // https://leetcode.com/problems/valid-palindrome-ii/
    public static boolean validPalindrome(String s) {
        int length = s.length();
        int i = 0;
        int j = length-1;
        StringBuilder removeLeft;
        StringBuilder removeRight;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                removeLeft = new StringBuilder();
                removeRight = new StringBuilder();
                removeLeft.append(s, 0, i);
                removeLeft.append(s, i+1, length);
                removeRight.append(s, 0, j).append(s, j+1, length);
                if (isPalindrome(removeLeft.toString())) {
                    i++;
                } else if (isPalindrome(removeRight.toString())) {
                    j--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        //String input = "abbac";
        String input = "abca";
        //String input = "cbbcc";
        //String input = "eeed";
        //String input = "deee";
        //String input = "abc";
        //System.out.println(input.substring(0,0));
        //System.out.println(validPalindrome2(input));
        System.out.println(validPalindrome(input));
    }
}
