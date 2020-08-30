package com.algorithm.sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FullCountingSort {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = FullCountingSort.class.getClassLoader();
        String filename = java.net.URLDecoder.decode(classLoader.getResource("full_counting_sort_input.txt").getPath(), "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        int size = Integer.parseInt(bufferedReader.readLine());
        StringBuffer[] st = new StringBuffer[100];

        for (int i = 0; i < 100; i++) {
            st[i] = new StringBuffer();
        }

        for (int i = 0; i < size; i++) {
            String[] str = bufferedReader.readLine().split(" ");
            int k = Integer.parseInt(str[0]);
            String s;
            if (i < size / 2)
                s = "- ";
            else
                s = str[1] + " ";
            st[k] = st[k].append(s);
        }

        for (int i = 0; i < 100; i++) {
            System.out.print(st[i]);
        }
    }

//    public static void main(String[] args) throws Exception {
//        System.out.println("FullCountingSort");
//        ClassLoader classLoader = FullCountingSort.class.getClassLoader();
//        String filename = java.net.URLDecoder.decode(classLoader.getResource("full_counting_sort_input.txt").getPath(), "UTF-8");
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
//        int n = Integer.parseInt(bufferedReader.readLine());
//        List<List<String>> arr = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            String[] line = bufferedReader.readLine().split(" ");
//            List<String> new_line = new ArrayList<>();
//            new_line.add(line[0]);
//            new_line.add(line[1]);
//            arr.add(new_line);
//        }
//        countSort3(arr);
//        bufferedReader.close();
//    }

    static void countSort3(List<List<String>> arr) {
        int size = arr.size();
        StringBuffer[] st = new StringBuffer[100];

        for (int i = 0; i < 100; i++) {
            st[i] = new StringBuffer();
        }

        for (int i = 0; i < size; i++) {
            List<String> line = arr.get(i);
            int k = Integer.parseInt(line.get(0));
            String s;
            if (i < size / 2)
                s = "- ";
            else
                s = line.get(1) + " ";
            st[k] = st[k].append(s);
        }

        for (int i = 0; i < 100; i++) {
            System.out.print(st[i]);
        }
    }

    static void countSort2(List<List<String>> arr) {
        int length = arr.size();
        Map<Integer, String> sortMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            List<String> line = arr.get(i);
            Integer number = Integer.valueOf(line.get(0));
            String ch;
            if (i < length / 2) {
                ch = "-";
            } else {
                ch = line.get(1);
            }
            sortMap.merge(number, ch, (a, b) -> a + " " + b);
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, String> lc : sortMap.entrySet()) {
            sb.append(lc.getValue()).append(" ");
        }
        System.out.println(sb.toString());
    }

//    static void countSort(List<List<String>> arr) {
//        int length = arr.size();
//        Map<Integer, List<String>> listChars = new HashMap<>();
//        for (int i = 0; i < length; i++) {
//            int number = Integer.parseInt(arr.get(i).get(0));
//            String ch;
//            if (i < length / 2) {
//                ch = "-";
//            } else {
//                ch = arr.get(i).get(1);
//            }
//            if (!listChars.containsKey(number)) {
//                List<String> line = new ArrayList<>();
//                line.add(ch);
//                listChars.put(number, line);
//            } else {
//                listChars.get(number).add(ch);
//            }
//        }
//        for (Map.Entry<Integer, List<String>> lc : listChars.entrySet()) {
//            for (String c : lc.getValue()) {
//                System.out.print(c + " ");
//            }
//        }
//    }
}
