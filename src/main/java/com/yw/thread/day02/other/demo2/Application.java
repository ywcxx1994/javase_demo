/**
 * @Company JBINFO
 * @Title: Application.java
 * @Package com.yw.thread.day02.other.demo2
 * @author Yan Wei
 * @date 2018年6月6日 上午10:16:22
 * @version V1.0
 */
package com.yw.thread.day02.other.demo2;

/**
 * @ClassName: Application
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yan Wei
 */
public class Application {
    public static void main(String[] args) throws Exception {
        ApplicationStartupUtil instance = ApplicationStartupUtil.getInstance();
        boolean result = instance.checkExternalServices();
        System.out.println("External services validation completed !! Result was :: " + result);
    }
}
