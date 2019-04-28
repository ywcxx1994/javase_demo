/**
* @Company JBINFO   
* @Title: ApplicationStartupUtil.java 
* @Package com.yw.thread.day02.other.demo2 
* @author Yan Wei   
* @date 2018年6月6日 上午9:56:36 
* @version V1.0   
*/ 
package com.yw.thread.day02.other.demo2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
* @ClassName: ApplicationStartupUtil 
* @Description: 
* @author Yan Wei  
*/
public class ApplicationStartupUtil {
	private  List<BaseHealthCheck>  bhcs;
	private  CountDownLatch latch;
	private final static ApplicationStartupUtil INSTANCE = new ApplicationStartupUtil();
	public static ApplicationStartupUtil getInstance()
    {
        return INSTANCE;
    }
	public boolean checkExternalServices() throws Exception {
		bhcs = new ArrayList<>();
		latch = new CountDownLatch(2);
		DBHealthCheck dc = new DBHealthCheck("database", latch);
		NetWorkHealthCheck nhc = new NetWorkHealthCheck("network", latch);
		bhcs.add(dc);
		bhcs.add(nhc);
		ExecutorService es = Executors.newFixedThreadPool(bhcs.size());
		bhcs.forEach(item->{
			es.execute(item);
		});
		
		latch.await();
		es.shutdown();
		for (BaseHealthCheck item : bhcs) {
			if(!item.getServiceUp()) {
				return false;
			}
		}
		return true;
	}
}
