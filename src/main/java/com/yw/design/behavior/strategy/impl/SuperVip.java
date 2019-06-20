package com.yw.design.behavior.strategy.impl;

import com.yw.design.behavior.strategy.CalPrice;
import com.yw.design.behavior.strategy.anno.TotalValidRegion;

@TotalValidRegion(min = 2000, max = 3000)
public class SuperVip implements CalPrice {
    @Override
    public Double calPrice(Double originPrice) {
        return originPrice * 0.7;
    }

}
