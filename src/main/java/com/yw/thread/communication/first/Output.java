package com.yw.thread.communication.first;
/**
 * 
* @ClassName: Output 
* @Description:输出线程的线程任务
* @author Yan Wei
 */
public class Output implements Runnable{
	
	Resource r;
	
	public Output(Resource r) {
		super();
		this.r = r;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (r) {
				if (r.flag) {
					System.out.println(r.name + "____________" + r.sex);
					r.flag = false;
					r.notify();
				} 
				try {
					r.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}

}
