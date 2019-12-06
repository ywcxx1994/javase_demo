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


    private static int value;


    public static void main(String[] args) {
         ReentrantLock lock = new ReentrantLock();
         ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
         Lock readLock = readWriteLock.readLock();
         Lock writeLock = readWriteLock.writeLock();
        Runnable read = ()->{
            try {
                readLock.lock();
                System.out.println(Thread.currentThread().getName()+value);
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                readLock.unlock();
            }
        };
        Runnable write = ()->{
            writeLock.lock();
            try {
                ReadWriteLockDemo.value = new Random().nextInt(100);
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                writeLock.unlock();
            }
        };
        int j=0;
        for (int i = j; i < 18; j++) {
            new Thread(read,"t"+i).start();
        }
        for (int i =j ; i <= 20; j++) {
            new Thread(read,"t"+i).start();
        }
    }
}
