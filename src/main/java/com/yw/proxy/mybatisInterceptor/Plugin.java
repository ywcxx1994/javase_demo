/**
* @Company JBINFO   
* @Title: Plugin.java 
* @Package com.yw.proxy.mybatisInterceptor 
* @author Yan Wei   
* @date 2018年1月17日 下午12:46:30 
* @version V1.0   
*/ 
package com.yw.proxy.mybatisInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** 
* @ClassName: Plugin 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
public class Plugin implements InvocationHandler {
	
	private Object target;
	
	private Interceptor interceptor;
	
	public Plugin(Object target,Interceptor interceptor) {
		this.interceptor = interceptor;
		this.target = target;
	}
	/**
	 * 
	* @Description: 生成目标类
	* @author Yan Wei   
	* @date 2018年1月17日 下午12:51:59 
	* @param target
	* @param interceptor
	* @return
	 */
	public static Object warp(Object target,Interceptor interceptor) {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), new Plugin(target, interceptor));
	}
	/**
	* <p>Description: </p> 
	* @author Yan Wei   
	* @date 2018年1月17日 下午12:46:30 
	* @param proxy
	* @param method
	* @param args
	* @return
	* @throws Throwable 
	*/
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		 MethodName  methodName = target.getClass().getAnnotation(MethodName.class);
		 if(methodName==null) {
			 throw new RuntimeException("没有注解");
		 }
		String mname=methodName.value()[0];
		if(method.getName().equals(mname)) {
			//拦截器自定义的业务逻辑
			return interceptor.interceptor(new Invocation(target, method, args));
		}
		return method.invoke(target, args);
	}

}
