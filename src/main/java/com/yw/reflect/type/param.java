/**
* @Company JBINFO   
* @Title: param.java 
* @Package com.yw.reflect.type 
* @author Yan Wei   
* @date 2018年8月24日 下午2:29:06 
* @version V1.0   
*/ 
package com.yw.reflect.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/** 
* @ClassName: param 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
public class param<T1,T2> {
	 	class A<T> {}  
	 	
	    class B extends A<MyClass> {}  

	    private Class<T1> entityClass;  
	    
	    public param (){  
	        Type type = getClass().getGenericSuperclass();  
	        System.out.println("getClass() == " + getClass());  
	        System.out.println("type = " + type);  
	        Type trueType = ((ParameterizedType)type).getActualTypeArguments()[0];  
	        System.out.println("trueType1 = " + trueType);  
	        trueType = ((ParameterizedType)type).getActualTypeArguments()[1];  
	        System.out.println("trueType2 = " + trueType);  
	        this.entityClass = (Class<T1>)trueType;  
	        System.out.println("entityClass = " + entityClass);

	        B t = new B();  
	        type = t.getClass().getGenericSuperclass();  
	        if(type instanceof ParameterizedType) {
	        	System.out.println("B is A's super class :" + ((ParameterizedType)type).getActualTypeArguments().length);  
	        }else {
	        	System.out.println("genericParamterType is not init");
	        }
	    }  
}
