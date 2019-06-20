package com.yw.thread.communication.improve;

public class Test {
    public static void main(String[] args) {
        Resource r = new Resource();

        Input i = new Input(r);

        Output o = new Output(r);

        Thread t0 = new Thread(i);
        Thread t1 = new Thread(i);
        Thread t2 = new Thread(o);
        Thread t3 = new Thread(o);
        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }
}
