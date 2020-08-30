package com.algorithm.interview.line;

import java.io.BufferedReader;
import java.io.FileReader;

public class LineQuestion1 {
    public static void main(String[] args) throws Exception {
        System.out.println("LineQuestion1");
        ClassLoader classLoader = LineQuestion1.class.getClassLoader();
        String filename = java.net.URLDecoder.decode(classLoader.getResource("line_q1.txt").getPath(), "UTF-8");
        BufferedReader br = new BufferedReader(new FileReader(filename));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                StringBuilder sb = new StringBuilder(line[j]);
                if (j == line.length - 1) {
                    System.out.print(sb.reverse());
                } else {
                    System.out.print(sb.reverse() + " ");
                }
            }
            System.out.println();
        }
        br.close();
    }

    public static void myReverse(String[][] arr){
        for(int i = 0;i<arr.length;i++){
            for (int j = 0;j<arr[i].length;j++){
                StringBuilder sb = new StringBuilder(arr[i][j]);
                if(j == arr[i].length -1 ){
                    System.out.print(sb.reverse());
                } else {
                    System.out.print(sb.reverse()+" ");
                }
            }
            System.out.println();
        }
    }
}
