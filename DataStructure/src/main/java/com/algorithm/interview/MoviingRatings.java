package com.algorithm.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MoviingRatings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {9,-1,-3,4,5};
		int result = maximizeRatings(input);
		System.out.println(result);
	}

    static int maximizeRatings(int[] ratings) {
    		int result = 0;
    		int a;
    		int b;
    		int c;
    		List<Integer> abc = new ArrayList<Integer>();
    		for(int i = 0;i<ratings.length-2;i++) {
    			a  = ratings[i];
    			b  = ratings[i+1];
    			c  = ratings[i+2];
    			abc.add(a);
    			abc.add(b);
    			abc.add(c);
    			Collections.sort(abc);
    			//result = result +
    		}
    		return result;
    }
}
