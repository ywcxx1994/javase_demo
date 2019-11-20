package com.yw.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 18765 on 2019/9/25 9:24
 * 可重入，可中断，可限时（tryLock(),某一时间拿不到锁，就不拿了）,可设置公平（构造方法）
 */
public class ReentrantLockDemo implements Runnable{
    private ReentrantLock lock = new ReentrantLock(true);
    private int count=0;
    @Override
    public void run() {
        fair();
//        shareVariables();
//        tryLockDemo();
    }

    public static void main(String[] args) throws Exception {
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        Thread t1 = new Thread(reentrantLockDemo,"A");
        Thread t2 = new Thread(reentrantLockDemo,"B");
        t1.interrupt();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }


    /**
     * 可公平，A,B线程轮流获取锁，构造函数指定公平，性能比较差，排队问题，默认不公平
     */
    private void fair(){
        while (true){
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"线程获取到锁");
            }finally {
                lock.unlock();
            }

        }
    }
    /**
     *   可限时，等待多久获取不到锁就干别的
     */
    private void tryLockDemo(){
        try {
           if(lock.tryLock(1, TimeUnit.SECONDS)){
               System.out.println(Thread.currentThread().getName()+"获取锁");
                Thread.sleep(2000);
           }else{
               System.out.println(Thread.currentThread().getName()+"获取锁失败");
           }
        } catch (InterruptedException e) {
            //isHeldByCurrentThread()的意义是，当没有获取到锁执行该方法时，会抛出异常，
           if(lock.isHeldByCurrentThread()){
               lock.unlock();
           }
        }
    }

    /**
     * 可重入：获取了两次，释放了两次
     * 线程安全
     */
    private void shareVariables() {
        for (int i = 0; i <10000 ; i++) {
            lock.lock();
            lock.lock();
            try{
                count++;
            }finally {
                lock.unlock();
                lock.unlock();
            }
        }
    }


}
