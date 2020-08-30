package com.algorithm.interview.world_quant;

import java.util.ArrayList;
import java.util.List;

public class Question2 {
    public static void main(String[] args) throws Exception {
        System.out.println("Question2");
        List<Integer> price = new ArrayList<>();
        price.add(1);
        price.add(3);
        price.add(1);
        price.add(2);
        int[] input = {1, 3, 1, 2};
        System.out.println(maxProfit(price));
    }

    public static int maxProfit3(int[] prices) {
        if (prices.length <= 1) return 0;
        int minPrice = prices[0];
        int maxSoFar = Integer.MIN_VALUE;
        int profitSoFar = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            profitSoFar = prices[i] - minPrice;
            minPrice = Math.min(minPrice, prices[i]);
            maxSoFar = Math.max(profitSoFar, maxSoFar);

        }
        return Math.max(maxSoFar, 0);
    }

    public static int maxProfit(List<Integer> prices) {
        if (prices == null || prices.size() < 2) {
            return 0;
        }
        int[] left = new int[prices.size()];
        int[] right = new int[prices.size()];
        left[0] = 0;
        int min = prices.get(0);
        for (int i = 1; i < prices.size(); i++) {
            min = Math.min(min, prices.get(i));
            left[i] = Math.max(left[i - 1], prices.get(i) - min);
        }
        right[prices.size() - 1] = 0;
        int max = prices.get(prices.size() - 1);
        for (int i = prices.size() - 2; i >= 0; i--) {
            max = Math.max(max, prices.get(i));
            right[i] = Math.max(right[i + 1], max - prices.get(i));
        }
        int profit = 0;
        for (int i = 0; i < prices.size(); i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }
        return profit;
    }

    public static long maximumProfit2(List<Integer> price) {
        long max_profit = 0;
        long buy_price = 0;
        long sell_price = 0;
        boolean change_buy_index = true;
        for (int i = 0; i < price.size() - 1; i++) {
            sell_price = price.get(i + 1);
            if (change_buy_index) {
                buy_price = price.get(i);
            }
            if (sell_price < buy_price) {
                change_buy_index = true;
            } else {
                long profit = sell_price - buy_price;
                max_profit = max_profit + profit;
                change_buy_index = false;
            }
        }
        return max_profit;
    }

    public static long maximumProfit(List<Integer> price) {
        int[] new_price = new int[price.size()];
        int i = 0;
        for (int p : price) {
            new_price[i++] = p;
        }
        printArray(new_price);
        return maxProfit(new_price, 0, price.size() - 1);
    }


    static int maxProfit(int[] price, int start, int end) {
        // If the stocks can't be bought
        if (end <= start)
            return 0;
        // Initialise the profit
        int profit = 0;
        // The day at which the stock
        // must be bought
        for (int i = start; i < end; i++) {
            // The day at which the
            // stock must be sold
            for (int j = i + 1; j <= end; j++) {
                // If byuing the stock at ith day and
                // selling it at jth day is profitable
                if (price[j] > price[i]) {
                    // Update the current profit
                    int curr_profit = price[j] - price[i]
                            + maxProfit(price, start, i - 1)
                            + maxProfit(price, j + 1, end);
                    // Update the maximum profit so far
                    profit = Math.max(profit, curr_profit);
                }
            }
        }
        return profit;
    }

    static void printArray(int[] arr) {
        for (int s : arr) System.out.print(s + " ");
        System.out.println();
    }
}
