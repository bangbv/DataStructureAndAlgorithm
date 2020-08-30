package com.algorithm.brute_force;

public class CountPaths {
    //static long ll long long int
    // Function to return the value of nCk
    static long binomialCoeff(int n, int k) {
        long res = 1;
        // Since C(n, k) = C(n, n-k)
        if (k > n - k)
            k = n - k;
        // Calculate value of
        // [n * (n-1) *---* (n-k+1)] /
        // [k * (k-1) *---* 1]
        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }

    // Function to return the number of paths
    static long countPaths(int x1, int y1, int x2, int y2) {
        // Difference between the 'x'
        // coordinates of the given points
        int m = Math.abs(x1 - x2);
        // Difference between the 'y'
        // coordinates of the given points
        int n = Math.abs(y1 - y2);
        return (binomialCoeff(m + n, n));
    }

    // Driver code
    public static void main(String[] args) {
        int x1 = 2, y1 = 3, x2 = 4, y2 = 5;
        System.out.println(countPaths(x1, y1, x2, y2));
    }
}
