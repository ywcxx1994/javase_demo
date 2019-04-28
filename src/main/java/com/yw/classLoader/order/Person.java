/**
* @Company JBINFO   
* @Title: Person.java 
* @Package com.yw.classLoader.order 
* @author Yan Wei   
* @date 2018年1月5日 下午4:10:21 
* @version V1.0   
*/ 
package com.yw.classLoader.order;

/** 
* @ClassName: Person 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
public class Person {
	public static final String ADRESS="TSingDao";
	static String air;
	String name;
	{
		System.out.println("构造代码块");
	}
	static {
		air = "空气";
		System.out.println("Persion static init");
	}
	public Person() {
		System.out.println("Person controstur is init");
	}
	public static void show() {
		System.out.println(air);
	}
}
