package com.yw.thread.other;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author:YanWei
 * @date: 2019/7/30 20:22
 * @desc:
 * callable: 可以返回多线程执行的结果
 * future: 用来获取返回值
 * 使用futrue,可以异步的获取另一个任务的返回值，比如任务1执行要10s，任务2执行要5秒，那么总时间不是15秒，取决于时间长的那个，也就是10s左右
 */
public class CallableFutureDemo {
    public static void main(String[] args) {
        CallableFutureDemo.demo3();
    }

    /**
     * 手动创建线程，执行异步任务
     */
    public static void  demo1(){
        long t1 = System.currentTimeMillis();
        //带有返回值的线程对象
        Callable callable = () -> {
            Thread.sleep(10000);
            return 2;
        };
        //获取执行结果
        FutureTask<Integer> futureTask = new FutureTask(callable);
        //开启线程执行
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            //主线程执行，和上边的callable模拟2个线程
            Thread.sleep(3000);
            //会一直阻塞
            Integer integer = futureTask.get();
            Integer calc = 10+integer;
            System.out.println("计算结果："+calc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long t2 = System.currentTimeMillis();
        System.out.println("耗时"+(t2-t1));
    }

    /**
     * 使用线程池完成任务，submit可以获取返回值，execute不能获取返回值
     */
    public static void  demo2(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        long t1 = System.currentTimeMillis();
        Callable callable = () -> {
            System.out.println(Thread.currentThread().getName()+"运行");
            Thread.sleep(5000);
            return 2;
        };
        Callable callable2 = () -> {
            System.out.println(Thread.currentThread().getName()+"运行");
            Thread.sleep(4000);
            return 2;
        };
        Future submit = executorService.submit(callable2);
        FutureTask<Integer> futureTask = new FutureTask(callable);
        executorService.submit(futureTask);
        try {
            Thread.sleep(1000);
            Integer integer = futureTask.get();
            Integer integer2 =(Integer) submit.get();
            Integer calc = 10+integer+integer2;
            System.out.println("计算结果："+calc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long t2 = System.currentTimeMillis();
        System.out.println("耗时"+(t2-t1));
    }

    public static void demo3(){
        long t1 = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future> list = new ArrayList<>();
        Integer result = 0;
        for (int i = 0; i < 5 ; i++) {
            Future future = executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName()+"运行");
                Thread.sleep(5000);
                return 2;
            });
            list.add(future);
        }
        try {
            for (int i = 0; i <list.size() ; i++) {
                result += (Integer) list.get(i).get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
        long t2 = System.currentTimeMillis();
        System.out.println("耗时"+(t2-t1));
    }
}
