package com.yw.thread.communication.improve;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {
	private String name;
	private int count=1;
	private boolean flag;
	//用同一把锁，不同的监视器。pc唤醒消费者的线程
	Lock lock = new ReentrantLock();
	Condition pc = lock.newCondition();
	Condition cc = lock.newCondition();
	/*public synchronized void set(String name) {	
		while(flag) 
			try {wait();} catch (InterruptedException e) {e.printStackTrace();}
		this.name = name+count;
		count++;
		System.out.println(Thread.currentThread().getName()+"生产者"+"........."+this.name);
		flag = true;
		notifyAll();
	}*/
	public  void set(String name) {
	
		lock.lock();
		try {
			while(flag) 
				try {lock.wait();} catch (InterruptedException e) {e.printStackTrace();}
			this.name = name+count;
			count++;
			System.out.println(Thread.currentThread().getName()+"生产者"+"........."+this.name);
			flag = true;
			cc.signal();
		} finally {
			lock.unlock();
		}
		
	}
	
	/*public synchronized void out(){
		while(!flag) 
			try {wait();} catch (InterruptedException e) {e.printStackTrace();}
		System.out.println(Thread.currentThread().getName()+"消费者"+"________________"+this.name);
		flag = false;
		notifyAll();
			
	}*/
	public  void out(){
		lock.lock();
		try {
			while(!flag) 
				try {lock.wait();} catch (InterruptedException e) {e.printStackTrace();}
			System.out.println(Thread.currentThread().getName()+"消费者"+"________________"+this.name);
			flag = false;
			pc.signal();
		} finally {
			lock.unlock();
		}
		
			
	}
}
