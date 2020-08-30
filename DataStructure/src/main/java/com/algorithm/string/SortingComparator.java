package com.algorithm.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
// https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {
    // complete this method
    public int compare(Player a, Player b) {
        if (a.score > b.score) {
            return -1;
        } else if (a.score == b.score) {
            int nc = stringCompare(a.name, b.name);
            if (nc > 0) {
                return 1;
            } else if (nc < 0) {
                return -1;
            }
            return 0;
        } else {
            return 1;
        }
    }

    public int stringCompare(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);
        for (int i = 0; i < lmin; i++) {
            int str1_ch = str1.charAt(i);
            int str2_ch = str2.charAt(i);
            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }
        if (l1 != l2) {
            return l1 - l2;
        } else {
            return 0;
        }
    }
}

public class SortingComparator {
    public static void main(String[] args) {
        int n = 5;
        int[] scores = {100, 100, 50, 75, 150};
        String[] names = {"amy", "david", "heraldo", "aakansha", "aleksa"};
        Player[] player = new Player[n];
        Checker checker = new Checker();
        for (int i = 0; i < n; i++) {
            player[i] = new Player(names[i], scores[i]);
        }

        Arrays.sort(player, checker);
        for (Player value : player) {
            System.out.printf("%s %s\n", value.name, value.score);
        }
    }
}
