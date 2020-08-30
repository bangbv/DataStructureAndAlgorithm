package com.algorithm.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class SmallestSubsegment {

    static int smallestSubsegment(List<Integer> arr) {
        int n = arr.size();
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        int max = 0;
        int min = -1;
        for (int i = 0; i < n; i++) {
            int x = arr.get(i);
            if (count.get(x) == null) {
                left.put(x, i);
                count.put(x, 1);
            } else
                count.put(x, count.get(x) + 1);
            if (count.get(x) > max) {
                max = count.get(x);
                min = i - left.get(x) + 1;
            } else if ((count.get(x) == max) &&
                    (i - left.get(x) + 1 < min)) {
                min = i - left.get(x) + 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        //int[] input = {1, 2, 1, 3, 2};
        List<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(1);
        A.add(3);
        A.add(2);
        System.out.println(smallestSubsegment(A));
    }
}

