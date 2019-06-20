/**
 * @Company JBINFO
 * @Title: Client.java
 * @Package com.yw.thread.day01
 * @author Yan Wei
 * @date 2018年4月9日 下午2:28:04
 * @version V1.0
 */
package com.yw.thread.day01;

/**
 * @ClassName: Client
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yan Wei
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        Demo d1 = new Demo("旺财");
        Demo d2 = new Demo("xuxu");
        d1.start();
        d2.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "main" + i);
        }
    }
}
