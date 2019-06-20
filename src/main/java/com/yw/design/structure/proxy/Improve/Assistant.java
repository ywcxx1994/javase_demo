/**
 * @Company JBINFO
 * @Title: Assistant.java
 * @Package com.yw.design.pattern.proxy
 * @author Yan Wei
 * @date 2017年12月23日 上午10:41:17
 * @version V1.0
 */
package com.yw.design.structure.proxy.Improve;

/**
 * @ClassName: Assistant
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yan Wei
 */
public class Assistant implements EatInterceptor {
    public void clean() {
        System.out.println("吃完饭了，打扫卫生");
    }

    /**
     * <p>Description: </p>
     * @author Yan Wei
     * @date 2017年12月23日 下午5:07:06
     * @see com.yw.design.pattern.proxy.Improve.EatInterceptor#interceptor()
     */
    @Override
    public void interceptor() {
        // 通知
        this.clean();
    }
}
