package com.yw.thread.pool;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author:YanWei
 * @date: 2019/6/6 16:07
 * @desc: 线程池测试
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor
                = new ThreadPoolExecutor(5,10,200, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));
        //当把i设置为20时，会出发ThreadPoolExecutor的拒绝策略。
       for(int i=0;i<15;i++){

            Task task = new Task(i);
            threadPoolExecutor.execute(task);
            System.out.println("线程池中线程数目："+threadPoolExecutor.getPoolSize()+
                    "，队列中等待执行的任务数目："+threadPoolExecutor.getQueue().size()+"，已执行的任务数目："+threadPoolExecutor.getCompletedTaskCount());
        }
        threadPoolExecutor.shutdown();
    }

}
class Task implements Runnable{

    int taskNum;

    public Task(int taskNum){
        this.taskNum = taskNum;
    }
    @Override
    public void run() {
        System.out.println("正在执行："+taskNum);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行完毕："+taskNum);
    }
}