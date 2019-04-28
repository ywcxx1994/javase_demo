/**
* @Company JBINFO   
* @Title: Test.java 
* @Package com.yw.design.pattern.single 
* @author Yan Wei   
* @date 2018年1月8日 下午3:01:38 
* @version V1.0   
*/ 
package com.yw.design.create.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: Test
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yan Wei
 */
public class Test {
	public static void main(String[] args) throws Exception {
		int count = 100;
		long start = System.currentTimeMillis();
		//定义一个线程计数器，初始化个数等于线程个数
		final CountDownLatch cdl = new CountDownLatch(count);
		for (int i = 0; i < count; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 10; j++) {
						System.out.println(Singleton.getInstance());
					}
					//每个线程执行完毕，线程数减一
					cdl.countDown();
				}
			}).start();
		}
		//主线程等待。
		cdl.await();
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	private static void reflectTest() throws Exception {
		System.out.println(Singleton.getInstance());
		Class clazz = Class.forName("com.yw.design.pattern.single.Singleton");
		Constructor c = clazz.getDeclaredConstructor(null);
		c.setAccessible(true);
		Singleton singleton = (Singleton) c.newInstance();
		System.out.println(singleton);
	}
}
