package com.yw.base;

import java.util.concurrent.*;

/**
 * Created by 18765 on 2019/9/24 20:48
 */
public class CallableDemo {
    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,10,1000L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>());
    public static void main(String[] args) throws Exception {
        Long startTime = System.currentTimeMillis();
        CallableDemo callable = new CallableDemo();
        Long endTime = threadPool(callable);
        System.out.println("总耗时："+(endTime-startTime)/1000+"秒");

    }

    private static Long threadPool(CallableDemo callable) throws InterruptedException, ExecutionException {
        Future<Integer> submit = threadPoolExecutor.submit(() -> callable.calc1());
        Future<Integer> submit2 = threadPoolExecutor.submit(() -> callable.calc2());
        Integer integer3 = submit.get();
        Integer integer4 = submit2.get();
        System.out.println(integer3+integer4);
        Long endTime = System.currentTimeMillis();
        threadPoolExecutor.shutdown();
        return endTime;
    }

    private static void manualExec(CallableDemo callable) throws InterruptedException, ExecutionException {
        FutureTask<Integer> future = new FutureTask<>(() -> callable.calc1());
        FutureTask<Integer> future2 = new FutureTask<>(() -> callable.calc2());
        new Thread(future).start();
        new Thread(future2).start();
        Integer integer1 = future.get();
        Integer integer2 = future2.get();
        System.out.println(integer1+integer2);
    }

    public Integer calc1(){
        try {
            Thread.sleep(1000L);
            return 1+2;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public Integer calc2(){
        try {
            Thread.sleep(3000L);
            return 1+2;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
