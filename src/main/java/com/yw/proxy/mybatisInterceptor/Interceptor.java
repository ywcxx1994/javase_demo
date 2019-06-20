/**
 * @Company JBINFO
 * @Title: Interceptor.java
 * @Package com.yw.proxy.mybatisInterceptor
 * @author Yan Wei
 * @date 2018年1月17日 下午12:48:24
 * @version V1.0
 */
package com.yw.proxy.mybatisInterceptor;

/**
 * @ClassName: Interceptor
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yan Wei
 */
public interface Interceptor {
    /**
     *
     * @Description: 拦截器业务逻辑
     * @author Yan Wei
     * @date 2018年1月17日 下午12:50:43
     */
    Object interceptor(Invocation invocation) throws Exception;

    /**
     *
     * @Description:注册一个目标类
     * @author Yan Wei
     * @date 2018年1月17日 下午2:44:58
     * @param target
     * @return
     */
    Object register(Object target);
}
