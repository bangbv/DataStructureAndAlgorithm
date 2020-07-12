package com.algorithm.string;

public class Permutation {

    public static void main(String args[]) {
        permutation("Bang");
    }

    public static void permutation(String input) {
        permutation("", input);
    }

    private static void permutation(String perm, String word) {
        if (word.isEmpty()) {
            System.out.println(perm + word);
        } else {
            for (int i = 0; i < word.length(); i++) {
                String new_perm = perm + word.charAt(i);
                String new_word = word.substring(0, i) + word.substring(i + 1, word.length());
                permutation(new_perm, new_word);
            }
        }

    }
}