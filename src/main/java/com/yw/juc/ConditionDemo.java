package com.yw.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现类似object类的wait()和notify()，notifyAll()方法，
 *
 * Condition只能在lock后使用，通过ReentrantLock对象获取。
 * Created by 18765 on 2019/11/18 14:56ThreadPoolDemo
 */
public class ConditionDemo {

    static ReentrantLock lock = new ReentrantLock();

    static Condition condition = lock.newCondition();

    public static void main(String[] args) throws Exception{
        lock.lock();
        new Thread(()->{
            System.out.println("before:"+Thread.currentThread().getName());
            lock.lock();
            System.out.println("after:"+Thread.currentThread().getName());
            try{
                condition.signal();
                System.out.println("子线程通知");
            }finally {
                lock.unlock();
                System.out.println("子线程释放锁");
            }
        },"child").start();
        try {
            System.out.println("主线程等待通知");
            //类比wait()方法，主线程执行到这里会释放锁，子线程才有机会获取到锁。
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("主线程释放锁");
        }
        System.out.println("主线程恢复进行");
    }
}
