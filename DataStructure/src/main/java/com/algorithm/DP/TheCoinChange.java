package com.algorithm.DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheCoinChange {
    private static List<List> result = new ArrayList<>();

    public static void main(String[] args) {
        int n = 4;
        List<Long> c = new ArrayList<>();
        c.add(1L);
        c.add(2L);
        c.add(3L);
        System.out.println(getWays(n, c));
    }

    public static long getWays(int n, List<Long> c) {
        List<Long> change = new ArrayList<>();
        getWays(n, c, change);
        return result.size();
    }

    public static void getWays(int n, List<Long> c, List<Long> change) {
        if (n < 0)
            return;
        if (n == 0) {
            Collections.sort(change);
            if (!result.contains(change)) {
                result.add(change);
            }
        } else {
            int length = c.size();
            for (int i = 0; i < length; i++) {
                Long type_coin = c.get(i);
                int new_n = (int) (n - type_coin);
                if (new_n >= 0) {
                    List<Long> new_change = new ArrayList<>(change);
                    new_change.add(type_coin);
                    getWays(new_n, c, new_change);
                }
            }
        }
    }
}
