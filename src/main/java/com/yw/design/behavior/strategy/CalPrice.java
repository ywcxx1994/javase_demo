package com.yw.design.behavior.strategy;
/**
 * 策略模式，提供一个计算价格的接口
 * 相当于工厂中的产品
 * @author yanwin
 *
 */
public interface CalPrice {
	/**
	 * 
	* @Description:策略就是生成价格
	* @author Yan Wei   
	* @date 2018年1月17日 下午7:39:06 
	* @param originPrice
	* @return
	 */
	Double calPrice(Double originPrice);
}
