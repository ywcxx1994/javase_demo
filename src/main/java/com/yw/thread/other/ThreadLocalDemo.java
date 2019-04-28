package com.yw.thread.other;
/**
 * 每个线程拥有自己的共享变量的副本。
 * @author 18765
 *
 */
public class ThreadLocalDemo {
	ThreadLocal<String> stringTl = new ThreadLocal<>();
	ThreadLocal<Long> longTl = new ThreadLocal<>();
	
	public void set() {
		stringTl.set(Thread.currentThread().getName());
		longTl.set(Thread.currentThread().getId());
	}
	public String getString() {
		return stringTl.get();
	}
	
	public Long getLong() {
		return longTl.get();
	}
	
	public static void main(String[] args) throws InterruptedException {
		ThreadLocalDemo tld = new ThreadLocalDemo();
		tld.set();
		System.out.println(tld.getString());
		System.out.println(tld.getLong());
		Thread others = new Thread(new Runnable() {
			
			@Override
			public void run() {
				tld.set();
				System.out.println(tld.getString());
				System.out.println(tld.getLong());
			}
		});
		others.start();
		others.join();
		System.out.println(tld.getString());
		System.out.println(tld.getLong());
	}
}
