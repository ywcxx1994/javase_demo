/**
* @Company JBINFO   
* @Title: EatInterceptor.java 
* @Package com.yw.design.pattern.proxy.Improve 
* @author Yan Wei   
* @date 2017年12月23日 下午5:04:52 
* @version V1.0   
*/ 
package com.yw.design.structure.proxy.Improve;

/** 
* @ClassName: EatInterceptor 
* @Description: 定义一个切面接口，所有切面实现他的interceptor方法
* @author Yan Wei  
*/
public interface EatInterceptor {
	//通知
	void interceptor();
}
