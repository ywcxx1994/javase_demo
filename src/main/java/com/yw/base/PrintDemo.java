package com.yw.base;

/**
 * 两个线程交替打印奇偶数
 * Created by 18765 on 2019/11/22 10:23
 */
public class PrintDemo {
    static Object obj = new Object();
    static  volatile  int a =1;
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            while (a < 100){
                synchronized (obj){
                    if(a%2==1){
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName()+"\t"+a++);
                    obj.notifyAll();
                }
            }

        },"A");
        Thread t2 = new Thread(()->{
            while (a < 100){
                synchronized (obj){
                    if(a%2==0){
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName()+"\t"+a++);
                    obj.notifyAll();
                }
            }


        },"B");
        t1.start();
        t2.start();
    }
}
