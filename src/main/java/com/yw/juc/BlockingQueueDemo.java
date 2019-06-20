package com.yw.juc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author:YanWei
 * @date: 2019/4/28 10:52
 * @desc: 阻塞队列demo
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws Exception {
        Element e = new Element(3000, "3秒后过期");
        BlockingQueue<Element> delayQueue = new DelayQueue<>();
        delayQueue.put(e);
        System.out.println(delayQueue.take().toString());
    }

    static class Element implements Delayed {
        long expired, delay;
        String name;

        public Element(long delay, String name) {
            this.expired = delay + System.currentTimeMillis();
            this.delay = delay;
            this.name = name;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return expired - System.currentTimeMillis();
        }

        @Override
        public int compareTo(Delayed o) {
            return 0;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "expired=" + expired +
                    ", delay=" + delay +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
