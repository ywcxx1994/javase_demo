/**
 * @Company JBINFO
 * @Title: Face.java
 * @Package com.yw.innerClass
 * @author Yan Wei
 * @date 2017年12月27日 下午4:35:08
 * @version V1.0
 */
package com.yw.base;

/**
 * @ClassName: Face
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yan Wei
 */
public class InnerClassDemo {
    private String type = "outer";

    //成员非静态内部类
    class Nose {
        private String type = "inner";

        public void breath() {
            //访问外部类的type
            System.out.println(InnerClassDemo.this.type);
            //访问本身
            System.out.println(this.type);
            System.out.println("nose breathing");
        }
    }

    //静态内部类
    static class Ear {
        public void listen() {
            System.out.println("static class listan");
        }
    }

    public static void main(String[] args) {
        //普通内部类必须依赖外部类，所以创建对象时先创建外部类对象，在创建内部类对象
        InnerClassDemo.Nose nose = new InnerClassDemo().new Nose();
        //静态内部类不依赖，所以直接创建即可
        InnerClassDemo.Ear ear = new Ear();
        ear.listen();
        nose.breath();
    }
}
