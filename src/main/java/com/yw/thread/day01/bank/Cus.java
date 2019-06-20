/**
 * @Company JBINFO
 * @Title: Cus.java
 * @Package com.yw.thread.day01.bank
 * @author Yan Wei
 * @date 2018年4月10日 上午11:58:17
 * @version V1.0
 */
package com.yw.thread.day01.bank;

/**
 * @ClassName: Cus
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yan Wei
 */
public class Cus implements Runnable {

    private Bank bank;

    public Cus(Bank bank) {
        super();
        this.bank = bank;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            bank.add(100);
        }
    }

}
