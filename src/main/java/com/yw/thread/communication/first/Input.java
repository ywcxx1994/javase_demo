package com.yw.thread.communication.first;
/**
 * 
* @ClassName: Input 
* @Description:输入线程的任务
* @author Yan Wei
 */
public class Input implements Runnable{
	
	Resource r;
	
	public Input(Resource r) {
		this.r = r;
	}

	@Override
	public void run() {
		int x = 0;
		//模拟不停的输入名字
		while(true) {
			synchronized (r) {
				if(r.flag) {
					try {
						r.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(x==0) {
					r.name="伟伟";
					r.sex="男";
				}else {
					r.name="xuxu";
					r.sex="nvnvnvnv";
				}
				r.flag = true;
				r.notify();
			}
			//改变x的值
			x = (x+1)%2;
		}
		
	}
	
}
