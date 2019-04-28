package com.yw.classLoader;


public class StaticTest {
	static StaticTest st = new StaticTest();
	int a = 110;

	static {
		System.out.println("1");
	}
	static int b = 112;

	{
		System.out.println("2");
	}

	StaticTest() {
		System.out.println("3");
		System.out.println("a=" + a + ",b=" + b);
	}

	public static void staticFunction() {
		System.out.println("4");
	}

	public static void main(String[] args) {
		staticFunction();
	}

}