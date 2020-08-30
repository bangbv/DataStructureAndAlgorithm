package com.algorithm.interview.line;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class LineQuestion7 {
    public static void main(String[] args) throws Exception {
        System.out.println("LineQuestion7");
        ClassLoader classLoader = LineQuestion7.class.getClassLoader();
        String filename = java.net.URLDecoder.decode(classLoader.getResource("line_q7.txt").getPath(), "UTF-8");
        BufferedReader br = new BufferedReader(new FileReader(filename));
        int w = Integer.parseInt(br.readLine());
        Queue<String> mWindow = new ArrayDeque<>(w);
        String line;
        int count = 1;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (mWindow.size() < 1) {
                mWindow.add(line);
            } else {
                String max = mWindow.peek();
                int check = compare(line, max);
                if (check > 0) {
                    mWindow.poll();
                    mWindow.offer(line);
                }
            }
            if(count >= w) {
                System.out.println(mWindow.peek());
            }
            count++;
        }
        br.close();
    }

    static int compare(String x, String y) {
        boolean dx = "-".equalsIgnoreCase(String.valueOf(x.charAt(0)));
        boolean dy = "-".equalsIgnoreCase(String.valueOf(y.charAt(0)));
        int xl = x.length();
        int yl = y.length();
        if(dx && dy){
            if (xl != yl) return xl - yl;
            for (int i = 1; i < xl; i++) {
                char left = x.charAt(i);
                char right = y.charAt(i);
                if (left != right)
                    return left - right;
            }
        } else if (dx && !dy){
            return -1;
        } else if (!dx && dy){
            return 1;
        } else if (!dx && !dy){
            if (xl != yl) return xl - yl;
            for (int i = 0; i < xl; i++) {
                char left = x.charAt(i);
                char right = y.charAt(i);
                if (left != right)
                    return left - right;
            }
        }
        return 0;
    }
}
