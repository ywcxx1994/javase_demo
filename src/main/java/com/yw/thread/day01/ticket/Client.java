/**
 * @Company JBINFO
 * @Title: Client.java
 * @Package com.yw.thread.day01
 * @author Yan Wei
 * @date 2018年4月9日 下午2:28:04
 * @version V1.0
 */
package com.yw.thread.day01.ticket;

/**
 * @ClassName: Client
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yan Wei
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        Ticket target = new Ticket();
        for (int i = 0; i < 2; i++) {
            new Thread(target).start();
        }
    }
}
