package com.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MarkAndToys {
    public static void main(String[] args) {
        //int[] input = {1,2,3};
        int[] input = {2, 12, 5, 3};
        int k = 50;
        System.out.println(maximumToys(input, k));
    }

    static int maximumToys(int[] prices, int k) {
        int maxToys = 0;
        long total = 0;
        List<Integer> ml = new ArrayList<>();
        for (int p : prices) {
            ml.add(p);
        }
        Collections.sort(ml);
        for (int t : ml) {
            total = total + t;
            if (total <= k) {
                maxToys++;
            }
        }
        return maxToys;
    }
}
