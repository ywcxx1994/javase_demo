package com.yw.thread.other;

/**
 *
 * 模拟了死锁的情况：
 * t1首先获取到o1这把锁，然后睡眠一秒，是为了t2线程能启动，t2启动后获取到o2这把锁，然后t1睡眠结束，
 * 在同步中又获取o2这把锁，此时o2被t2线程占用，故t1暂停，t2睡眠一秒后获取o1,此时
 * o1锁被t1占用，造成了互相等待，产生死锁。
 * Created by 18765 on 2019/11/13 10:54
 */
public class DeadLockDemo {
    private  static Object object1 = new Object();
    private  static Object object2 = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (object1){
                try {
                    System.out.println("get resource1");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                synchronized (object2){
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        },"T1").start();
        new Thread(()->{
            synchronized (object2){
                try {
                    System.out.println("get resource2");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource1");
                synchronized (object1){
                    System.out.println(Thread.currentThread() + "get resource1");
                }
            }
        },"T2").start();
    }
}
