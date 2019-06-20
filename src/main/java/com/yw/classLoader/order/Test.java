/**
 * @Company JBINFO
 * @Title: Test.java
 * @Package com.yw.classLoader.order
 * @author Yan Wei
 * @date 2018年1月5日 下午4:17:03
 * @version V1.0
 */
package com.yw.classLoader.order;

/**
 * @ClassName: Test
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yan Wei
 */
public class Test {
    static {
        System.out.println("jvm启动类");
    }

    /**
     * 被动引用
     */
    private static void passiveness() {
        //1:调用类的常
        System.out.println(Person.ADRESS);
        //2:通过数组创建类的引用，不会初始化类
        Person[] p = new Person[2];
        System.out.println(p.length);
        //3：调用父类的静态变量，不会初始化子类，只会初始化父类
        System.out.println(Student.air);
    }

    /*
     * 主动引用的情况,只有主动引用，才会触发类的初始化
     */
    private static void active() throws ClassNotFoundException {
        //1:调用类的静态属性,
        System.out.println(Person.air);
        //2:静态方法
        Person.show();
        //3:Class.forName()
        Class.forName("com.yw.classLoader.order.Person");
        //4：创建对象
        Person p = new Person();
        //5:调用子类，首先初始化父类
        System.out.println(Student.water);
        //被jvm标注为启动类的类(main函数所在类)
    }

    public static void main(String[] args) throws Exception {
        //active();
        //passiveness();
    }

}
