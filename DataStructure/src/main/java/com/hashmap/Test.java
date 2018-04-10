package com.hashmap;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
/*			Map map = new HashMap();
			map.put(1,"sam");   
			map.put(1,"Ian");   
			map.put(1,"Scott");   
			map.put(null,"asdf");
			System.out.println(map);  */
/*		MyHashTable ht = new MyHashTable(5);
		ht.insert("a", 1);
		ht.insert("b", 2);
		ht.insert("c", 3);
		ht.insert("d", 4);
		ht.insert("e", 5);
		ht.insert("f", 6);*/
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		System.out.println(A);
		
		StringBuilder st = new StringBuilder();
		st.append(A);
		String rs = st.reverse().toString();
		if(rs.equals(A)) {
			System.out.println("Yes");
		}
	}

}
