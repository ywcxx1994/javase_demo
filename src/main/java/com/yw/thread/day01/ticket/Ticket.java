/**
* @Company JBINFO   
* @Title: Ticket.java 
* @Package com.yw.thread.day01.ticket 
* @author Yan Wei   
* @date 2018年4月9日 下午3:37:53 
* @version V1.0   
*/ 
package com.yw.thread.day01.ticket;

/** 
* @ClassName: Ticket 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
public class Ticket implements Runnable{
	private int count=5000;//100张票
	Object obj = new Object();//锁对象，必须保证是同一个
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public void run() {
			while(true) {
				synchronized (this) {
					if(count>0) {
						System.out.println(Thread.currentThread().getName()+":"+count--);
					}
					else{
						break;
					}
			}
		}
	}
}
