/**
* @Company JBINFO   
* @Title: CalPriceProxy.java 
* @Package com.yw.design.behavior.strategy.improve 
* @author Yan Wei   
* @date 2018年3月26日 上午11:31:47 
* @version V1.0   
*/ 
package com.yw.design.behavior.strategy.improve;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.SortedMap;

import com.yw.design.behavior.strategy.CalPrice;

/** 
* @ClassName: CalPriceProxy 
* @Description: 动态代理类
* @author Yan Wei  
*/
public class CalPriceProxy implements InvocationHandler{
	//这不是目标对象，只是一个参数列表
	private  SortedMap<Integer, Class<? extends CalPrice>> calPriceMaps;
	//初始化代理类就传入目标对象
	private CalPriceProxy(SortedMap<Integer, Class<? extends CalPrice>> calPriceMaps) {
		super();
		this.calPriceMaps = calPriceMaps;
	}

	/**
	* <p>Description: </p> 
	* @author Yan Wei   
	* @date 2018年3月26日 上午11:32:52 
	* @param proxy
	* @param method
	* @param args
	* @return
	* @throws Throwable 
	* @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]) 
	*/ 
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Double result=0d;
		if(method.getName().equals("calPrice")) {
			for (Class<? extends CalPrice> cla : calPriceMaps.values()) {
				if(result==0) {
					result = (Double)method.invoke(cla.newInstance(),args);
				}else {
					result = (Double)method.invoke(cla.newInstance(),result);
				}
			}
			return result;
		}
		return null;
	}
	
	public static CalPrice getProxy(SortedMap<Integer, Class<? extends CalPrice>> clazzMap) {
		//动态代理，重要的是第二个参数，是目标类实现的接口。第三个参数是invocationHandler的实例
		return (CalPrice)Proxy.newProxyInstance(CalPriceProxy.class.getClassLoader(), 
				new Class<?>[]{CalPrice.class}, new CalPriceProxy(clazzMap));
	}
}
