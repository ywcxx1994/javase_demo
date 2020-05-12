package com.yw.thread.again;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 18765 on 2020/3/17 21:23
 */
public class ReentrantLockDemo {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    static class Task implements Runnable{
        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println("running");
//                condition.await();
                TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
//                lock.unlock();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread thread1 = new Thread(task,"fuck");
        thread1.start();
        TimeUnit.MILLISECONDS.sleep(2);
        if(!lock.tryLock()){
            System.out.println("主线程没获取到锁");
        }
//        lock.lock();
//        condition.signal();
//        lock.unlock();
    }
}
