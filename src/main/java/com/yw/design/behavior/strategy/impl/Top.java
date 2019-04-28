/**
* @Company JBINFO   
* @Title: Top.java 
* @Package com.yw.design.behavior.strategy.impl 
* @author Yan Wei   
* @date 2018年3月29日 下午8:58:59 
* @version V1.0   
*/ 
package com.yw.design.behavior.strategy.impl;

import com.yw.design.behavior.strategy.CalPrice;
import com.yw.design.behavior.strategy.anno.TotalValidRegion;

/** 
* @ClassName: Top 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
@TotalValidRegion(min=4000)
public class Top implements CalPrice{

	/**
	* <p>Description: </p> 
	* @author Yan Wei   
	* @date 2018年3月29日 下午8:59:17 
	* @param originPrice
	* @return 
	* @see com.yw.design.behavior.strategy.CalPrice#calPrice(java.lang.Double) 
	*/ 
	@Override
	public Double calPrice(Double originPrice) {
		return 0.5*originPrice;
	}

}
