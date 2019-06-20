/**
 * @Company JBINFO
 * @Title: Vip.java
 * @Package com.yw.design.behavior.strategy.improve.stra
 * @author Yan Wei
 * @date 2018年3月26日 上午11:55:41
 * @version V1.0
 */
package com.yw.design.behavior.strategy.improve.stra;

import com.yw.design.behavior.strategy.CalPrice;
import com.yw.design.behavior.strategy.improve.anno.TotalValidRegion;
import com.yw.design.behavior.strategy.improve.anno.ValidRegion;

/**
 * @ClassName: Vip
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yan Wei
 */
@TotalValidRegion(@ValidRegion(min = 1000, max = 2000, order = 99))
public class Vip implements CalPrice {

    public Double calPrice(Double originalPrice) {
        return originalPrice * 0.8;
    }

}
