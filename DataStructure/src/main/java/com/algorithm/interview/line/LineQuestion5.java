package com.algorithm.interview.line;

import java.io.BufferedReader;
import java.io.FileReader;

public class LineQuestion5 {
    public static void main(String[] args) throws Exception {
        System.out.println("LineQuestion5");
        ClassLoader classLoader = LineQuestion5.class.getClassLoader();
        String filename = java.net.URLDecoder.decode(classLoader.getResource("line_q5.txt").getPath(), "UTF-8");
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String[] line = br.readLine().split(" ");
        int length = line.length;
        int[] arr = new int[length];
        int i = 0;
        for (String l : line) {
            arr[i++] = Integer.parseInt(l);
        }
        int x = Integer.parseInt(br.readLine());

        int first_min = Math.min(arr[0], arr[1]);
        int second_min = Math.max(arr[0], arr[1]);
        for (i = 2; i < length; i++) {
            if (arr[i] < first_min) {
                second_min = first_min;
                first_min = arr[i];
            } else if (arr[i] < second_min)
                second_min = arr[i];
        }

        System.out.println(first_min * second_min);

        br.close();
    }
}
