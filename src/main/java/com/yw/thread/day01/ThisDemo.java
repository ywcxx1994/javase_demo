package com.yw.thread.day01;

/**
 *
 *
 * Created by 18765 on 2019/11/5 14:37
 */
public class ThisDemo {
    private static synchronized void m1(){
        try {
            Thread.sleep(10_00);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static synchronized void m2(){
        try {
            Thread.sleep(10_00);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

//        ThisDemo thisDemo = new ThisDemo();
//        ThisDemo thisDemo2 = new ThisDemo();

        new Thread("T1"){
            @Override
            public void run() {
                ThisDemo.m1();
            }
        }.start();

        new Thread("T2"){
            @Override
            public void run() {
                ThisDemo.m2();
            }
        }.start();
    }
}
