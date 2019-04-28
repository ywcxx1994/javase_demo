package com.yw.extend;

public abstract class FU {
	public FU() {
		this.show();
	}
	public void show() {
		System.out.println("fu show");
	}
	protected abstract void  fuck(int fuck) throws NullPointerException ;
}
