/**
* @Company JBINFO   
* @Title: Woman.java 
* @Package com.yw.design.pattern.proxy 
* @author Yan Wei   
* @date 2017年12月23日 上午10:37:57 
* @version V1.0   
*/ 
package com.yw.design.structure.proxy.Improve;

/** 
* @ClassName: Woman 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
public class Woman implements Person {

	/**
	* <p>Description: </p> 
	* @author Yan Wei   
	* @date 2017年12月23日 上午10:37:57  
	* @see com.yw.design.pattern.proxy.Person#eat() 
	*/
	@Override
	public void eat() {
		System.out.println("女人吃饭！！");
	}

	/**
	* <p>Description: </p> 
	* @author Yan Wei   
	* @date 2017年12月23日 上午11:02:30  
	* @see com.yw.design.pattern.proxy.Person#run() 
	*/ 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("跑步");
	}

}
