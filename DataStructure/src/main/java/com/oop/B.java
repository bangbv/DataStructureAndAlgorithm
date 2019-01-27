package com.oop;

public class B implements A{
	public void b() {
		C c = new C();
		c.set(this);
	}

	@Override
	public void a() {
		// TODO Auto-generated method stub
		
	};
}
