package com.yw.juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 18765 on 2019/11/20 19:38
 */
public class ReentrantLockInterrupt implements Runnable{
    static ReentrantLock lock1 = new ReentrantLock();
    static ReentrantLock lock2 = new ReentrantLock();
    int lockCount;
    @Override
    public void run() {
        try {
            if(lockCount == 1){
                //可相应中断方式获取锁1
                lock1.lockInterruptibly();
                Thread.sleep(500);
                //可相应中断方式获取锁2
                lock2.lockInterruptibly();
            }else{
                //可相应中断方式获取锁1
                lock2.lockInterruptibly();
                Thread.sleep(500);
                //可相应中断方式获取锁2
                lock1.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if(lock1.isHeldByCurrentThread()){
                lock1.unlock();
            }
            if(lock2.isHeldByCurrentThread()){
                lock2.unlock();
            }
            System.err.println(Thread.currentThread().getId() + "退出！");
        }
    }

    public static void main(String[] args) throws Exception{
        ReentrantLockInterrupt r1 = new ReentrantLockInterrupt();
        r1.lockCount = 1;
        ReentrantLockInterrupt r2 = new ReentrantLockInterrupt();
        r2.lockCount = 2;
        Thread t1 = new Thread(r1,"A");
        Thread t2 = new Thread(r2,"B");
        t1.start();
        t2.start();
//        Thread.sleep(1000);
//        t1.interrupt();
    }
}
