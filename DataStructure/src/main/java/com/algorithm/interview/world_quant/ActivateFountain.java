package com.algorithm.interview.world_quant;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
public class ActivateFountain {
    public static void main(String[] args) {
        System.out.println("ActivateFountain");
        List<Integer> input = new ArrayList<>();
        input.add(0);
        input.add(0);
        input.add(2);
        input.add(0);
        System.out.println(activateFountains(input));
        //int[] input = {0, 0, 0, 0};
//        int[] input = {4, 0, 0, 0, 0, 0, 0, 0, 4};
//        int n = 8;
//        System.out.println(minTaps(n, input));
    }

    public static int minTaps(int n, int[] ranges) {
        int[] dp = new int[n + 2];
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] == 0) continue;
            int mn = i - ranges[i];
            int mx = i + ranges[i];
            for (int j = Math.max(mn, 0); j < Math.min(ranges.length, mx); j++) {
                dp[j] = Math.max(dp[j], mx);
            }
        }
        int curr = 0;
        int res = 0;
        while (curr < ranges.length) {
            if (curr == ranges.length - 1) return res;
            if (dp[curr] == 0) return -1;
            curr = dp[curr];
            res++;
        }
        return res;
    }

    public static int activateFountains(List<Integer> locations) {
        int n = locations.size();
        int[] interval = new int[n];
        for (int i = 1; i <= n; i++) {
            int left = Math.max(i - locations.get(i - 1), 1);
            int right = Math.min(i + locations.get(i - 1), n);
            interval[left - 1] = Math.max(interval[left - 1], right);
        }
        int right = interval[0];
        int nextGreaterRight = right;
        int fountainsActivate = 1;
        for (int i = 1; i < n; i++) {
            nextGreaterRight = Math.max(nextGreaterRight, interval[i]);
            if (i == right) {
                fountainsActivate++;
                right = nextGreaterRight;
            }
        }
        return fountainsActivate;
    }
}
