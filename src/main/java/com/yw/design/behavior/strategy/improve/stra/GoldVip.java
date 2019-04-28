/**
* @Company JBINFO   
* @Title: GoldVip.java 
* @Package com.yw.design.behavior.strategy.improve.stra 
* @author Yan Wei   
* @date 2018年3月26日 上午11:56:25 
* @version V1.0   
*/ 
package com.yw.design.behavior.strategy.improve.stra;

import com.yw.design.behavior.strategy.CalPrice;
import com.yw.design.behavior.strategy.improve.anno.TotalValidRegion;
import com.yw.design.behavior.strategy.improve.anno.ValidRegion;

/** 
* @ClassName: GoldVip 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
@TotalValidRegion(@ValidRegion(min=3000,order=99))
public class GoldVip implements CalPrice{

    public Double calPrice(Double originalPrice) {
        return originalPrice * 0.5;
    }

}
