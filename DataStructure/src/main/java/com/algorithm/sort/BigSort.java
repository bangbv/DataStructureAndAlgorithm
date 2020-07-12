package com.algorithm.sort;

import java.util.Collection;
import java.util.Comparator;

public class BigSort {
    public static void main(String args[]) {
        String[] input = {"1",
                "2",
                "100",
                "12303479849857341718340192371",
                "3084193741082937",
                "3084193741082938",
                "111",
                "200"};
        printArray(input);
        String[] output = bigSorting(input);
        printArray(output);
    }

    static String[] bigSorting(String[] unsorted) {
        int l = unsorted.length;
        mergeSort(unsorted, 0, l - 1);
        return unsorted;
    }

    static void merge(String[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        String[] L = new String[n1];
        String[] R = new String[n2];
        System.arraycopy(arr, l, L, 0, n1);
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0;
        int k = l;
        StrComparator comp = new StrComparator();
        while (i < n1 && j < n2) {
            if (comp.compare(R[j], L[i]) > 0) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) {
            arr[k++] = L[i++];
        }
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    static void mergeSort(String[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }



    static int compare(String x, String y) {
        int xl = x.length();
        int yl = y.length();
        if (xl != yl) return xl - yl;
        for (int i = 0; i < xl; i++) {
            char left = x.charAt(i);
            char right = y.charAt(i);
            if (left != right)
                return left - right;
        }
        return 0;
    }
//    static int compare(String a, String b) {
//        int al = a.length();
//        int bl = b.length();
//        if (al > bl) {
//            return 1;
//        }
//        if (al == bl) {
//            for (int i = 0; i < al; i++) {
//                int ai = a.charAt(i);
//                int bi = b.charAt(i);
//                if (ai > bi) {
//                    return 1;
//                } else if (ai < bi) {
//                    return -1;
//                }
//            }
//        }
//        return 0;
//    }

    static void printArray(String[] arr) {
        for (String s : arr) System.out.print(s + " ");
        System.out.println();
    }
}

class StrComparator  implements Comparator<String> {
    public int compare(String x, String y) {
        if (x.length() == y.length()) {
            return x.compareTo(y);
        }

        return x.length() - y.length();
    }
}
