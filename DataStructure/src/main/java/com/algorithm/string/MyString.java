package com.algorithm.string;

public class MyString {

	enum Planet {
		MERCURY, VENUS, EARTH
	}
	
	public static void main(String[] args) {
		int[] input = {1,4,9,12,98,-10,10};
		System.out.println(sumRange(input));
//		String a = "foo";
//		String b = "foo";
//		if(a == b) {
//			System.out.println("true");
//		}else {
//			System.out.println("false");
//		}
//		
//		int i = 0;
//		System.out.println("result:"+i++);
//		String[] input = {"f","o","o","bar"};
//		String result = concat(input);
//		System.out.println(result);
	}

	static String concat(String[] strs) {
		String result = new String(); 
		for(int i = 0;i<strs.length;i++) {
			result = String.join("",result,strs[i]);
		}
		return result;
	}
	
	static boolean isFoo(String param) {
		if(param == "foo") {
			return true;
		}
		return false;
	}
	
	static int sumRange(int[] ints) {
		int sum = 0;
		for(int i=0;i<ints.length;i++) {
			if((ints[i] >= 10) && (ints[i] <= 100)) {
				sum = sum + ints[i];
			}
		}
		return sum;
	}
}
