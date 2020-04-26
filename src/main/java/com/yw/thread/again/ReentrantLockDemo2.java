package com.yw.thread.again;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 18765 on 2020/3/18 21:34
 */
public class ReentrantLockDemo2 {
    private static Lock lock = new ReentrantLock();
    private static Lock lock2 = new ReentrantLock();
    static class Task implements Runnable{
        public Task(int value) {
            this.value = value;
        }

        int value ;
        @Override
        public void run() {
            if(value ==1){
                try {
                    lock.lockInterruptibly();
                    TimeUnit.MILLISECONDS.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
                try {
                    lock2.lockInterruptibly();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock2.unlock();
                }

            }else {
                try {
                    lock2.lockInterruptibly();
                    TimeUnit.MILLISECONDS.sleep(20);
                    lock.lockInterruptibly();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Task task1 = new Task(1);
        Task task2 = new Task(2);
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();
        TimeUnit.MILLISECONDS.sleep(100);
        t2.interrupt();
    }
}
