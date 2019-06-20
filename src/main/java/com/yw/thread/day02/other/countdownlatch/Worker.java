/**
 * @Company JBINFO
 * @Title: Worker.java
 * @Package com.yw.thread.day02.other.countdownlatch
 * @author Yan Wei
 * @date 2018年6月6日 上午8:10:15
 * @version V1.0
 */
package com.yw.thread.day02.other.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: Worker
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yan Wei
 */
public class Worker implements Runnable {
    //工作者名
    private String name;
    //工作时间
    private long time;

    private CountDownLatch countDownLatch;

    public Worker(String name, long time, CountDownLatch countDownLatch) {
        this.name = name;
        this.time = time;
        this.countDownLatch = countDownLatch;
    }

    /**
     * <p>Description: </p>
     * @author Yan Wei
     * @date 2018年6月6日 上午8:10:15
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {

        try {
            System.out.println(name + "开始工作");
            Thread.sleep(time);
            System.out.println(name + "工作完成，耗费时间=" + time);
            System.out.println("countDownLatch.getCount()=" + countDownLatch.getCount());
            this.countDownLatch.countDown();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
