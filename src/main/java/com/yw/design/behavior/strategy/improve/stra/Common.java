/**
 * @Company JBINFO
 * @Title: Common.java
 * @Package com.yw.design.behavior.strategy.improve.stra
 * @author Yan Wei
 * @date 2018年3月26日 上午11:54:00
 * @version V1.0
 */
package com.yw.design.behavior.strategy.improve.stra;

import com.yw.design.behavior.strategy.CalPrice;
import com.yw.design.behavior.strategy.improve.anno.TotalValidRegion;
import com.yw.design.behavior.strategy.improve.anno.ValidRegion;

/**
 * @ClassName: Common
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yan Wei
 */
@TotalValidRegion(@ValidRegion(max = 1000, order = 99))
public class Common implements CalPrice {

    public Double calPrice(Double originalPrice) {
        return originalPrice;
    }

}
