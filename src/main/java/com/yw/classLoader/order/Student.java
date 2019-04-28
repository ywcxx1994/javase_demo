/**
* @Company JBINFO   
* @Title: Student.java 
* @Package com.yw.classLoader.order 
* @author Yan Wei   
* @date 2018年1月5日 下午4:13:25 
* @version V1.0   
*/ 
package com.yw.classLoader.order;

/** 
* @ClassName: Student 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
public class Student extends Person {
	private int age;
	static String water;
	static {
		System.out.println("student static init");
	}
	public Student() {
		System.out.println("controstur init");
	}
	
}
