package com.competitive.FossilSpringCode;

import java.util.HashMap;
import java.util.Map;

public class Q_Exam1 {
	public static void main(String[] args) throws Exception {
		String[] oItem = {"rice","sugar","wheat","cheese"};
		float[] oPrice = {16.98f, 56.92f, 20.89f,345.99f};
		String[] items = {"rice","cheese"};
		float[] prices = { 18.99f,400.89f};
		int result = 0;
		result = verifyItems(oItem,oPrice,items,prices);
		System.out.println(result);;
	}
	
    @SuppressWarnings({ "unchecked", "rawtypes" })
	static int verifyItems(String[] origItems, float[] origPrices, String[] items, float[] prices) {
    		int result = 0;
    		Map oMap = new HashMap<String,Float>();
    		int i = 0;
    		for(i=0; i<origItems.length;i++) {
    			oMap.put(origItems[i], origPrices[i]);
    		}
    		
    		for(i=0;i<items.length;i++) {
    			float tp = (float) oMap.get(items[i]);
    			if(tp != prices[i]) {
    				result ++;
    			}
    		}
    		return result;
    }
}
