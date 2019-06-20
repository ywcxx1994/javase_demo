/**
 * @Company JBINFO
 * @Title: Client.java
 * @Package com.yw.thread.day01
 * @author Yan Wei
 * @date 2018年4月9日 下午2:28:04
 * @version V1.0
 */
package com.yw.thread.day01.bank;

/**
 * @ClassName: Client
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yan Wei
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        Bank b = new Bank();
        Cus c = new Cus(b);
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}
