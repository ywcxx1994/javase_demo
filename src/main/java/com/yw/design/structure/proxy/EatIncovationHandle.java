/**
 * @Company JBINFO
 * @Title: EatIncovationHandle.java
 * @Package com.yw.design.pattern.proxy
 * @author Yan Wei
 * @date 2017年12月23日 上午10:39:11
 * @version V1.0
 */
package com.yw.design.structure.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName: EatIncovationHandle
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yan Wei
 */
public class EatIncovationHandle implements InvocationHandler {
    //目标对象
    private Object target;
    //辅助对象
    private Assistant assistant;
    private BeforAssistant bassis;

    public EatIncovationHandle(Object target, Assistant assistant, BeforAssistant bassis) {
        this.target = target;
        this.assistant = assistant;
        this.bassis = bassis;
    }

    /**
     * <p>Description: </p>
     * @author Yan Wei
     * @date 2017年12月23日 上午10:39:34
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (1 == 1) {
            bassis.before();
            assistant.wash();
            method.invoke(target, args);
            assistant.clean();
        }
        return null;

    }

}
