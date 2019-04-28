/**
* @Company JBINFO   
* @Title: Invocation.java 
* @Package com.yw.proxy.mybatisInterceptor 
* @author Yan Wei   
* @date 2018年1月17日 下午1:13:22 
* @version V1.0   
*/ 
package com.yw.proxy.mybatisInterceptor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/** 
* @ClassName: Invocation 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
public class Invocation {
	
	private Object target;
	private Method method;
	private Object[] args;
	
	public Invocation(Object target, Method method, Object[] args) {  
        this.target = target;  
        this.method = method;  
        this.args = args;  
    }  
	//将自己成员变量的操作尽量放到自己内部，不需要Interceptor获得自己的成员变量再去操作它们，  
    //除非这样的操作需要Interceptor的其他支持。然而这儿不需要。  
	public Object process() throws Exception {
		return method.invoke(target, args);
	}
	public Object getTarget() {
		return target;
	}
	public void setTarget(Object target) {
		this.target = target;
	}
	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
	public Object[] getArgs() {
		return args;
	}
	public void setArgs(Object[] args) {
		this.args = args;
	};
	
}
