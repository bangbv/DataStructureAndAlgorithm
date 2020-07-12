package com.algorithm.string;

public class Palindrome {

    public static void main(String[] args){
        System.out.println("Palindrome problem");
        String input = "aba";
        palindrome(input);
    }

    public static void palindrome(String str){
        StringBuilder reverse_str = new StringBuilder();
        int length = str.length();
        for(int i = length-1 ; i >= 0;i--){
            reverse_str.append(str.charAt(i));
        }

        if(str.equals(reverse_str.toString())){
            System.out.println("Palindrome");
        }else {
            System.out.println("Not Palindrome");
        }
    }
}
