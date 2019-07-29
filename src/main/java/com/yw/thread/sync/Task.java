package com.yw.thread.sync;

/**
 * 测试 Class的isAssignableFrom()
 */
public class Task implements Runnable {
    int a = 0;

    public void run() {
        for (int i = 0; i < 10000; i++) {
            a++;
            System.out.println(Thread.currentThread().getName() + "--->" + "执行了a++");
        }
    }

    public static void main(String[] args) throws Exception{
        System.out.println(ClassLoader.getSystemClassLoader());
        Class aClass = ClassLoader.getSystemClassLoader().loadClass("com.yw.thread.sync.Task");
        Class<?> aClass1 = Class.forName("com.yw.thread.sync.Task");
        Class taskClass = Task.class;
        Class objectClass = Object.class;
        System.out.println(aClass == aClass1);
        System.out.println(objectClass == taskClass);
        System.out.println(aClass.isAssignableFrom(aClass1));
    }
}
