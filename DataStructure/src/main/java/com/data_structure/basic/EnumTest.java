package com.data_structure.basic;

public class EnumTest {

	enum WORD {
		A (1), B (2);
		
		private int order;
		private WORD(int order) {
			this.order = order;
		}
		
		private int getCode() {
			return order;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(WORD.A.getCode());
	}

}
