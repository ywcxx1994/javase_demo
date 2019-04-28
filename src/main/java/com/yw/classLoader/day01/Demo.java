/**
* @Company JBINFO   
* @Title: Demo.java 
* @Package com.yw.classLoader.day01 
* @author Yan Wei   
* @date 2018年4月6日 上午12:03:38 
* @version V1.0   
*/ 
package com.yw.classLoader.day01;

/** 
* @ClassName: Demo 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
public class Demo {
	static String str="demo";
	public static final String finalTest="final";
	static {
		System.out.println("demo"+str);
	}
}
