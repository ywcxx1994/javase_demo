/**
* @Company JBINFO   
* @Title: OnceValidRegion.java 
* @Package com.yw.design.behavior.strategy.improve.anno 
* @author Yan Wei   
* @date 2018年3月26日 上午11:08:48 
* @version V1.0   
*/ 
package com.yw.design.behavior.strategy.improve.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
* @ClassName: OnceValidRegion 
* @Description:针对单次消费的活动的注解
* @author Yan Wei  
*/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface OnceValidRegion {
	ValidRegion value() default @ValidRegion;
}
