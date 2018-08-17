package com.algorithm.greedy;

import java.util.Arrays;


public class CakeWalk {

    static long marcsCakewalk(int[] calorie) {
        Arrays.sort(calorie);
        long rs = 0;
        int j=0;
        for(int i = calorie.length-1;i>=0;i--){
            rs =(long) (rs + (calorie[i]*Math.pow(2,j++)));
        }
        return rs;
    }
	
	public static void main(String[] args) {
		int[] input = {1,3,2};
		System.out.println(marcsCakewalk(input));
	}

	
}
