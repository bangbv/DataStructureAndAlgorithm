package com.algorithm.basic;

public class SwapNumber {
    public static void main(String[] args){
        System.out.println("Swap problem");
        int a = 3, b = 4;
        System.out.println("a:"+a+"-b:"+b);
        swap(a,b);
        System.out.println("a:"+a+"-b:"+b);
    }

    private static void swap(int a, int b){
        a = a+b;
        b =  a - b;
        a = a - b;
        System.out.println("a:"+a+"-b:"+b);
    }
}
