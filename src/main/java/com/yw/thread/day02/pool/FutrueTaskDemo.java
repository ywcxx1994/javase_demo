/**
 * @Company JBINFO
 * @Title: Test.java
 * @Package com.yw.thread.day02.pool
 * @author Yan Wei
 * @date 2018年5月22日 下午1:42:38
 * @version V1.0
 */
package com.yw.thread.day02.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @ClassName: Test
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yan Wei
 */
public class FutrueTaskDemo {
    public static void main(String[] args) throws Exception {
        Callable<String> task1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                for (int i = 0; i < 100; i++) {
                    System.out.println("i=" + i);
                }
                return null;
            }

        };
        Callable<String> task2 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                for (int i = 0; i < 100; i++) {
                    System.out.println("j=" + i);
                }
                return null;
            }

        };
        //封装任务
        FutureTask<String> ft1 = new FutureTask<>(task1);
        FutureTask<String> ft2 = new FutureTask<>(task2);
        //开启线程，执行任务
        new Thread(ft1).start();
        new Thread(ft2).start();
        //获取执行结果
        ft1.get();//get 会导致阻塞，直到消费者执行完毕。LockSupport.unpark();
        ft2.get();
        //这两个任务会先执行，执行完在执行主线程
    }
}
