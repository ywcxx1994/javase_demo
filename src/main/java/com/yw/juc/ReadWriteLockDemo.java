package com.yw.juc;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by 18765 on 2019/12/6 9:09
 */
public class ReadWriteLockDemo {

    private static ReentrantLock lock = new ReentrantLock();
    private static  ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();
    private int value;

    public Object handleRead(Lock lock) throws InterruptedException {
       try{
           lock.lock();
           Thread.sleep(1000);
           return value;
       }finally {
           lock.unlock();
       }
    }
    public void  handlerWrite(Lock lock,int index) throws InterruptedException {
        try{
            lock.lock();
            Thread.sleep(1000);
            value = index;
        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();
        Runnable read = ()->{
            try {
                System.out.println(readWriteLockDemo.handleRead(readLock));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable write = ()->{
            try {
                readWriteLockDemo.handlerWrite(writeLock,new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        for (int i = 0; i < 18; i++) {
            new Thread(read,"t"+i).start();
        }
        for (int i =18 ; i < 20; i++) {
            new Thread(read,"t"+i).start();
        }
    }
}
