/**
* @Company JBINFO   
* @Title: TotalValidRegion.java 
* @Package com.yw.design.behavior.strategy.improve.anno 
* @author Yan Wei   
* @date 2018年3月26日 上午11:06:17 
* @version V1.0   
*/ 
package com.yw.design.behavior.strategy.improve.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
* @ClassName: TotalValidRegion 
* @Description:针对消费满多少生成策略的注解
* @author Yan Wei  
*/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TotalValidRegion {
	ValidRegion value() default @ValidRegion;
}
