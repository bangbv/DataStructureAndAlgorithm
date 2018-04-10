package com.algorithm.BitAlgorithm;

import java.util.HashMap;
import java.util.Map;

public class LonelyInteger {

    @SuppressWarnings({ "rawtypes", "unchecked" })
	static int lonelyinteger(int[] a) {
        Map uniqueNumber = new HashMap<Integer,Integer>();
        for(int i=0;i<a.length;i++){
        		if(uniqueNumber.get(a[i]) == null) {
        			uniqueNumber.put(a[i],1);
        		}else {
        			uniqueNumber.remove(a[i]);
        		}
        }
        return (int) uniqueNumber.keySet().toArray()[0];
    }
    
	static int lonelyinteger2(int[] a) {
		int rs = 0;
        for(int i=0;i<a.length;i++){
        		rs = rs ^ a[i];
        }
        return rs;
    }
	public static void main(String[] args) {
		int[] a = {0,0,1,2,1};
		System.out.println(lonelyinteger2(a));
	}
}
