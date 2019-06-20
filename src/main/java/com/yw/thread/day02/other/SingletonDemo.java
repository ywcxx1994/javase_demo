package com.yw.thread.day02.other;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @author:YanWei
 * @date: 2019/5/15 14:14
 * @desc: 单例模式的countdownlatch
 */
public class SingletonDemo {
    private static SingletonDemo singleton;

    public static SingletonDemo getInstance() {
        if (singleton == null) {
            singleton = new SingletonDemo();
        }
        return singleton;
    }

    /**
     * 测试100个线程获取单例类，会不会出现线程安全问题，使用CountDownLatch模拟了并行
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Set<String> classNames = Collections.synchronizedSet(new HashSet<>());
        CountDownLatch cdl = new CountDownLatch(1);
        ExecutorService executorService = new ThreadPoolExecutor(100, 100,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        //该线程会自动阻塞。
                        cdl.await();
                        String name = SingletonDemo.getInstance().toString();
                        System.out.println(Thread.currentThread().getName() + "获取对象实例" + name);
                        classNames.add(name);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        //主线程睡眠保证上面100个线程都有机会阻塞
        Thread.sleep(1000);
        //countDownLatch减1为0，则阻塞的线程同时执行，模拟并行操作。
        cdl.countDown();
        //主线程再次睡眠，保证每一个线程获取到单例方法。
        Thread.sleep(1000);
        //关闭线程池
        executorService.shutdown();
        System.out.println(classNames.size());
    }
}
