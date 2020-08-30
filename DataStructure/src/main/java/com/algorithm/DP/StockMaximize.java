package com.algorithm.DP;

import java.util.ArrayList;
import java.util.List;

public class StockMaximize {
    public static void main(String[] args) {
        List<Integer> prices = new ArrayList<>();
        prices.add(1);
        prices.add(3);
        prices.add(1);
        prices.add(2);
        System.out.println(stockmax(prices));
    }

    public static long stockmax(List<Integer> prices) {
        long maxProfit = 0;
        int size = prices.size();
        List<Integer> buys;
        int sell = 0;
        boolean add_sell = true;
        for (int i = size - 1; i >= 0; i--) {
            int pre_i = i - 1;
            buys = new ArrayList<>();
            while (pre_i >= 0 && prices.get(pre_i) < prices.get(i)) {
                if (add_sell) {
                    sell = prices.get(i);
                    add_sell = false;
                }
                buys.add(prices.get(pre_i));
                pre_i--;
            }
            i = pre_i + 1;
            for (int b : buys) {
                maxProfit = maxProfit + (sell - b);
            }
            sell = 0;
            add_sell = true;
        }
        return maxProfit;
    }
}
