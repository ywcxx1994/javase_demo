/**
* @Company JBINFO   
* @Title: ValidRegion.java 
* @Package com.yw.design.behavior.strategy.improve 
* @author Yan Wei   
* @date 2018年3月26日 上午11:04:13 
* @version V1.0   
*/ 
package com.yw.design.behavior.strategy.improve.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/** 
* @ClassName: ValidRegion 
* @Description: 元注解，减少代码量
* @author Yan Wei  
*/
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidRegion {
	int min() default Integer.MIN_VALUE;
	
	int max() default Integer.MAX_VALUE;
	
	int order() default 0;
}
