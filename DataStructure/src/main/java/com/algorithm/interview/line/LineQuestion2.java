package com.algorithm.interview.line;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LineQuestion2 {
    public static void main(String[] args) throws Exception {
        System.out.println("LineQuestion2");
        ClassLoader classLoader = LineQuestion2.class.getClassLoader();
        String filename = java.net.URLDecoder.decode(classLoader.getResource("line_q2.txt").getPath(), "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        int n = Integer.parseInt(bufferedReader.readLine());
        List<List<String>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            System.out.println(line[0]);
        }
        bufferedReader.close();
    }
}
