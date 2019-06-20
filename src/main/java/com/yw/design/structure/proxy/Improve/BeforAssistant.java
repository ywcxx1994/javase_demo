/**
 * @Company JBINFO
 * @Title: BeforAssistant.java
 * @Package com.yw.design.pattern.proxy
 * @author Yan Wei
 * @date 2017年12月23日 下午4:58:37
 * @version V1.0
 */
package com.yw.design.structure.proxy.Improve;

/**
 * @ClassName: BeforAssistant
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yan Wei
 */
public class BeforAssistant implements EatInterceptor {

    /**
     * <p>Description: </p>
     * @author Yan Wei
     * @date 2017年12月23日 下午5:06:32
     * @see com.yw.design.pattern.proxy.Improve.EatInterceptor#interceptor()
     */
    // 通知
    @Override
    public void interceptor() {
        System.out.println("准备热水,然后洗手");
    }
}
