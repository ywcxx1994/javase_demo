package com.yw.design.behavior.guanCha;

public class ConcreteObserver1 implements Observer{


    public void update(Observable o) {
        System.out.println("�۲���1�۲쵽" + o.getClass().getSimpleName() + "�����仯");
        System.out.println("�۲���1������Ӧ");
    }

}
