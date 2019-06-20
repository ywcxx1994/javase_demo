/**
 * @Company JBINFO
 * @Title: SuperVip.java
 * @Package com.yw.design.behavior.strategy.improve.stra
 * @author Yan Wei
 * @date 2018年3月26日 上午11:56:05
 * @version V1.0
 */
package com.yw.design.behavior.strategy.improve.stra;

import com.yw.design.behavior.strategy.CalPrice;
import com.yw.design.behavior.strategy.improve.anno.TotalValidRegion;
import com.yw.design.behavior.strategy.improve.anno.ValidRegion;

/**
 * @ClassName: SuperVip
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yan Wei
 */
@TotalValidRegion(@ValidRegion(min = 2000, max = 3000, order = 99))
public class SuperVip implements CalPrice {

    public Double calPrice(Double originalPrice) {
        return originalPrice * 0.7;
    }

}

