package com.yw.design.behavior.strategy.impl;

import com.yw.design.behavior.strategy.CalPrice;
import com.yw.design.behavior.strategy.anno.TotalValidRegion;

@TotalValidRegion(max=1000)//设置普通的在0-1000生效，以下类似，不再注释
public class Common implements CalPrice {

	@Override
	public Double calPrice(Double originPrice) {
		return originPrice;
	}

}
