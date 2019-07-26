package com.yw.thread.blockqueue.delay;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        DelayQueue<DelayTask> queue = new DelayQueue();
        queue.add(new DelayTask("1", 5L, TimeUnit.SECONDS));
        queue.add(new DelayTask("2", 2L, TimeUnit.SECONDS));
        queue.add(new DelayTask("3", 3L, TimeUnit.SECONDS));
        queue.add(new DelayTask("5", 7L, TimeUnit.SECONDS));
        System.out.println("queue put done");
        while (!queue.isEmpty()){
            try {
                DelayTask task = queue.take();
                System.out.println(task.name + ":" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
