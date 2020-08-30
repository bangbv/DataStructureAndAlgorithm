package com.algorithm.DP;

public class LongestCommonSubsequence {

    // Compute length of LCS for all subproblems.
    public static String lcs(String x, String y) {
        int m = x.length(), n = y.length();
        int[][] opt = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (x.charAt(i) == y.charAt(j)) {
                    opt[i][j] = opt[i + 1][j + 1] + 1;
                } else {
                    opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
                }
            }
        }
        // Recover LCS itself.
        StringBuilder lcs = new StringBuilder();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (x.charAt(i) == y.charAt(j)) {
                lcs.append(x.charAt(i));
                i++;
                j++;
            } else if (opt[i + 1][j] >= opt[i][j + 1]) i++;
            else j++;
        }
        return lcs.toString();
    }

    // recursive
    public static int lcs2(String x, String y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (x.charAt(m - 1) == y.charAt(n - 1))
            return 1 + lcs2(x, y, m - 1, n - 1);
        else
            return Math.max(lcs2(x, y, m, n - 1), lcs2(x, y, m - 1, n));
    }

    public static void main(String[] args) {
        String a = "GGCACCACG";
        String b = "ACGGCGGATACG";
        //String lcs = lcs(a, b);
        System.out.println(lcs(a,b));
        //System.out.println(lcs2(a, b, a.length(), b.length()));
    }
}
