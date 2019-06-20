/**
 * @Company JBINFO
 * @Title: Bank.java
 * @Package com.yw.thread.day01.bank
 * @author Yan Wei
 * @date 2018年4月10日 上午11:56:55
 * @version V1.0
 */
package com.yw.thread.day01.bank;

/**
 * @ClassName: Bank
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yan Wei
 */
public class Bank {
    private int sum;

    public void add(int num) {
        System.out.println(this);
        synchronized (this) {
            sum += num;
            System.out.println("sum = " + sum);
        }
    }
}
