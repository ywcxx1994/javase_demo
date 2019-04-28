package com.yw.design.behavior.guanCha;

public class Client {

    public static void main(String[] args) throws Exception {
        Observable observable = new Observable();
        observable.addObserver(new ConcreteObserver1());
        observable.changed();
    }
}
