package com.algorithm.string;

public class LongestPalindrome {
    public void printLongestPalindrome(String str){
        int length = str.length();
        String result = "";
        for(int i =0; i< length;i++){
            for(int j = i+1;j<=length;j++){
                String sub = str.substring(i,j);
                if(palindrome(sub)){
                    if(sub.length() > result.length())
                        result= sub;
                }
            }
        }
        System.out.println(result);
    }

    private boolean palindrome(String str) {
        StringBuilder reverse_str = new StringBuilder(str);
        return str.equals(reverse_str.reverse().toString());
    }
}
