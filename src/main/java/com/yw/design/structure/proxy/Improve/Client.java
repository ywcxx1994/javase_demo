/**
* @Company JBINFO   
* @Title: Client.java 
* @Package com.yw.design.pattern.proxy 
* @author Yan Wei   
* @date 2017年12月23日 上午10:47:36 
* @version V1.0   
*/ 
package com.yw.design.structure.proxy.Improve;


import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;


/** 
* @ClassName: Client 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
public class Client {
	
	public void eat() {
		//目标类
		Person person = new Woman();
		//辅助类
		Assistant assistant = new Assistant();
		//准备水
		BeforAssistant basis = new BeforAssistant();
		List<EatInterceptor> interceptors = new ArrayList<>();
		interceptors.add(basis);
		interceptors.add(assistant);
		EatIncovationHandle eat = new EatIncovationHandle(person, interceptors);
		Person proxy = (Person)Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), eat);
		proxy.eat();
	}
	
}
