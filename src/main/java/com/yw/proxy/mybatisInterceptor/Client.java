/**
 * @Company JBINFO
 * @Title: Client.java
 * @Package com.yw.proxy.mybatisInterceptor
 * @author Yan Wei
 * @date 2018年1月17日 下午12:53:33
 * @version V1.0
 */
package com.yw.proxy.mybatisInterceptor;

import com.yw.proxy.Coder;
import com.yw.proxy.JavaCoder;

/**
 * @ClassName: Client
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yan Wei
 */
public class Client {
    public static void main(String[] args) {
        Coder coder = new JavaCoder();
        Interceptor interceptor = new MyInterceptor();
        Coder c = (Coder) interceptor.register(coder);
        c.code();
    }
}
