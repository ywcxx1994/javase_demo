package com.yw.thread.again;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by 18765 on 2020/3/18 21:47
 */
public class LockSupportDemo {
    private static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            synchronized (object){
                System.out.println(Thread.currentThread().getName()+"in");
                LockSupport.park();
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("中断");
                }
                System.out.println(Thread.currentThread().getName()+"执行完毕");
            }
        };
        Thread t1 = new Thread(runnable,"t1");
        Thread t2 = new Thread(runnable,"t2");
        t1.start();
        TimeUnit.SECONDS.sleep(5);
        LockSupport.unpark(t1);
        t2.start();
        t1.interrupt();
        LockSupport.unpark(t2);
    }
}
