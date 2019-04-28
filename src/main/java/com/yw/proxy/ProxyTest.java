package com.yw.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {
	public static void main(String[] args) {
		Coder coder = new JavaCoder();
		InvocationHandler agency =new Agency(coder);
		Coder c = (Coder)Proxy.newProxyInstance(agency.getClass().getClassLoader(), 
				coder.getClass().getInterfaces(), agency);
		c.code();
	}
}
