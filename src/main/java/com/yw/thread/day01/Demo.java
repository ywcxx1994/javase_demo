/**
* @Company JBINFO   
* @Title: Demo.java 
* @Package com.yw.thread.day01 
* @author Yan Wei   
* @date 2018年4月9日 下午2:24:52 
* @version V1.0   
*/ 
package com.yw.thread.day01;

/** 
* @ClassName: Demo 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
public class Demo extends Thread{
	private String name;
	
	public Demo(String name) {
		super();
		this.name = name;
	}

	/**
	 * 
	* <p>线程需要执行的代码 </p> 
	* @author Yan Wei   
	* @date 2018年4月9日 下午2:26:31  
	* @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		for (int i = 0; i <20; i++) {
			System.out.println(Thread.currentThread().getName()+name+":"+i);
		}
	}
	
}
