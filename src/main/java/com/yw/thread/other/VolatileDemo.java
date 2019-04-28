package com.yw.thread.other;

public class VolatileDemo {
	public static void main(String[] args) {
		Test test = new Test();
		for(int i=0;i<10;i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for(int j=0;j<1000;j++) {
						test.incr();
					}
				}
			}).start();
		}
		 while(Thread.activeCount()>1)  //保证前面的线程都执行完
	            Thread.yield();
	        System.out.println(test.i);
	}
}
class Test{
	volatile int i=0;
	
	public void incr() {
		synchronized(this) {
			i++;
		}
	}
}
