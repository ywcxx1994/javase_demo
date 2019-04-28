package com.yw.thread.other;
/**
 * 
 * @author 18765
 *两个线程共同操作一个集合
 */

import java.util.ArrayList;
import java.util.List;

public class CollectionDemo {
	private static List<Integer> list = new ArrayList<>();
	//开启一个线程任务
	static class Demo implements Runnable{

		@Override
		public void run() {
			for(int i=0;i<100;i++) {
				list.add(i);
			}
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Demo task = new Demo();
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		t1.start();
		t2.start();
		//假设主线程执行到这里，那么停下来等待t1执行完毕才会继续执行
		t1.join();
		t2.join();
		System.out.println(list.size());
	}
}
