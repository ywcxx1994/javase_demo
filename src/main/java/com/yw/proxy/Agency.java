package com.yw.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Agency implements InvocationHandler{
	private Object target;
	
	public Agency(Object target) {
		this.target=target;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("begin=============");
		System.out.println(method);
		Object obj = method.invoke(target, args);
		System.out.println("ending==============");
		return obj;
	}

}
