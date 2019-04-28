/**
* @Company JBINFO   
* @Title: EatIncovationHandle.java 
* @Package com.yw.design.pattern.proxy 
* @author Yan Wei   
* @date 2017年12月23日 上午10:39:11 
* @version V1.0   
*/ 
package com.yw.design.structure.proxy.Improve;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/** 
* @ClassName: EatIncovationHandle 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
public class EatIncovationHandle implements InvocationHandler{
	//目标对象
	private Object target;
	//辅助对象
//	private Assistant assistant;
//	private BeforAssistant bassis;
	//一个所有切面的集合类
	List<EatInterceptor> interceptors;
	public EatIncovationHandle(Object target,List<EatInterceptor> interceptors) {
		this.target = target;
		this.interceptors = interceptors;
	}

	/**
	* <p>Description: </p> 
	* @author Yan Wei   
	* @date 2017年12月23日 上午10:39:34 
	* @param proxy
	* @param method
	* @param args
	* @return
	* @throws Throwable 
	*/ 
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//1==1就是切入点
		if(1==1) {
			for (EatInterceptor interceptor : interceptors) {
				if(interceptor.getClass().isAssignableFrom(Assistant.class)) {
					method.invoke(target, args);
				}
				interceptor.interceptor();
			}
			
		}
		return null;
		
	}

}
