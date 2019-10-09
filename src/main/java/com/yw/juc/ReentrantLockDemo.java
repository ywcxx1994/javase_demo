package com.yw.juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 18765 on 2019/9/25 9:24
 * 可重入，可中断，可限时（tryLock(),某一时间拿不到锁，就不拿了）,可设置公平（构造方法）
 */
public class ReentrantLockDemo implements Runnable{
    private ReentrantLock lock = new ReentrantLock();
    private int count=0;
    @Override
    public void run() {
        for (int i = 0; i <10000 ; i++) {
            lock.lock();
            try{
                count++;
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        Thread t1 = new Thread(reentrantLockDemo);
        Thread t2 = new Thread(reentrantLockDemo);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(reentrantLockDemo.count);
    }
}
