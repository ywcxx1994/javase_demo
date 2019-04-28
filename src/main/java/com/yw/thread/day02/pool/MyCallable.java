/**
* @Company JBINFO   
* @Title: MyCallable.java 
* @Package com.yw.thread.day02.pool 
* @author Yan Wei   
* @date 2018年4月11日 下午5:22:28 
* @version V1.0   
*/ 
package com.yw.thread.day02.pool;

import java.util.Date;
import java.util.concurrent.Callable;

/** 
* @ClassName: MyCallable 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
public class MyCallable implements Callable<Object>{
	private String taskNum;  
	  
	MyCallable(String taskNum) {  
	   this.taskNum = taskNum;  
	}  
	/**
	* <p>Description: </p> 
	* @author Yan Wei   
	* @date 2018年4月11日 下午5:22:51 
	* @return
	* @throws Exception 
	* @see java.util.concurrent.Callable#call() 
	*/ 
	@Override
	public Object call() throws Exception {
	   System.out.println(">>>" + taskNum + "任务启动");  
	   Date dateTmp1 = new Date();  
	   Thread.sleep(1000);  
	   Date dateTmp2 = new Date();  
	   long time = dateTmp2.getTime() - dateTmp1.getTime();  
	   System.out.println(">>>" + taskNum + "任务终止");  
	   return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";  
	}

}
