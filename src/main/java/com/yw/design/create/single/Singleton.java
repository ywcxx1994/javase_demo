package com.yw.design.create.single;

/**
 * 懒汉式单利模式
 *
 * @author Administrator
 */
public class Singleton {
    //懒汉式
    private static Singleton singleton;

    private Singleton() {
    	/*if(singleton!=null) {
    		//避免反射创建对象
    		throw new RuntimeException("reflect is rejection");
    	}*/
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}