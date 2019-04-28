package com.yw.design.behavior.strategy.impl;

import com.yw.design.behavior.strategy.CalPrice;
import com.yw.design.behavior.strategy.anno.TotalValidRegion;

@TotalValidRegion(min=1000,max=2000)
public class Vip implements CalPrice {

	@Override
	public Double calPrice(Double originPrice) {
		return originPrice*0.8;
	}

}
