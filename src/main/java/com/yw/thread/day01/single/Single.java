/**
* @Company JBINFO   
* @Title: Single.java 
* @Package com.yw.thread.day01.single 
* @author Yan Wei   
* @date 2018年4月10日 下午9:21:28 
* @version V1.0   
*/ 
package com.yw.thread.day01.single;

/** 
* @ClassName: Single 
* @Description:解决饿汉式的线程安全问题 
* @author Yan Wei  
*/
public class Single {
	 private static Single demo;
	 /**
	  * 
	 * @Description: 第一个demo为null是为了提高效率，不用判断锁对象，同步代码快是解决线程安全问题
	 * @author Yan Wei   
	 * @date 2018年4月10日 下午9:31:17 
	 * @return
	  */
	 public static Single getInstance() {
		 //别的线程不用判断锁了，不为null就不继续往下走了
		 if(demo !=null) {
			 //加锁，同一时间只能有一个线程访问这段代码
			 synchronized (Single.class) {
				 //第二个线程拿到锁一判断不为null了，就不会在创建对象了
				 if(demo ==null) {
					 demo = new Single();
				 }
			 }
		 }
		return demo;
	 }
}
