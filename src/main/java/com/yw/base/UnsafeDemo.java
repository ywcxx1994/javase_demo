package com.yw.base;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author:YanWei
 * @date: 2019/8/19 15:08
 * @desc: unsafe
 */
public class UnsafeDemo {
    public static void main(String[] args) throws Exception {
//        Unsafe unsafe = Unsafe.getUnsafe();
//        System.out.println(unsafe.toString());
        //反射获取unsafe
//        Class<?> aClass = Class.forName("sun.misc.Unsafe");
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe)field.get(null);
        System.out.println(unsafe);
    }
}
