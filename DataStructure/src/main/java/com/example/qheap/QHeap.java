package com.example.qheap;

import java.util.Scanner;

import com.example.MyHeap;

public class QHeap {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = Integer.getInteger(sc.nextLine());
		MyHeap mh = new MyHeap(N+1);
		for(int i =0;i< N;i++) {
			String nLine = sc.nextLine();
			String[] nLineA = nLine.split(" ");
			switch (Integer.valueOf(nLineA[0])) {
			case 1:
				mh.insert(Integer.valueOf(nLineA[1]));
				break;

			default:
				break;
			}		
			System.out.println(nLine);
		}
		sc.close();
	}

}
