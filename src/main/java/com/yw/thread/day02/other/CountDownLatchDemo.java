/**
 * @Company JBINFO
 * @Title: CountDownLatchDemo.java
 * @Package com.yw.thread.day02.other
 * @author Yan Wei
 * @date 2018年6月6日 上午8:08:55
 * @version V1.0
 */
package com.yw.thread.day02.other;

import java.util.concurrent.CountDownLatch;

import com.yw.thread.day02.other.countdownlatch.Worker;

/**
 * @ClassName: CountDownLatchDemo
 * @Description: CountDownLatch实现共享锁，
 * 模拟worker2等待0和1执行完毕才开始执行。
 * @author Yan Wei
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Worker worker0 = new Worker("worker0", (long) (Math.random() * 2000 + 3000), countDownLatch);
        Worker worker1 = new Worker("worker1", (long) (Math.random() * 2000 + 3000), countDownLatch);
        Worker worker2 = new Worker("worker2", (long) (Math.random() * 2000 + 3000), countDownLatch);
        new Thread(worker0).start();
        new Thread(worker1).start();
        countDownLatch.await();
        new Thread(worker2).start();
    }
}
