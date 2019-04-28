/**
* @Company JBINFO   
* @Title: TwotDFourH.java 
* @Package com.yw.design.behavior.strategy.improve.stra 
* @author Yan Wei   
* @date 2018年3月26日 上午11:57:27 
* @version V1.0   
*/ 
package com.yw.design.behavior.strategy.improve.stra;

import com.yw.design.behavior.strategy.CalPrice;
import com.yw.design.behavior.strategy.improve.anno.OnceValidRegion;
import com.yw.design.behavior.strategy.improve.anno.ValidRegion;

/** 
* @ClassName: TwotDFourH 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
@OnceValidRegion(@ValidRegion(min=2000,order=40))
public class TwotDFourH implements CalPrice{
    
    public Double calPrice(Double originalPrice) {
        return originalPrice - 400;
    }
    
}

