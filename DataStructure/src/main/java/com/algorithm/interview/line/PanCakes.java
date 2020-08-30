package com.algorithm.interview.line;

public class PanCakes {
    public static void main(String[] args) {
        int total = 0;
        for(int i =1;i<= 1000;i++){
            total = total +i;
        }
        System.out.println(total);
    }

    public static void doTowers(int topN, int from,
                                int inter, int to) {
        if (topN == 1) {
            System.out.println("Disk 1 from " + from + " to " + to);
        } else {
            doTowers(topN - 1, from, to, inter);
            System.out.println("Disk " + topN + " from " + from + " to " + to);
            doTowers(topN - 1, inter, from, to);
        }
    }
}
