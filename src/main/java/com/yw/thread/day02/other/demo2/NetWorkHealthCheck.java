/**
* @Company JBINFO   
* @Title: DBHealthCheck.java 
* @Package com.yw.thread.day02.other.demo2 
* @author Yan Wei   
* @date 2018年6月6日 上午9:52:02 
* @version V1.0   
*/ 
package com.yw.thread.day02.other.demo2;

import java.util.concurrent.CountDownLatch;

/** 
* @ClassName: DBHealthCheck 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
public class NetWorkHealthCheck extends BaseHealthCheck{
	
	
	public NetWorkHealthCheck(String _serviceName, CountDownLatch _latch) {
		super(_serviceName, _latch);
	}

	/**
	* <p>Description: </p> 
	* @author Yan Wei   
	* @date 2018年6月6日 上午9:52:15  
	* @see com.yw.thread.day02.other.demo2.BaseHealthCheck#veriftyService() 
	*/ 
	@Override
	public void veriftyService() {
		System.out.println("Checking " + this.get_serviceName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.get_serviceName() + " is UP");
	}

}
