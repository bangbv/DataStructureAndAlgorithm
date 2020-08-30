package com.algorithm.interview.world_quant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Question21 {
    public static void main(String[] args) throws Exception {
        System.out.println("Question12");
        ClassLoader classLoader = Question21.class.getClassLoader();
        String filename = java.net.URLDecoder.decode(classLoader.getResource("world_quant_q12.txt").getPath(), "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        int x = Integer.parseInt(bufferedReader.readLine());
        int spaceCount = Integer.parseInt(bufferedReader.readLine());
        List<Integer> spaces = new ArrayList<>();
        for (int i = 0; i < spaceCount; i++) {
            int space = Integer.parseInt(bufferedReader.readLine());
            spaces.add(space);
        }
        System.out.println(segment2(x, spaces));
        bufferedReader.close();
    }
    
    public static int segment2(int x, List<Integer> space) {
        int max = 0;
        int length = space.size();
        for (int i = 0; i < length; i++) {
            int range = i + x;
            if (range <= length) {
                int min = space.get(i);
                for (int j = i; j < range; j++) {
                    int s = space.get(j);
                    if (s < min) {
                        min = s;
                    }
                }
                if (min > max) max = min;
            }
        }
        return max;
    }

    public static int segment(int x, List<Integer> space) {
        int max = 0;
        int length = space.size();
        for (int i = 0; i < length; i++) {
            int range = i + x;
            if (range <= length) {
                int min = space.get(i);
                for (int j = i; j < range; j++) {
                    int s = space.get(j);
                    if (s < min) {
                        min = s;
                    }
                }
                if (min > max) max = min;
            }
        }
        return max;
    }

    static void printArray(List<int[]> arr) {
        for (int[] s : arr) {
            for (int x : s) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
