package com.yw.design.behavior.strategy.calPriceFactory;

import com.yw.design.behavior.strategy.CalPrice;
import com.yw.design.behavior.strategy.impl.Common;
import com.yw.design.behavior.strategy.impl.SuperVip;
import com.yw.design.behavior.strategy.impl.Vip;

/**
 * 简单工厂模式
 * @author yanwin
 *
 */
public class CalPriceFactory {
	public static CalPrice getCalPrice(Double totalAmount) {
		CalPrice calPrice =new Common();
		if(totalAmount>1000 && totalAmount<2000) {
			calPrice = new Vip();
		}
		if(totalAmount>2000 && totalAmount<3000) {
			calPrice = new SuperVip();
		}
		return calPrice;
	}
}
