package com.yw.thread.pool;

import java.sql.Time;
import java.util.concurrent.*;

/**
 * @author:YanWei
 * @date: 2019/6/10 14:29
 * @desc: Callable测试
 */
public class CallableDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> result = executorService.submit(new CallableTask());
        Thread.sleep(1000);
        System.out.println("主线程在执行任务");
        try {
            System.out.println("task运行结果" + result.get(2000, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("所有任务执行完毕");
        executorService.shutdown();
    }
}

class CallableTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        int sum = 0;
        Thread.sleep(1000);
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return sum;
    }
}