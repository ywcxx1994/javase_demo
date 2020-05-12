package com.yw.juc;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by 18765 on 2020/4/26 23:04
 * @desc:
 *  Semaphore semaphore = new Semaphore(4);
 *      可以理解为停车场，new Semaphore(4)相当于申请了4个车位
 *  semaphore.acquire(2);
 *      相当于车比较大，一次占用两个车位，所以一次只允许两个车进入，2个并发
 *  semaphore.acquire(1);
 *      车是正常车，一次占用一个车位，则一次可以允许四辆车进入。4个并发
 *  semaphore.release(2),一次释放2个车位。
 *
 *  如果 acquire 的数量大于 release 的数量，则通路迟早会被使用完，如果线程比较多，得不到后续运行，出现线程堆积内存，最终java进程崩掉；
 *  如果 acquire 的数量小于 release 的数量，就会出现并发执行的线程越来越多（换句话说，处理越来越快），最终也有可能出现问题。
 */
public class SemaphoreDemo {
    static Semaphore semaphore = new Semaphore(4);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i <10 ; i++) {
            executorService.submit(()->{
                try {
                    semaphore.acquire(2);
                    System.out.println(LocalDateTime.now());
                    TimeUnit.SECONDS.sleep(1);
                    semaphore.release(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}
