package com.yw.thread.pool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by 18765 on 2019/9/17 21:23
 */
public class MyselfThreadPool {
    private BlockingQueue<Runnable> taskQueue;
    private List<Runnable> workers;
    private volatile boolean isWorking = true;
    public MyselfThreadPool(int taskCount,int poolCount) {
        if(taskCount<0 || poolCount<0){
            throw new IllegalArgumentException("非法参数");
        }
        this.taskQueue = new LinkedBlockingQueue<>(taskCount);
        this.workers = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < poolCount; i++) {
            Runnable worker = new Worker(this);
            workers.add(worker);
            ((Worker) worker).start();
        }
    }
    public void shutDown(){
        this.isWorking = false;
        for (Runnable thread:this.workers) {
            Thread th = (Thread)thread;
            if(Thread.currentThread().getState().equals(Thread.State.BLOCKED)){
                th.interrupt();
            }
        }
    }

    public boolean submit(Runnable work){
        //线程池关闭后，不能在放入新的任务
       if(this.isWorking){
            return this.taskQueue.offer(work);
       }
       return false;
    }
    private static class Worker extends Thread{

        private MyselfThreadPool myselfThreadPool;

        public Worker(MyselfThreadPool myselfThreadPool){
            this.myselfThreadPool = myselfThreadPool;
        }
        @Override
        public void run() {
            while (true){
                Runnable task = null;
                if(!this.myselfThreadPool.isWorking && this.myselfThreadPool.taskQueue.size()>0){
                    task = myselfThreadPool.taskQueue.poll();
                }else{
                    try {
                        //从队列拿出任务
                        task = myselfThreadPool.taskQueue.take();
                        task.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        MyselfThreadPool myselfThreadPool = new MyselfThreadPool(3,6);
        for (int i = 0; i <3 ; i++) {
            myselfThreadPool.submit(() -> {
                System.out.println("线程运行"+Thread.currentThread().getName());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        myselfThreadPool.shutDown();
    }
}
