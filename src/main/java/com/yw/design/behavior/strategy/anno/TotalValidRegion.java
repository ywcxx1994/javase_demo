package com.yw.design.behavior.strategy.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 这是我们的有效区间注解，可以给策略添加有效区间的设置
 * @author Administrator
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TotalValidRegion {
	
	int min() default Integer.MIN_VALUE;
	
	int max() default Integer.MAX_VALUE;
}
