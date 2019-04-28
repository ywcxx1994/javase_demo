/**
* @Company JBINFO   
* @Title: Client.java 
* @Package com.yw.thread.day02.pool 
* @author Yan Wei   
* @date 2018年4月11日 下午5:25:16 
* @version V1.0   
*/ 
package com.yw.thread.day02.pool;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/** 
* @ClassName: Client 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
public class Client {
	public static void main(String[] args) {
		 System.out.println("----程序开始运行----");  
		 Date date1 = new Date();  
		 int taskSize=5;//
		 //创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
		 ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		// 创建多个有返回值的任务  
		 List<Future<Object>> futures = new ArrayList<>();
		 for (int i = 0; i < taskSize; i++) {
			 //创建任务对象
			MyCallable task = new MyCallable(i+"");
			//执行任务对象，并接收返回值。与executor()方法有区别。executor()方法接收没有返回值的任务
			Future<Object> submit = pool.submit(task);
			futures.add(submit);
		}
		 // 关闭线程池  
		 pool.shutdown();
		 futures.forEach(item->{
			 try {
				System.out.println(item.get().toString());
			}catch (Exception e) {
				e.printStackTrace();
			}
		 });
		 
		 Date date2 = new Date();  
		 System.out.println("----程序结束运行----，程序运行时间【"  
		     + (date2.getTime() - date1.getTime()) + "毫秒】");
	}
}
