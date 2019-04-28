package com.yw.design.behavior.guanCha;

import java.util.ArrayList;
import java.util.List;

public class Observable {
		List<Observer> observers = new ArrayList<Observer>();
	    
	    public void addObserver(Observer o){
	        observers.add(o);
	    }
	    
	    public void changed(){
	        System.out.println("���Ǳ��۲��ߣ����Ѿ������仯��");
	        notifyObservers();//֪ͨ�۲��Լ������й۲���
	    }
	    
	    public void notifyObservers(){
	        for (Observer observer : observers) {
	            observer.update(this);
	        }
	    }
}
