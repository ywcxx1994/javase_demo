package com.yw.thread.communication.improve;

public class Input implements Runnable {

    Resource r;

    public Input(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.set("烤鸡");
        }
    }

}
