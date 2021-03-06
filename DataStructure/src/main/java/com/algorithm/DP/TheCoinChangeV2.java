package com.algorithm.DP;

import java.util.*;

public class TheCoinChangeV2 {
    private static Map<Long, List<List<Long>>> mem = new HashMap<>();
    public static void main(String[] args) {
        int n = 4;
        List<Long> c = new ArrayList<>();
        c.add(1L);
        c.add(2L);
        c.add(3L);
        Collections.sort(c);
        System.out.println(getWays(n, c));
    }

    public static long getWays(int n, List<Long> c) {
        change_coin_type(c);
        List<Long> result = new ArrayList<>();
        for(int i = 0;i< c.size();i++) {
            Long type_coin = c.get(i);
            int new_n = (int) (n - type_coin);
            if(new_n>0) {
                if(mem.containsKey(new_n)){

                } else {
                    List<Long> change = new ArrayList<>();
                    getWays(new_n, c, change);
                }
            }
        }
        return result.size();
    }

    private static void change_coin_type(List<Long> c){
        List<Long> change = new ArrayList<>();
        for(int i = 0; i< c.size();i++) {
            //getWays(c.get(i), c, change);
        }
    }

    private static List<Long> join(List<Long> a, List<Long> b){
        return null;
    }

    public static void getWays(int n, List<Long> c, List<Long> change) {
        if (n < 0)
            return;
        if (n == 0) {
            Collections.sort(change);
            if (!mem.get(n).contains(change)) {
                mem.get(n).add(change);
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
