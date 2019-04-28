/**
* @Company JBINFO   
* @Title: MethodName.java 
* @Package com.yw.proxy.mybatisInterceptor 
* @author Yan Wei   
* @date 2018年1月17日 下午12:58:22 
* @version V1.0   
*/ 
package com.yw.proxy.mybatisInterceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
* @ClassName: MethodName 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodName {
	String[] value() default "";
}
