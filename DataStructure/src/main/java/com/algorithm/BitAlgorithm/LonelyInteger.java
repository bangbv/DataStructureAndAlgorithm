package com.algorithm.BitAlgorithm;

import java.util.HashMap;
import java.util.Map;

public class LonelyInteger {

    static int lonelyInteger(int[] a) {
        Map<Integer, Integer> uniqueNumber = new HashMap<>();
		for (int value : a) {
			if (uniqueNumber.get(value) == null) {
				uniqueNumber.put(value, 1);
			} else {
				uniqueNumber.remove(value);
			}
		}
        return (int) uniqueNumber.keySet().toArray()[0];
    }

    static int lonelyInteger2(int[] a) {
        int rs = 0;
		for (int value : a) {
			rs = rs ^ value;
		}
        return rs;
    }

    public static void main(String[] args) {
        int[] a = {0, 0, 1, 2, 1};
        System.out.println(lonelyInteger2(a));
        System.out.println(lonelyInteger(a));
    }
}
