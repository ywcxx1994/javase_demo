package com.yw.thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author:YanWei
 * @date: 2019/6/10 13:59
 * @desc: 阻塞队列实现生产者消费者模型
 */
public class BlockQueueDemo {
    private int queueSize=10;
    private BlockingQueue queue = new ArrayBlockingQueue(queueSize);

    public static void main(String[] args) {
        BlockQueueDemo blockQueueDemo = new BlockQueueDemo();
        Producer producer = blockQueueDemo.new Producer(blockQueueDemo.queue);
        Consumer consumer = blockQueueDemo.new Consumer(blockQueueDemo.queue);
        producer.start();
        consumer.start();
    }
    class Producer extends Thread{
        private BlockingQueue queue;
        Producer(BlockingQueue queue){
            this.queue = queue;
        }
        @Override
        public void run() {
            product();
        }
        private void product(){
            while (true){
                try {
                    queue.put(1);
                    System.out.println("向队列取中插入一个元素，队列空间："+queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class Consumer extends Thread{
        private BlockingQueue queue;
        Consumer(BlockingQueue queue){
            this.queue = queue;
        }
        @Override
        public void run() {
            consume();
        }
        private void consume(){
            while(true){
                try {
                    queue.take();
                    System.out.println("从队列取走一个元素，队列剩余"+queue.size()+"个元素");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
