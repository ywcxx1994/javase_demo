package com.yw.thread.sync;

public class Task implements Runnable{
	int a = 0;
	public void run() {
		for(int i =0;i<10000;i++) {
			a++;
			System.out.println(Thread.currentThread().getName()+"--->"+"执行了a++");
		}
	}
	
}
