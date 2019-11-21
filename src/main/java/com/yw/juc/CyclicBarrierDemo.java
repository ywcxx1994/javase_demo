package com.yw.juc;

import java.util.concurrent.*;

/**
 * Created by 18765 on 2019/11/21 11:31
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) throws Exception{
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        ExecutorService executorService =
                new ThreadPoolExecutor(5,20,0, TimeUnit.SECONDS,new ArrayBlockingQueue<>(1024));
        for (int i = 0; i <20 ; i++) {
            executorService.execute(()->{
                try {

                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName()+"阻塞");
                    Thread.sleep(1000);

                    System.out.println(Thread.currentThread().getName()+"执行\t"+((ThreadPoolExecutor) executorService).getQueue().size());
                } catch (Exception e) {
                }
            });
        }
        Thread.sleep(1000);
        executorService.shutdown();
    }
}
