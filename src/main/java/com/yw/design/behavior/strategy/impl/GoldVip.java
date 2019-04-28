/**
* @Company JBINFO   
* @Title: GoldVip.java 
* @Package com.yw.design.pattern.strategy.impl 
* @author Yan Wei   
* @date 2018年1月2日 下午1:45:49 
* @version V1.0   
*/ 
package com.yw.design.behavior.strategy.impl;

import com.yw.design.behavior.strategy.CalPrice;
import com.yw.design.behavior.strategy.anno.TotalValidRegion;

/** 
* @ClassName: GoldVip 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
@TotalValidRegion(min=3000,max=4000)
public class GoldVip implements CalPrice{

	/**
	* <p>Description: </p> 
	* @author Yan Wei   
	* @date 2018年1月2日 下午1:46:10 
	* @param originPrice
	* @return 
	* @see com.yw.design.pattern.strategy.CalPrice#calPrice(java.lang.Double) 
	*/ 
	@Override
	public Double calPrice(Double originPrice) {
		return originPrice*0.65;
	}

}
