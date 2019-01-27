package com.oop;

public class C {
	A a;
	void set (A a){
		this.a = a;
	}
	
	public void ab(A a) {
		B b = (B) a;
		b.a();
	}

	public void main(String[] args) {
		System.out.println();
	}
}
