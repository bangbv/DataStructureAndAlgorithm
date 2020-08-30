package com.algorithm.interview.line;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;

public class LineQuestion4 {
    public static void main(String[] args) throws Exception {
        System.out.println("LineQuestion4");
        ClassLoader classLoader = LineQuestion4.class.getClassLoader();
        String filename = java.net.URLDecoder.decode(classLoader.getResource("line_q4.txt").getPath(), "UTF-8");
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String[] info = (br.readLine().trim().split(" "));
        int n = Integer.parseInt(info[0]);
        int c = Integer.parseInt(info[1]);
        Queue<String> myQ = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().trim().split(" ");
            if (line[0].equalsIgnoreCase("SIZE")) {
                System.out.println(myQ.size());
            } else if (line[0].equalsIgnoreCase("TAKE")) {
                if (!myQ.isEmpty()) {
                    System.out.println(myQ.poll());
                }
            } else if (line[0].equalsIgnoreCase("OFFER")) {
                if (myQ.size() < c) {
                    myQ.offer(line[1]);
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
        }
        br.close();
    }
}
