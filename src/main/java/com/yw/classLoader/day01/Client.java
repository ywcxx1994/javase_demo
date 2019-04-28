/**
* @Company JBINFO   
* @Title: Client.java 
* @Package com.yw.classLoader.day01 
* @author Yan Wei   
* @date 2018年4月6日 上午12:04:23 
* @version V1.0   
*/ 
package com.yw.classLoader.day01;

/** 
* @ClassName: Client 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
public class Client {
	public static void main(String[] args) throws Exception {
		//这样会主动加载一个类，全加载
//		Class.forName("com.yw.classLoader.day01.Demo");
		//这个方法只会把类装载进内存，不会初始化这个类(静态变量和静态代码块不会加载)
//		Client.class.getClassLoader().loadClass("com.yw.classLoader.day01.Demo");
		//调用类的常量不会加载这个类(包含静态常量)
		System.out.println(Demo.finalTest);
	}
}
