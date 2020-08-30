package com.algorithm.array;

public class NewYearChaos {
    public static void main(String[] args) {
        //int[] input = {1, 2, 5, 3, 7, 8, 9, 6, 4};
        int[] input = {5, 1, 2, 3, 7, 8, 6, 4};
        minimumBribes(input);
    }

    static void minimumBribes2(int[] q) {
        int ans = 0;
        for (int i = q.length - 1; i >= 0; i--) {
            if (q[i] - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(0, q[i] - 2); j < i; j++)
                if (q[j] > q[i]) ans++;
        }
        System.out.println(ans);
    }

    static void minimumBribes(int[] q) {
        int n = q.length;
        int swap = 0;
        for (int i = 1; i < n; i++) {
            if (q[i - 1] - i > 2) {
                System.out.println("Too chaotic");
                return;
            }
            int key = q[i];
            int j = i - 1;
            while (j >= 0 && q[j] > key) {
                swap++;
                q[j + 1] = q[j];
                j = j - 1;
            }
            q[j + 1] = key;
        }
        System.out.println(swap);
    }
}
