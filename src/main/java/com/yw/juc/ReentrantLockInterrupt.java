package com.yw.juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程A获取到lock1，睡眠半秒。线程B获取到lock2,睡眠半秒。A 醒来获取lock2,由于B持有lock2,等待。B醒来获取lock1，由于A持有lock1,故产生死锁
 * 主线程睡一秒为了确保死锁。虽然创建了两个任务对象r1,r2,由于锁是静态的，故无论创建多少对象，都是使用的同一把锁。
 * 由于加锁方式是可相应中断的( lockInterruptibly() )，当主线程执行中断A线程时，A释放lock1,不继续等待lock2,B获取到lock1,执行完毕释放，本身持有的lock2完成也释放。
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
            //响应中断后会被cache住
            System.out.println(Thread.currentThread().getName()+"中断");
//            e.printStackTrace();
        }finally {
            if(lock1.isHeldByCurrentThread()){
                System.out.println("lock1"+"释放锁");
                lock1.unlock();
            }
            if(lock2.isHeldByCurrentThread()){
                System.out.println("lock2"+"释放锁");
                lock2.unlock();
            }
//            System.err.println(Thread.currentThread().getName() + "退出！");
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
        Thread.sleep(1000);
        t1.interrupt();
    }
}
