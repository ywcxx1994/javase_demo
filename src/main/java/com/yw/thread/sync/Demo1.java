package com.yw.thread.sync;

/**
 * @author YanWin
 * @desc 两个线程同时实行1w次i++
 * @date 2019-03-08 10:08
 */
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        //这种写法，即使不加同步关键字，也是线程安全的，相当于单线程的，主线程执行到t1.join()后就会等待t1执行完，然后t2才有机会start
		/*t1.start();
		t1.join();
		t2.start();
		t2.join();*/
        System.out.println(task.a);
    }
}
